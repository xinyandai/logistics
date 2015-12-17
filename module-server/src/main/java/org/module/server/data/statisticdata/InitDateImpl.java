package org.module.server.data.statisticdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.statisticdataservice.InitDateService;
import org.module.common.po.AccountPO;
import org.module.common.po.CarPO;
import org.module.common.po.DepartmentPO;
import org.module.common.po.StuffPO;
import org.module.common.po.WarehousePO;
import org.module.server.data.departmentdata.DepartmentDataImpl;
import org.module.server.data.departmentdata.StuffDataImpl;
import org.module.server.data.managementdata.CarDataImpl;

public class InitDateImpl extends UnicastRemoteObject implements InitDateService {

	public InitDateImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 5130502560682465347L;

	public boolean init() throws RemoteException {
		MyList<CarPO> carPOs = new CarDataImpl().getAll();
		MyList<StuffPO> stuffPOs = new StuffDataImpl().getAll();
		MyList<DepartmentPO> departmentPO = new DepartmentDataImpl().getAll();
		MyList<AccountPO> AccountPOs = new AccountDataImpl().getAll();
		
		this.write(carPOs, CarPO.class);
		this.write(stuffPOs, StuffPO.class);
		this.write(departmentPO, DepartmentPO.class);
		this.write(AccountPOs, AccountPO.class);
		return false;
	}

	public MyList<CarPO> getInitCar() throws RemoteException {
		return this.reader(CarPO.class);
	}

	public MyList<StuffPO> getInitStuff() throws RemoteException {
		return this.reader(StuffPO.class);
	}

	public MyList<DepartmentPO> getInitDepartment() throws RemoteException {
		return this.reader(DepartmentPO.class);
	}

	public MyList<AccountPO> getInitAccount() throws RemoteException {
		return this.reader(AccountPO.class);
	}

	public MyList<WarehousePO> getInitWarehouse() throws RemoteException {
		return this.reader(WarehousePO.class);
	}
	
	@SuppressWarnings("unchecked")
	private <T> MyList<T> reader(Class<T> c){
		File file = new File("file"+File.separator+"init"+File.separator+c.getName()); 
		if(!file.exists()){
			return null;
		}
		MyList<T> list = null;
		try {
			ObjectInputStream is = new ObjectInputStream(new FileInputStream(file)); 
			list = (MyList<T>) is.readObject();
			is.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  

		return list;
		
	}
	private <T> boolean write( MyList<T> list,Class<T> c){
		File file = new File("file"+File.separator+"init"+File.separator+c.getName()); 
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream(file));
			os.writeObject(list);  
		    os.close();
		    return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}  
        return false;
	}
}
