package org.module.client.BL.usermanage;

import java.util.ArrayList;

import org.module.client.businesslogicservice.user.UserService;
import org.module.client.vo.UserVO;

public class UserMock implements UserService {

	
	public boolean deleteUser(String id) {
		if(id.equals("admin")) return true;
		return false;
	}
	
	public boolean addUser(UserVO u) {
		if(u.getId().equals("admin")) return true;
		return false;
	}
	
	public boolean update(UserVO u) {
		if(u.getId().equals("admin")) return true;
		return false;
	}
	
	public ArrayList<UserVO> allUsers() {
		ArrayList<UserVO> re =  new ArrayList<UserVO>();
		re.add(new UserVO("admin","admin","管理员"));
		return re;
	}
}
