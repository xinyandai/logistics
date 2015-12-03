package org.module.client.businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.user.UserService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.UserVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.common.po.UserPO;


public class User implements UserService {
	private UserDataService user = new RmiClient().get(UserDataService.class);

	

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
			return user.add(this.voToPo(u));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean update(UserVO u) {
		try {
			return user.update(this.voToPo(u));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	
	public ArrayList<UserVO> getAll() {
		ArrayList<UserVO> re = new ArrayList<UserVO>();
		try {
			ArrayList<UserPO> pos = user.allUsers();
			
			for (UserPO u : pos) {
				re.add(this.poToVo(u));
			}
			return re;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	
   private UserPO voToPo(UserVO u){
	   return new UserPO(u.getId(),u.getName(),u.getPassword(),u.getRole(),
			u.getDepartmeny(),
			u.getAuthority());
   }

   private UserVO poToVo(UserPO u){
	   return new UserVO(u.getId(),u.getName(),u.getPassword(),u.getRole(),
			u.getDepartmeny(),
			u.getAuthority());
   }
   
   public boolean delete(MyList<String> ids) {

	   try {
			return this.user.delete(ids);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return false;
   }

}
