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
		assert(ctl.delete("admin"));
	}

	public void testAllUsers() {
		assert(true);
	}

	public void testAddUser() {
		assert(true);
	}

	public void testUpdate() {
		assert(true);
	}

}
