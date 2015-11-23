package org.module.server.data;

import java.rmi.RemoteException;

import org.module.common.dataservice.DataFactotyService;



public class DataFactoty implements DataFactotyService {

	public Object creatDataObject(String s) throws RemoteException {
		Class<?> dmeo;
		try {
			dmeo = Class.forName("org.module.server.data."+s);
			return dmeo.newInstance();
			 
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}		
		return null;
	}


	

}
