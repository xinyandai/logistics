package org.module.server.data;

import java.rmi.RemoteException;

import org.module.common.dataservice.DataFactotyService;
import org.module.server.data.userdata.UserDataImpl;



public class DataFactoty implements DataFactotyService {

	public Object creatDataObject(String s) throws RemoteException {
		if(s.equals("user")){
			return new UserDataImpl();
		}
		return null;
	}


	

}
