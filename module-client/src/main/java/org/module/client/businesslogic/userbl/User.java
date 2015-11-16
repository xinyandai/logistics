package org.module.client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.user.UserService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.UserVO;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.common.po.UserPO;


public class User implements UserService {
	private UserDataService user = new RmiClient().getUserDataService();

	

	public boolean delete(String id) {
		try {
			return user.delete(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean add(UserVO u) {
		try {
			return user.add(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(UserVO u) {
		try {
			return user.update(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public ArrayList<UserVO> getAll() {
		try {
			ArrayList<UserPO> pos = user.allUsers();
			ArrayList<UserVO> re = new ArrayList<UserVO>();
			for (UserPO u : pos) {
				re.add(new UserVO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
			}
			return re;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	

	

}
