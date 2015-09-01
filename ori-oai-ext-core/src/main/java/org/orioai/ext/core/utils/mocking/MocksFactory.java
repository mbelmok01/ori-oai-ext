/**
 * 
 */
package org.orioai.ext.core.utils.mocking;

import org.easymock.IMocksControl;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author http://javadevelopmentforthemasses.blogspot.com/2008/07/mocking-spring-tests.html
 *
 */
@SuppressWarnings("unchecked")
public class MocksFactory implements FactoryBean {

	private Class type;// the created object type
	
	@Autowired
	private IMocksControl mockMaker;

    public void setType(final Class type) {
        this.type = type;
    }

//    public void setMockMaker(IMocksControl mockMaker) {
//		this.mockMaker = mockMaker;
//	}

	@Override
    public Object getObject() throws Exception {
        return mockMaker.createMock(type);
    }

    @Override
    public Class getObjectType() {
        return type;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
	
}
