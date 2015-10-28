package data;

import java.rmi.RemoteException;

import data.userdata.UserDataImpl;
import dataservice.DataFactotyService;

public class DataFactory implements DataFactotyService {


	@Override
	public Object creatDataObject(String s) throws RemoteException {
		if(s.equals("user")){
			return new UserDataImpl();
		}
		return null;
	}

}
