package org.module.client.businesslogicservice.userBLService_stub;


import org.module.client.businesslogicservice.userBLservice.UserLoginBLService;


public class UserBLService_stub implements UserLoginBLService{


	public boolean login(String id, String password,String role) {
		if(id.equals("admin") && password.equals("admin") && role.equals("管理员"))
			return true;
		return false;
	}

	

}
