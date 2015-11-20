package org.module.client.BL.login;

import org.module.client.businesslogicservice.user.UserLoginService;
import org.module.client.vo.UserVO;

public class LoginMock implements UserLoginService {

	public LoginMock() {
		// TODO Auto-generated constructor stub
	}

	public boolean login(UserVO u) {
		
		if(u.getId().equals("admin") && u.getPassword().equals("admin") && u.getRole().equals("管理员"))
			return true;
		return false;
	}
}
