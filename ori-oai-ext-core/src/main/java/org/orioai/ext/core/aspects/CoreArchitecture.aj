/**
 * 
 */
package org.orioai.ext.core.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


/**
 * @author neuville
 *
 */
@Aspect
public class CoreArchitecture {

	@Pointcut("within(org.orioai.ext.core.services.*)")
	public void inServiceLayer() {}
	
	@Pointcut("execution(public * execute(..))")
	public void coreBusinessService() {}
}
