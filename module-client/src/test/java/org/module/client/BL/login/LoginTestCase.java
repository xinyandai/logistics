/**
 * 
 */
package org.module.client.BL.login;

import junit.framework.TestCase;

import org.module.client.businesslogic.userbl.LoginController;
import org.module.client.businesslogicservice.userBLservice.UserLoginBLService;

/**
 * @author 华硕
 *
 */
public class LoginTestCase extends TestCase {

	/**
	 * Test method for {@link org.module.client.businesslogic.userbl.LoginController#login(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	public void testLogin() {
		UserLoginBLService login  = new LoginController(new LoginMock());
		assert(login.login("admin", "admin", "管理员"));
	}

}
