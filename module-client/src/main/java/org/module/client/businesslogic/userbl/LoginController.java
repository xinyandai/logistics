package org.module.client.businesslogic.userbl;

import org.module.client.businesslogicservice.user.UserLoginService;
import org.module.client.businesslogicservice.userBLservice.UserLoginBLService;
import org.module.client.main.Main;
import org.module.client.vo.UserVO;

public class LoginController implements UserLoginBLService{
	private UserLoginService loginer;
	
	

	public LoginController(UserLoginService loginer) {
		super();
		this.loginer = loginer;
	}



	public boolean login(String id, String password, String role) {
		UserVO userVO = new UserVO(id,password,role);
		Main.currentUser = userVO;
		return loginer.login(userVO);
	}

}
