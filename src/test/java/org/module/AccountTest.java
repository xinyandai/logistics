package org.module;

import org.module.client.businesslogic.statisticbl.AccountManageController;
import org.module.server.javaRMI.RmiServer;

import junit.framework.TestCase;

public class AccountTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
		RmiServer  rmi = new RmiServer();
		rmi.user();
		AccountManageController controller = new AccountManageController();
		controller.add("622024561", "102563.45");
		controller.add("622024562", "102563.45");
		controller.add("622024563", "102563.45");
		controller.add("622024564", "102563.45");
		controller.add("622024565", "102563.45");

		controller.delete("622024561");
	}

}
