package org.orioai.ext.core.exceptions;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/META-INF/spring/applicationContext-testException.xml")
@Component
public class TestExceptions {

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

	private Map<String, Object> wsParams = new HashMap<String, Object>();
	private WSOperationBean opResult = new WSOperationBean();

	@Before
	public void setUp() {
		EasyMock.reset(ws);
	}

	@Test
	public void testExecute() {
//		try {
//			EasyMock.expect(ws.getWsId()).andReturn("existentWS");
//			EasyMock.expect(ws.execute("existentMethod", wsParams)).andReturn(opResult);
//			mockMaker.replay();
//			extService.execute("unExistentWS", "unExistentMethod", wsParams);
//			mockMaker.verify();
//		} catch (OriOaiExtException e) {
//			ExceptionUtils.catchException(e);
//		}
		System.out.println("Dummy OK !!");
	}

}
