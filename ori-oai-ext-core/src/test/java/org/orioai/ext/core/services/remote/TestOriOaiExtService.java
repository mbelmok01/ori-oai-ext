/**
 * 
 */
package org.orioai.ext.core.services.remote;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.easymock.EasyMock;
import org.easymock.IMocksControl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.orioai.ext.core.annotations.Mock;
import org.orioai.ext.core.annotations.NotMock;
import org.orioai.ext.core.services.IOriOaiExtService;
import org.orioai.ext.core.services.IWebService;
import org.orioai.ws.ext.beans.WSOperationBean;
import org.orioai.ws.ext.exceptions.OriOaiExtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author neuville
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/applicationContext-testExt.xml")
@Component
public class TestOriOaiExtService {

	@Autowired
	private IMocksControl mockMaker;


	// We cannot use @Autowired here
	// because of the operation executed in
	// AutoBeanDeclarer concerning the "request"
	// scoped beans. After this execution, their is
	// no more beans implementing IOriOaiExtService
	// in the registry, since the aop proxies have been purged 
	@Resource(name="scopedTarget.oriOaiExtService")
	@NotMock
	private IOriOaiExtService extService;

	@Autowired
	@Mock
	private IWebService ws;

	private String wsId = "dummyWS";
	private String wsMethodId = "dummyMethod";
	private Map<String, String> wsParams = new HashMap<String, String>();
	private WSOperationBean opResult = new WSOperationBean();

	@Before
	public void setUp() {
		EasyMock.reset(ws);
	}

	@Test
	public void testExecute() throws OriOaiExtException {
			EasyMock.expect(ws.getWsId()).andReturn(wsId);
			EasyMock.expect(ws.execute(wsMethodId, wsParams)).andReturn(opResult);
			mockMaker.replay();
			extService.execute(wsId, wsMethodId, wsParams);
			mockMaker.verify();
	}
}
