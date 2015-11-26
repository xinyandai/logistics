package org.module.client.businesslogic.deparmentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.department.StuffService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.StuffVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.departmentdataservice.StuffDataService;
import org.module.common.po.StuffPO;

public class Stuff implements StuffService {

	private StuffDataService data;
	public Stuff() {
		this.data = new RmiClient().get(StuffDataService.class);
	}

	public ArrayList<StuffVO> showAll() {
		ArrayList<StuffVO> vos = new ArrayList<StuffVO>();
		ArrayList<StuffPO> pos;
		try {
			pos = this.data.getAll();
			for (StuffPO stuffPO : pos) {
			vos.add(new StuffVO(stuffPO.getName(),stuffPO.getAge(),stuffPO.getCategory(),stuffPO.getIdentity()));
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vos;
	}

	public boolean add(StuffVO stuffVO) {
		try {
			return this.data.add(new StuffPO(stuffVO.getName(),stuffVO.getAge(),stuffVO.getCategory(),stuffVO.getIdentity()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String identity) {
		try {
			return this.data.delete(identity);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(MyList<String> ald) {
		try {
			return this.data.delete(ald);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean modify(StuffVO stuffVO) {
		try {
			return this.data.update(
					new StuffPO(
							stuffVO.getName(),
							stuffVO.getAge(),
							stuffVO.getCategory(),
							stuffVO.getIdentity()
							)
					);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<StuffVO> fuzzySearch(String s) {
		ArrayList<StuffVO> vos = new ArrayList<StuffVO>();
		ArrayList<StuffPO> pos;
		try {
			pos = this.data.fuzzusearch(s);
			for (StuffPO stuffPO : pos) {
			vos.add(new StuffVO(stuffPO.getName(),stuffPO.getAge(),stuffPO.getCategory(),stuffPO.getIdentity()));
		}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vos;
	}

}
