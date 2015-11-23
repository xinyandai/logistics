package org.module.server.javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.module.common.dataservice.DataFactotyService;
import org.module.server.data.DataFactoty;


public class RmiServer {

	private DataFactotyService factory = new DataFactoty();
	public RmiServer() {
		
	}
	public void user(){
		try {
			LocateRegistry.createRegistry(1099);
			
			this.regist("userdata.UserDataImpl");
			this.regist("ticketData.GoDownEntryListDataImpl");
			this.regist("ticketData.OutBoundListDataImpl");
			
			this.regist("statisticdata.AccountDataImpl");
			this.regist("statisticdata.CostDataImpl");
			this.regist("statisticdata.ReceiptListDataImpl");
			this.regist("statisticdata.SalarySettingDateImpl");
			this.regist("statisticdata.InitDateImpl");
			
			
			
			System.out.println("user Server is ready.");    
		} catch (RemoteException e) {
			System.out.println("user Server failed: /n" + e);
		} catch (MalformedURLException e) {
			System.out.println("user Server failed: /n" + e);
		}
	}
	
	public void regist(String s) throws RemoteException, MalformedURLException{
		Object obj = factory.creatDataObject(s);
		Naming.rebind("rmi://127.0.0.1/"+obj.getClass().getInterfaces()[0].getName(), (Remote)obj);
	}
	
	public static void main(String[] args){
		RmiServer  rmi = new RmiServer();
		rmi.user();
	}
	
	

}
