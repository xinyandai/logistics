package org.module.client.businesslogic.deparmentbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.javaRMI.RmiClient;
import org.module.client.vo.DepartmentVO;
import org.module.common.dataservice.departmentdataservice.DepartmentDataService;
import org.module.common.po.DepartmentPO;

public class DeparmentCount {
	private DepartmentDataService data;
	private  ArrayList<DepartmentVO> list; 
	
	public DeparmentCount(String type) {
		this.data = new RmiClient().get(DepartmentDataService.class);
		this.findByType(type);
	}
	
	public DeparmentCount() {
		this.data = new RmiClient().get(DepartmentDataService.class);
		this.getAll();
	}
	/**
	 * 根据ID找出名字
	 * @param id
	 * @return 返回ID与名字
	 */
	public String IdAndNameString(String id){
		for (DepartmentVO vo : list) {
			if(vo.getIdentity().equals(id)){
				return vo.getName();
			}
		}
		return "";
	}
	
	public String getName(String id){
		for (DepartmentVO vo : list) {
			if(vo.getIdentity().equals(id)){
				return vo.getName();
			}
		}
		return "";
	}
	
	private   void   getAll(){
		ArrayList<DepartmentVO> vos = new ArrayList<DepartmentVO>();
		ArrayList<DepartmentPO> pos;
		try {
			pos = this.data.getAll();
			for (DepartmentPO departmentPO : pos) {
			vos.add(new DepartmentVO(
					departmentPO.getName(),
					departmentPO.getCategory(),
					departmentPO.getLocation(),
					departmentPO.getIdentity()
					)
			      );
		
		    }
			this.list = vos;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}
	
	private   void   findByType(String type){
		ArrayList<DepartmentVO> vos = new ArrayList<DepartmentVO>();
		ArrayList<DepartmentPO> pos;
		try {
			pos = this.data.findByType(type);
			for (DepartmentPO departmentPO : pos) {
			vos.add(new DepartmentVO(
					departmentPO.getName(),
					departmentPO.getCategory(),
					departmentPO.getLocation(),
					departmentPO.getIdentity()
					)
			      );
		
		    }
			this.list = vos;
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

	public String[] getIDWithName(){
		String[] re  = new String[list.size()];
		for (int i= 0 ; i < list.size(); i++){
			re[i] = list.get(i).getIdentity()+list.get(i).getName();
		}
		return re;
	}
	
	public String[] getName(){
		String[] re  = new String[list.size()];
		for (int i= 0 ; i < list.size(); i++){
			re[i] = list.get(i).getName();
		}
		return re;
	}
	public String[] getID(){
		String[] re  = new String[list.size()];
		for (int i= 0 ; i < list.size(); i++){
			re[i] = list.get(i).getIdentity();
		}
		return re;
	}

}
