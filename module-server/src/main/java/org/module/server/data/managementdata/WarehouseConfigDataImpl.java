package org.module.server.data.managementdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.WarehouseConfigDataService;
import org.module.common.po.WarehouseConfigPO;
import org.module.server.data.FileHelper;

public class WarehouseConfigDataImpl extends UnicastRemoteObject  implements WarehouseConfigDataService{

	
	private static final long serialVersionUID = -5019247589010208338L;

	private String path="file"+File.separator+"warehouse"+File.separator+"WarehouseConfigData.txt";
	private File file=new File(path);
	private FileHelper help=new FileHelper(file);
	
	public WarehouseConfigDataImpl() throws RemoteException {
		super();
	}

	public WarehouseConfigPO find(String id) throws RemoteException {
		MyList<WarehouseConfigPO> pos = this.getAll();
		for (WarehouseConfigPO warehouseConfigPO : pos) {
			System.out.println(warehouseConfigPO.getWarehouseOfWhichTranCenter());
			if(warehouseConfigPO.getWarehouseOfWhichTranCenter().equals(id)){
				return warehouseConfigPO;
			}
		}
		return null;
	}

	public boolean update(WarehouseConfigPO warehouseConfig)
			throws RemoteException {
		MyList<WarehouseConfigPO> pos = this.getAll();
		for (int i = 0; i<pos.size(); i++) {
			if(pos.get(i).getWarehouseOfWhichTranCenter().equals(
					warehouseConfig.getWarehouseOfWhichTranCenter())){
				pos.remove(i);
				pos.add(warehouseConfig);
				return this.help.rewrite(pos);
			}
		}
		return false;
	}

	
	
	public boolean add(WarehouseConfigPO warehouseConfig)
			throws RemoteException {
		return this.help.add(warehouseConfig);
	}


	public MyList<WarehouseConfigPO> getAll() throws RemoteException {
		MyList<WarehouseConfigPO> re = new MyList<WarehouseConfigPO>();
		MyList<String> ss = this.help.read();
		for (String string : ss) {
			re.add(new WarehouseConfigPO(string));
		}
		return re;
	}

}
