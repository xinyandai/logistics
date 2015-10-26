package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.UserDataService;
import javaRMI.RmiClient;
import po.UserPO;
import vo.UserVO;

public class UserBLImpl implements businesslogicservice.userBLservice.UserBLservice {
	UserDataService user = new RmiClient().getUserDataService();
	@Override
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

	@Override
	public boolean deleteUser(UserVO u) {
		try {
			return user.delete(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addUser(UserVO u) {
		try {
			return user.add(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean update(UserVO u) {
		try {
			return user.update(new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),u.getAuthority()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ArrayList<UserVO> allUsers() {
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
