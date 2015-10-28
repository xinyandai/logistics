package javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.userdataservice.UserDataService;

public class RmiClient {

	public RmiClient() {	  
	}
	public UserDataService getUserDataService(){
		String url="rmi://127.0.0.1/user";
		UserDataService service;   
		 try {
			service = (UserDataService)Naming.lookup(url);
			return service;
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			e.printStackTrace();
		} 
		 return null;
	}

}
