package org.module.client.BL.usermanage;

import junit.framework.TestCase;

import org.module.client.businesslogic.userbl.UserManageController;
import org.module.client.businesslogicservice.userBLservice.UserManageBLService;

public class UserManageTest extends TestCase {
	UserManageBLService ctl;
	protected void setUp() throws Exception {
		super.setUp();
		ctl = new UserManageController(new UserMock());
	}

	

	public void testDeleteUser() {
		assert(ctl.deleteUser("admin"));
	}

	public void testAllUsers() {
		assert(ctl.allUsers().size()>0);
	}

	public void testAddUser() {
		assert(ctl.addUser("admin","admin","管理员"));
	}

	public void testUpdate() {
		assert(ctl.update("admin","admin","管理员"));
	}

}
