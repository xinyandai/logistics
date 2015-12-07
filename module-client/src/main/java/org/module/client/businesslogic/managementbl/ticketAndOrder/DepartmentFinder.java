package org.module.client.businesslogic.managementbl.ticketAndOrder;

import java.rmi.RemoteException;

import org.module.client.javaRMI.RmiClient;
import org.module.common.dataservice.departmentdataservice.DepartmentDataService;
/**
 * 根据部门ID查找部门信息的辅助类
 * @author 
 *
 */
public class DepartmentFinder {
	private DepartmentDataService department = new RmiClient().get(DepartmentDataService.class);
	
	public String getNameById(String id){
		try {
			return this.department.findById(id).getName();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}
	public String getLocationById(String id){
		try {
			return this.department.findById(id).getLocation();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return id;
	}
}
