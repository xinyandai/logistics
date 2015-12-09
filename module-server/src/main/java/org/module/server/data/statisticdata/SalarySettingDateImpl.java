package org.module.server.data.statisticdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.statisticdataservice.SalarySettingDateService;
import org.module.common.po.salary.AccountantSalaryPO;
import org.module.common.po.salary.CourierSalaryPO;
import org.module.common.po.salary.DriverSalaryPO;
import org.module.common.po.salary.OfficeClerkSalaryPO;
import org.module.common.po.salary.TranCenterClerkSalaryPO;
import org.module.common.po.salary.WarehouseManagerSalaryPO;
import org.module.server.data.FileHelper;


public class SalarySettingDateImpl extends UnicastRemoteObject implements SalarySettingDateService{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6093318053020782343L;

	public SalarySettingDateImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	public boolean setAccountSalary(AccountantSalaryPO a) {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"AccountantSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<Object> re =  new ArrayList<Object>();
		re.add(a);
		return help.rewrite(re);
	}

	public boolean setCourierSalary(CourierSalaryPO c) {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"CourierSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<Object> re =  new ArrayList<Object>();
		re.add(c);
		return help.rewrite(re);
	}

	public boolean setDriverSalary(DriverSalaryPO d) {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"DriverSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<Object> re =  new ArrayList<Object>();
		re.add(d);
		return help.rewrite(re);
	}

	public boolean setOfficeClerkSalary(OfficeClerkSalaryPO salarypo) {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"OfficeClerkSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<Object> re =  new ArrayList<Object>();
		re.add(salarypo);
		return help.rewrite(re);
	}

	public boolean setTranCenterClerkSalary(TranCenterClerkSalaryPO t) {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"TranCenterClerkSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<Object> re =  new ArrayList<Object>();
		re.add(t);
		return help.rewrite(re);
	}

	public boolean setWarehouseSalary(WarehouseManagerSalaryPO w) {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"WarehouseManagerSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<Object> re =  new ArrayList<Object>();
		re.add(w);
		return help.rewrite(re);
	}

	
	public AccountantSalaryPO getAccountSalary() {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"AccountantSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<String> re =  new ArrayList<String>();
		re=help.read();
		if(re.size()==0){
			return null;
		}
		AccountantSalaryPO a=new AccountantSalaryPO(re.get(0));
		return a;
	}

	public CourierSalaryPO getCourierSalary() {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"CourierSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<String> re =  new ArrayList<String>();
		re=help.read();
		if(re.size()==0){
			return null;
		}
		CourierSalaryPO a=new CourierSalaryPO(re.get(0));
		return a;
	}

	public DriverSalaryPO getDriverSalary() {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"DriverSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<String> re =  new ArrayList<String>();
		re=help.read();
		if(re.size()==0){
			return null;
		}
		DriverSalaryPO a=new DriverSalaryPO(re.get(0));
		return a;
	}

	public OfficeClerkSalaryPO getOfficeClerkSalary() {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"OfficeClerkSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<String> re =  new ArrayList<String>();
		re=help.read();
		if(re.size()==0){
			return null;
		}
		OfficeClerkSalaryPO a=new OfficeClerkSalaryPO(re.get(0));
		return a;
	}

	public TranCenterClerkSalaryPO getTranCenterClerkSalary() {
		// TODO Auto-generated method stub
		String path="file"+File.separator+" TranCenterClerkSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<String> re =  new ArrayList<String>();
		re=help.read();
		if(re.size()==0){
			return null;
		}
		 TranCenterClerkSalaryPO a=new  TranCenterClerkSalaryPO(re.get(0));
		return a;
	}

	public WarehouseManagerSalaryPO getWarehouseSalary() {
		// TODO Auto-generated method stub
		String path="file"+File.separator+"CourierSalary.txt";
		File file=new File(path);
		FileHelper help=new FileHelper(file);
		ArrayList<String> re =  new ArrayList<String>();
		re=help.read();
		if(re.size()==0){
			return null;
		}
		WarehouseManagerSalaryPO a=new WarehouseManagerSalaryPO(re.get(0));
		return a;
	}

}
