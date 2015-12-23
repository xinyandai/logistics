package org.module.server.javaRMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import org.module.common.dataservice.DataFactotyService;
import org.module.server.data.DataFactoty;

/**
 * rmi注册
 * @author 
 *
 */
public class RmiServer {

	private DataFactotyService factory = new DataFactoty();
	public RmiServer() {
		try {
			LocateRegistry.createRegistry(1099);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 注册接口
	 */
	public void rebind(){
		try {
			
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
			this.regist("orderdata.TranCenterLoadingListImpl");
			this.regist("orderdata.TransportListImpl");
			
			this.regist("logisticsdata.LogisticsdataImpl");
			
			this.regist("managementdata.CarDataImpl");
			this.regist("managementdata.DriversDataImpl");
			this.regist("managementdata.PriceAndCityDataImpl");
			this.regist("managementdata.WarahouseDataImpl");
			this.regist("managementdata.WarehouseConfigDataImpl");
			
			this.regist("ticketData.GoDownEntryListDataImpl");
			this.regist("ticketData.OutBoundListDataImpl");
			
			System.out.println("user Server is ready.");    
		} catch (RemoteException e) {
			System.out.println("user Server failed: /n" + e);
		} catch (MalformedURLException e) {
			System.out.println("user Server failed: /n" + e);
		}
	}
	
	/**
	 * 根据类名注册接口
	 * @param s 类名
	 * @throws RemoteException
	 * @throws MalformedURLException
	 */
	private void regist(String s) throws RemoteException, MalformedURLException{
		Object obj = factory.creatDataObject(s);
		Naming.rebind("rmi://127.0.0.1/"+obj.getClass().getInterfaces()[0].getName(), (Remote)obj);
	}
	

}
