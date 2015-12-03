package org.module.server.data.userdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.common.po.UserPO;
import org.module.server.data.FileHelper;


public class UserDataImpl extends UnicastRemoteObject implements UserDataService {

	public UserDataImpl() throws RemoteException {
	}
	
	private static final long serialVersionUID = 1L;

	
    private FileHelper helper = new FileHelper(new File("file"+File.separator+"user.txt"));
	
	
	public MyList<UserPO> allUsers() {
		MyList<String> ss = this.helper.read();
		MyList<UserPO> re= new MyList<UserPO>();
		for (String string : ss) {
			re.add(new UserPO(string));
		}
		return re;
	}

	public boolean add(UserPO user) {
		return this.helper.add(user);
	}

	public UserPO find(String id) {
		MyList<UserPO> po = this.allUsers();
		for (UserPO userPO : po) {
			if(userPO.getId().equals(id)){
				return userPO;
			}
		}
		return null;
	}

	public boolean delete(String id) {
		MyList<UserPO> po = this.allUsers();
		for (int i = 0; i < po.size(); i++) {
			if(po.get(i).getId().equals(id)){
				po.remove(i);
				return this.helper.rewrite(po);
			}
		}
		return false;
	}

	public boolean update(UserPO old) {
		MyList<UserPO> po = this.allUsers();
		for (int i = 0; i < po.size(); i++) {
			if(po.get(i).getId().equals(old.getId())){
				po.remove(i);
				po.add(old);
				return this.helper.rewrite(po);
			}
		}
		return false;
	}

	public boolean delete(MyList<String> ids) {
		boolean re = true;
		for (String string : ids) {
			re = re && this.delete(string);
		}
		return re;
	}
}


