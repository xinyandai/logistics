package org.module.server.javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.module.common.dataservice.DataFactotyService;
import org.module.common.dataservice.ticketdataservice.GoDownEntryListService;
import org.module.common.dataservice.userdataservice.UserDataService;
import org.module.server.data.DataFactoty;


public class RmiServer {

	private UserDataService userDataImpl;
	private GoDownEntryListService goDownEntryListImpl;
	private DataFactotyService dataFactory = new DataFactoty();
	public RmiServer() {
		
	}
	public void user(){
		try {
			LocateRegistry.createRegistry(1099);
			
			this.userDataImpl = (UserDataService) dataFactory.creatDataObject("userDataImpl");
			this.goDownEntryListImpl = (GoDownEntryListService)this.dataFactory.creatDataObject("goDownEntryListImpl");
			
			Naming.rebind("rmi://127.0.0.1/user", userDataImpl);
			Naming.rebind("rmi://127.0.0.1/GoDownEntryListService", this.goDownEntryListImpl);
			
			System.out.println("user Server is ready.");    
		} catch (RemoteException e) {
			
			System.out.println("user Server failed: " + e);
		} catch (MalformedURLException e) {
			
			System.out.println("user Server failed: " + e);
		}
	}
	public static void main(String[] args){
		new RmiServer().user();
	}

}
