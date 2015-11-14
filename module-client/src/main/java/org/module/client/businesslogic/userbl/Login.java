package org.module.client.businesslogic.userbl;

import java.rmi.RemoteException;

import org.module.client.businesslogicservice.user.UserLoginService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.UserVO;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.common.po.UserPO;

public class Login implements UserLoginService {
	private UserDataService user = new RmiClient().getUserDataService();
	public boolean login(UserVO u) {
		try {
			
			UserPO po = user.find(u.getId());
			if(po==null) return false;
			if(po.getPassword().equals(u.getPassword()) &&  po.getRole().equals(u.getRole()))
				return true;
		} catch (RemoteException e) {
			
			e.printStackTrace();
			return false;
		}
		return false;
	}

}
