package org.module.client.businesslogic.userbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.user.UserService;
import org.module.client.businesslogicservice.userBLservice.UserManageBLService;
import org.module.client.vo.UserVO;
import org.module.common.dataservice.MyList;

public class UserManageController implements UserManageBLService {

	private UserService userManager;
	private ArrayList<UserVO> list;
	
	public UserManageController(UserService userManager) {
		super();
		this.userManager = userManager;
	}
	public UserManageController() {
		super();
		this.userManager = new User();
	}
	public boolean delete(String id) {
		return this.userManager.delete(id);
	}
	
	public boolean add(UserVO u) {
		this.list.add(u);
		return this.userManager.add(u);
	}
	
	
	public boolean update(UserVO u) {
		for (UserVO userVO : list) {
			if(userVO.getId().equals(u.getId())){
				userVO.setAuthority(u.getAuthority());
				userVO.setDepartmeny(u.getDepartmeny());
				userVO.setName(u.getName());
				userVO.setPassword(u.getPassword());
				userVO.setRole(u.getRole());
			}
		}
		return this.userManager.update(u);
	}
	
	
	public ArrayList<UserVO> getAll() {
		this.list = this.userManager.getAll();
		return list;
	}
	public boolean delete(int[] indexes) {
		MyList<String> ids = new MyList<String>();
		for(int i = indexes.length-1; i>=0; i--){
			ids.add(this.list.get(indexes[i]).getId());
			this.list.remove(indexes[i]);
		}
		return this.userManager.delete(ids);
	}
	
	
	

}
