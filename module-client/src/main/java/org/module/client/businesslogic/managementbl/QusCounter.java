package org.module.client.businesslogic.managementbl;

import org.module.client.main.Main;

/**
 * 辅助类
 * 用于获得所有的区号
 * @author 华硕
 *
 */
public class QusCounter {

	private WarehouseConfig config  = new WarehouseConfig();
	public String[] getQus(){
		String[] re = this.config.find(Main.currentUser.getDepartmeny()).getQus();
		return re;
	}
}
