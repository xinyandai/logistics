package org.module.client.businesslogic.userbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.user.UserLoginService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.UserVO;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.common.po.UserPO;

public class Login implements UserLoginService {
	private UserDataService user = new RmiClient().get(UserDataService.class);
	public boolean login(UserVO u) {
		try {
			if(u.getRole().equals("用户")){
				u.setAuthority("0");
				u.setDepartmeny("0");
				u.setName("用户");
				return true;
			}
			UserPO po = user.find(u.getId());
			if(po==null) return false;
			if(po.getPassword().equals(u.getPassword()) &&  po.getRole().equals(u.getRole())){
				u.setAuthority(po.getAuthority());
				u.setDepartmeny(po.getDepartmeny());
				u.setName(po.getName());
				return true;
			}
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
