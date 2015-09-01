/**
 * 
 */
package org.orioai.ext.hal.services.remote;

import java.util.HashMap;

import junit.framework.Assert;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.orioai.ext.core.annotations.Mock;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.core.services.IOriOaiExtService;
import org.orioai.ext.core.services.IWSOperation;
import org.orioai.ext.core.services.IWebService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author neuville
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/applicationContext-testHal.xml")
@Component
public class TestHalWebService {

	@Autowired
	private IMocksControl mockMaker;
	
	/**
	 * Tested service
	 */
	@Autowired
	@Qualifier("hal")
	@NotMock
	private IWebService ws;
	
	/**
	 * Mocked collaborator
	 */
	@Autowired
	@Qualifier("hal")
	@Mock
	private IWSOperation mockOpEx;
	
	/**
	 * Mocked collaborator
	 * (unused here, but needed by {@link HalWebService} (autowiring))
	 */
	@Autowired
	@Mock
	@SuppressWarnings("unused")
	private IOriOaiExtService mockExtService;
	
	private String wsMethodId = "dummyMethod";
	private HashMap<String, String> wsParams = new HashMap<String, String>();
	private WSOperationBean opResult = new WSOperationBean();  
	
	@Test
	public void testGetWsId() {
		Assert.assertEquals("hal", ws.getWsId());
	}

	@Test
	public void testExecute() {
		try {
			EasyMock.expect(mockOpEx.getOpId()).andReturn(wsMethodId);
			EasyMock.expect(mockOpEx.execute(wsParams)).andReturn(opResult);
			mockMaker.replay();
			ws.execute(wsMethodId, wsParams);
			mockMaker.verify();
		} catch (OriOaiExtException e) {
			e.printStackTrace();
		}
	}
}
