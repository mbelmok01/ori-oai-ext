/**
 * 
 */
package org.orioai.ext.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.orioai.ext.core.utils.mocking.AutoBeanDeclarer;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * A tag to be detected by {@link AutoBeanDeclarer}
 * 
 * @author neuville
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface NotMock {

}
