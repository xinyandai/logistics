package org.module.client.businesslogic.userbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.user.UserService;
import org.module.client.businesslogicservice.userBLservice.UserManageBLService;
import org.module.client.vo.UserVO;

public class UserManageController implements UserManageBLService {

	private UserService userManager;
	public UserManageController(UserService userManager) {
		super();
		this.userManager = userManager;
	}
	public UserManageController() {
		super();
		this.userManager = new User();
	}
	
	public boolean deleteUser(String id) {
		return userManager.deleteUser(id);
	}
	
	public ArrayList<UserVO> allUsers() {
		
		return userManager.allUsers();
	}
	public boolean addUser(String id, String name, String role) {
		return userManager.addUser(new UserVO(id,name,role));
	}
	public boolean update(String id, String name, String role) {
		
		return userManager.update(new UserVO(id,name,role));
	}
	

}
