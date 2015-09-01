/**
 * 
 */
package org.orioai.ext.core.utils.mocking;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.orioai.ext.core.annotations.Mock;
import org.orioai.ext.core.annotations.NotMock;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AutowireCandidateQualifier;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * This is a customized version of the class described at the location pointed
 * below. It is declared and used in TEST spring application contexts ONLY.
 * <p>
 * We're using it to customize the spring component scanning process
 * so that it uses our {@link MocksFactory} and thus to be able to combine
 * the use of Spring autowiring with the one of EasyMock testing framework.
 * I had to slightly modify it so that we do not end up with several candidates
 * for autowiring targeting the field declaring the class to be tested in our test classes.
 * </p>
 * <p>
 * It also deals with the "request" scoped beans by setting their scope
 * to "singleton" and purging the bean registry from the aop proxies
 * associated to them. 
 * </p>
 * @see http://javadevelopmentforthemasses.blogspot.com/2008/07/mocking-spring-tests.html
 * @author neuville
 */
@SuppressWarnings({ "unchecked"})
public class AutoBeanDeclarer implements BeanFactoryPostProcessor {

	private Class mocksHolder;
	
	public void setMocksHolder(final Class mocksHolder) {
		this.mocksHolder = mocksHolder;
	}

	/* (non-Javadoc)
	 * @see org.springframework.beans.factory.config.BeanFactoryPostProcessor#postProcessBeanFactory(org.springframework.beans.factory.config.ConfigurableListableBeanFactory)
	 */
	@Override
	public void postProcessBeanFactory(
			ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;
		String[] beanNames = registry.getBeanDefinitionNames();
		for(String name : beanNames) {
			//we don't want request scoped bean in tests
			if(registry.containsBeanDefinition(name))
				registry.getBeanDefinition(name).setScope(BeanDefinition.SCOPE_SINGLETON);
			//let's get rid of the aop proxies
			if(name.startsWith("scopedTarget.")) {
				String realName = name.replaceFirst("scopedTarget\\.", "");
				registry.removeBeanDefinition(realName);
			}
		}	
		for(final Field field : findAllMockableAutoWired()) {
			String qualifVal = (field.getAnnotation(Qualifier.class) != null) ? field.getAnnotation(Qualifier.class).value() : null;
			//Collections and arrays musn't be mocked themselves
			if(!Collection.class.isAssignableFrom(field.getType()) && !field.getType().isArray()) {
				registerOn(registry, field.getType(), qualifVal);	
			}
		}
// DEBUG
//		System.out.println("The factory contains the following beans : ");
//		for(String name : registry.getBeanDefinitionNames())
//			System.out.println(name+" <=> "+registry.getBeanDefinition(name).getBeanClassName());
	}

	private List<Field> findAllMockableAutoWired() {
		return (List<Field>) CollectionUtils.select(Arrays.asList(mocksHolder.getDeclaredFields()), new Predicate() {
			@Override
			public boolean evaluate(Object field) {
				return (((Field) field).isAnnotationPresent(Autowired.class)
						&& !((Field) field).isAnnotationPresent(NotMock.class)
						&& ((Field) field).getType().isInterface());
			}
		});
	}	

	private void registerOn(final BeanDefinitionRegistry registry,final Class type, final String pluginQualifVal) {
		RootBeanDefinition definition = new RootBeanDefinition(MocksFactory.class);
		MutablePropertyValues values = new MutablePropertyValues();
		values.addPropertyValue(new PropertyValue("type", type));
		definition.setPropertyValues(values);
		AutowireCandidateQualifier mockQualif = new AutowireCandidateQualifier(Mock.class);
		//G.N : we qualify the bean delivered by MocksFactory with the "Mock" annotation of ours
		definition.addQualifier(mockQualif);
		if(pluginQualifVal != null) {
			AutowireCandidateQualifier pluginQualif = new AutowireCandidateQualifier(Qualifier.class, pluginQualifVal);
			//G.N : we qualify the bean delivered by the mock factory with the qualifier of the plugin service class actually injected
			definition.addQualifier(pluginQualif);
		}
		StringBuilder buildBeanName = new StringBuilder();
		buildBeanName.append("mocked-");
		buildBeanName.append(pluginQualifVal);
		buildBeanName.append("-");
		buildBeanName.append(type.getSimpleName());
		registry.registerBeanDefinition(buildBeanName.toString(), definition);
	}
}
