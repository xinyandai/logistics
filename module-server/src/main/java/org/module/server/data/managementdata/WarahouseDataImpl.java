package org.module.server.data.managementdata;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.WarahouseDataService;
import org.module.common.po.BorderlinePO;
import org.module.common.po.WarehousePO;
import org.module.server.data.FileHelper;

public class WarahouseDataImpl extends UnicastRemoteObject  implements WarahouseDataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4574838135272237174L;



	public WarahouseDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	String path="file"+File.separator+"Warahouse.txt";
	File file=new File(path);
	FileHelper helpWithWar=new FileHelper(file);
	
	String Path="file"+File.separator+"line.txt";
	File fileHelperWithLine=new File(Path);
	
	

	public ArrayList<WarehousePO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<String> re = this.helpWithWar.read();
		ArrayList<WarehousePO> ar =  new ArrayList<WarehousePO>();	
		for (String string : re) {
			ar.add(new WarehousePO(string));
		}
		return ar;
	}

	public boolean add(WarehousePO cp) {
		// TODO Auto-generated method stub
		return this.helpWithWar.add(cp);
	}

	public boolean delete(String cp) {
		// TODO Auto-generated method stub
		ArrayList<WarehousePO> pos = this.getAll();
		 for (int i = 0; i < pos.size(); i++) {
			 if(pos.get(i).getNumber().equals(cp)){
				pos.remove(i);
				return helpWithWar.rewrite(pos);
			 }
		 }
		return false;
	}

	public boolean update( WarehousePO newone) {
		// TODO Auto-generated method stub
		ArrayList<WarehousePO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getNumber().equals(newone.getNumber())){
				re.remove(i);
				re.add(newone);
				return helpWithWar.rewrite(re);
			}
		}		
		return false;
	}

	public boolean setBorderline(BorderlinePO po) {
		MyList<BorderlinePO> pos = this.getAllDorderline();
		for (int i = 0; i < pos.size(); i++) {
			if(pos.get(i).getId().equals(po.getId()) && pos.get(i).getId().equals(po.getLine())){
				pos.remove(i);
				break;
			}
		}
		return pos.add(po);
	}


	public double getBorderline(BorderlinePO po) throws RemoteException {
		
		FileHelper borderline=new FileHelper(fileHelperWithLine);
		ArrayList<String> ss = borderline.read();
		for (String string : ss) {
			BorderlinePO temp = new BorderlinePO(string);
			if(temp.getId().equals(po.getId()) && temp.getQu().equals(po.getQu())){
				return temp.getLine();
			}
		}
		return 0.0;// TODO Auto-generated method stub
		
	}

	public MyList<BorderlinePO> getAllDorderline(){
		MyList<BorderlinePO> re =new MyList<BorderlinePO>();
		FileHelper borderline=new FileHelper(fileHelperWithLine);
		ArrayList<String> ss = borderline.read();
		for (String string : ss) {
			BorderlinePO temp = new BorderlinePO(string);
			re.add(temp);
		}
		return re;
	}
}