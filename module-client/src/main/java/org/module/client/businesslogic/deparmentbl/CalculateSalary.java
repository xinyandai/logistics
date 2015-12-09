package org.module.client.businesslogic.deparmentbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.module.client.businesslogicservice.department.CalculateSalaryService;
import org.module.client.javaRMI.RmiClient;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.TranCenterLoadingListService;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.dataservice.statisticdataservice.SalarySettingDateService;
import org.module.common.po.ReceiptPO;
import org.module.common.po.State;
import org.module.common.po.TranCenterLoadingListPO;
import org.module.common.po.salary.AccountantSalaryPO;
import org.module.common.po.salary.CourierSalaryPO;
import org.module.common.po.salary.DriverSalaryPO;
import org.module.common.po.salary.OfficeClerkSalaryPO;
import org.module.common.po.salary.TranCenterClerkSalaryPO;
import org.module.common.po.salary.WarehouseManagerSalaryPO;

public class CalculateSalary implements CalculateSalaryService {

	private SalarySettingDateService data;
	
	
	
	public CalculateSalary(){
		this.data = new RmiClient().get(SalarySettingDateService.class);
	}
	
	
	public double calculateById(String id,String time) {
		if(id.substring(0,2).equals("001")){
			return this.getAccountant();
		}else if(id.substring(0,2).equals("002")){
			return this.getCourier(id,time);
		}else if(id.substring(0,2).equals("003")){
			return this.getDriver(id,time);
		}else if(id.substring(0,2).equals("004")){
			return this.getOfficeClerk();
		}else if(id.substring(0,2).equals("005")){
			return this.getTranCenterClerk();
		}else if(id.substring(0,2).equals("006")){
			return this.getWarehouse();
		}else{
			return 0;
		}
		
	}

	public double getAccountant(){
		AccountantSalaryPO apo=null;
		try {
			apo = data.getAccountSalary();
			return apo.getBase()+apo.getBonus();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return 0;
		}
		
	}
	public double getCourier(String courierId,String time){
		CourierSalaryPO cspo = null;
		try {
			cspo = data.getCourierSalary();
		} catch (RemoteException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}
		ReceiptListService rec =  new RmiClient().get(ReceiptListService.class);
		MyList<ReceiptPO> all = null;
		try {
			all = rec.getAll();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		int total=0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = null;
		try {
			now = sdf.parse(time);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i =0;i<all.size();i++){
			
			if(all.get(i).getCourier().equals(courierId)){
				Date end = null;
				try {
					end = sdf.parse(all.get(i).getDate());
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if(end.after(now)){
					total+=all.get(i).getOrderId().length;
				}
			}
		}
		return total*cspo.getBonusEveryDelivered()+cspo.getBase();
	}
	public double getDriver(String driverId,String time){
		int total = 0;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date now = null;
		
		try {
			now = sdf.parse(time);
		} catch (ParseException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		TranCenterLoadingListService rec =  new RmiClient().get(TranCenterLoadingListService.class);
		MyList<TranCenterLoadingListPO> all = null;
		try {
			
			all = rec.getByState(State.SUBMITTED);
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		for(int i =0;i<all.size();i++){
			
			if(all.get(i).getSupervision().equals(driverId)){
				Date end = null;
				try {
					end = sdf.parse(all.get(i).getLoadingDate());
				} catch (ParseException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				if(end.after(now)){
					total++;
				}
			}
		}
		DriverSalaryPO apo=null;
		try {
			apo = data.getDriverSalary();
			
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			
		}
		return apo.getBase()+total*apo.getBonusEveryIncityDriving();
	
	}
	public double getOfficeClerk(){
		OfficeClerkSalaryPO apo=null;
		try {
			apo = data.getOfficeClerkSalary();
			return apo.getBase();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return 0;
		}
	}
	public double getTranCenterClerk(){
		TranCenterClerkSalaryPO apo=null;
		try {
			apo = data.getTranCenterClerkSalary();
			return apo.getBase();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return 0;
		}
		
	}
	public double getWarehouse(){
		WarehouseManagerSalaryPO apo=null;
		try {
			apo = data.getWarehouseSalary();
			return apo.getBase();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			return 0;
		}
	}

	
}
