package org.module.server.data.managementdata;

import java.io.File;
import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.managementdataservice.PriceAndCityDataService;
import org.module.common.po.CityPO;
import org.module.common.po.PriceAndCityPO;
import org.module.server.data.FileHelper;

public class PriceAndCityDataImpl implements PriceAndCityDataService {

	String path="file"+File.separator+"PriceAndCity.txt";
	File file=new File(path);
	FileHelper priceAndCityHelp=new FileHelper(file);
	
	String Path="file"+File.separator+"City.txt";
	File fil=new File(Path);
	FileHelper cityHelp=new FileHelper(fil);
	
	public PriceAndCityDataImpl() {
	}

	public ArrayList<PriceAndCityPO> getAll() {
		ArrayList<String> re = this.priceAndCityHelp.read();
		ArrayList<PriceAndCityPO> ar =  new ArrayList<PriceAndCityPO>();	
		for (String string : re) {
			ar.add(new PriceAndCityPO(string));
		}
		return ar;
	}

	public MyList<CityPO> getCity() {
		ArrayList<String> re = this.cityHelp.read();
		MyList<CityPO> ar =  new MyList<CityPO>();	
		for (String string : re) {
			ar.add(new CityPO(string));
		}
		return ar;
		
	}

	
	public boolean addPriceAndCity(PriceAndCityPO p) {
		return this.priceAndCityHelp.add(p);
	}

	public boolean update(PriceAndCityPO p) {
		// TODO Auto-generated method stub
		ArrayList<PriceAndCityPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if( re.get(i).getcityA().equals(p.getcityA() )
					&& re.get(i).getcityB().equals(p.getcityB())){
				re.remove(i);
				re.add(p);
				return priceAndCityHelp.rewrite(re);
			}
		}		
		return false;
	}

	public boolean deleteCity(String id) throws RemoteException {
		ArrayList<CityPO> re = this.getCity(); 
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getId().equals(id)){
				re.remove(i);
				return this.cityHelp.rewrite(re);
			}
		}
		return false;
	}

	

	public boolean addCity(CityPO po) throws RemoteException {
		
		return this.cityHelp.add(po);
	}

	public boolean modifyCity(CityPO po) throws RemoteException {
		ArrayList<CityPO> re = this.getCity(); 
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getId().equals(po.getId())){
				re.remove(i);
				re.add(po);
				return this.cityHelp.rewrite(re);
			}
		}
		return false;
	}

}
