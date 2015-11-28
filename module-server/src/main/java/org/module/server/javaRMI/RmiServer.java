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
			
			this.regist("departmentdata.DepartmentDataImpl");
			this.regist("departmentdata.StuffDataImpl");
			
			this.regist("statisticdata.AccountDataImpl");
			this.regist("statisticdata.CostDataImpl");
			this.regist("statisticdata.ReceiptListDataImpl");
			this.regist("statisticdata.SalarySettingDateImpl");
			this.regist("statisticdata.InitDateImpl");
			
			this.regist("orderdata.MailingListImpl");
			this.regist("orderdata.OfficeArrivalListImpl");
			this.regist("orderdata.OfficeLoadingListImpl");
			this.regist("orderdata.ReceiveListImpl");
			this.regist("orderdata.SendingListImpl");
			this.regist("orderdata.TranCenterArrivalListImpl");
			this.regist("orderdata.TranCenterLoadingImpl");
			this.regist("orderdata.TransportListImpl");
			
			this.regist("logisticsdata.LogisticsdataImpl");
			
			this.regist("managementdata.CarDataImpl");
			this.regist("managementdata.DriversDataImpl");
			this.regist("managementdata.PriceAndCityDataImpl");
			this.regist("managementdata.WarahouseDataImpl");
			
			this.regist("ticketData.GoDownEntryListDataImpl");
			this.regist("ticketData.OutBoundListDataImpl");
			
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
