package org.module.client.businesslogic.deparmentbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.module.client.businesslogicservice.department.CalculateSalaryService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.StuffVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.orderdataservice.OfficeLoadingListService;
import org.module.common.dataservice.orderdataservice.TranCenterLoadingListService;
import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.dataservice.statisticdataservice.SalarySettingDateService;
import org.module.common.po.OfficeLoadingListPO;
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
	private RmiClient rmi = new RmiClient();
	private final String[] array= {
			"快递员","营业厅业务员","仓库管理员",
			"中转中心业务员","财务人员","总经理",
			"管理员","司机","监装员",
			"其他"};
	
	
	public CalculateSalary(){
		this.data = rmi.get(SalarySettingDateService.class);
	}
	
	
	public double calculateSalary(StuffVO vo) {
		double re = .0;
		if(vo.getCategory().equals(array[0])){
			Date startOfMonth;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 0);
			startOfMonth = calendar.getTime();
			re = this.getCourier(vo.getIdentity(), startOfMonth);
		}else if(vo.getCategory().equals(array[1])){
			re = this.getOfficeClerk();
		}else if(vo.getCategory().equals(array[2])){
			re = this.getWarehouse();
		}else if(vo.getCategory().equals(array[3])){
			re = this.getTranCenterClerk();
		}else if(vo.getCategory().equals(array[4])){
			re = this.getAccountant();
		}else if(vo.getCategory().equals(array[7])){
			Date startOfMonth;
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 0);
			startOfMonth = calendar.getTime();
			re = this.getDriver(vo.getIdentity(), startOfMonth);
		}
		return re;
		
	}

	public double getAccountant(){
		AccountantSalaryPO apo=null;
		try {
			apo = data.getAccountSalary();
			return apo.getBase();
		} catch (RemoteException e) {
			return 0;
		}
		
	}
	public double getCourier(String courierId,Date now){
		CourierSalaryPO cspo = null;
		int total=0;
		try {
			cspo = data.getCourierSalary();
			ReceiptListService rec =  new RmiClient().get(ReceiptListService.class);
			MyList<ReceiptPO> all = null;
			all = rec.getAll();
			for(int i =0;i<all.size();i++){
				
				if(all.get(i).getCourier().equals(courierId)){
					Date end = null;
					end = DateTransferHelper.getDate (all.get(i).getDate());
					if(end.after(now)){
						total += all.get(i).getOrderId().length;
					}
				}
			}
		} catch (RemoteException e1) {
			e1.printStackTrace();
			return 0;
		}
		return total*cspo.getBonusEveryDelivered()+cspo.getBase();
	}
	public double getDriver(String driverId,Date now){
		
		TranCenterLoadingListService rec =  rmi.get(TranCenterLoadingListService.class);
		OfficeLoadingListService officeLoadingListService = rmi.get(OfficeLoadingListService.class);
		MyList<TranCenterLoadingListPO> allTranCente = null;
		MyList<OfficeLoadingListPO> allOffce = null;
		try {
			int incity = 0;
			int outCity = 0;
			allTranCente = rec.getAll();
			for(int i =0;i<allTranCente.size();i++){
				if(allTranCente.get(i).getEscort().equals(driverId)){
					TranCenterLoadingListPO po = allTranCente.get(i);
					Date end = null;
					end = DateTransferHelper.getDate(po.getLoadingDate());
					if(end.after(now)){
						outCity++;
					}
				}
			}
			allOffce = officeLoadingListService.getAll();
			for(int i =0;i<allOffce.size();i++){
				if(allOffce.get(i).getEscort().equals(driverId)){
					OfficeLoadingListPO po = allOffce.get(i);
					Date end = null;
					end = DateTransferHelper.getDate(po.getLoadingDate());
					if(end.after(now)){
						incity++;
					}
				}
			}
			DriverSalaryPO apo=null;
			apo = data.getDriverSalary();
			return apo.getBase()+incity*apo.getBonusEveryIncityDriving()+outCity*apo.getBonusEveryKilometersOutcityDriving();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	    return 0;
	}
	public double getOfficeClerk(){
		OfficeClerkSalaryPO apo=null;
		try {
			apo = data.getOfficeClerkSalary();
			return apo.getBase();
		} catch (RemoteException e) {
			return 0;
		}
	}
	public double getTranCenterClerk(){
		TranCenterClerkSalaryPO apo=null;
		try {
			apo = data.getTranCenterClerkSalary();
			return apo.getBase();
		} catch (RemoteException e) {
			return 0;
		}
		
	}
	public double getWarehouse(){
		WarehouseManagerSalaryPO apo=null;
		try {
			apo = data.getWarehouseSalary();
			return apo.getBase();
		} catch (RemoteException e) {
			return 0;
		}
	}

	
}
