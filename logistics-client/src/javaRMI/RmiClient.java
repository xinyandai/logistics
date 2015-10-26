package javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.UserDataService;
import businesslogicservice.userBLservice.UserBLservice;
import po.UserPO;

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
