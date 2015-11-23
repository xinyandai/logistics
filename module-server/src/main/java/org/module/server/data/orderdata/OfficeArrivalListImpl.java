package org.module.server.data.orderdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.OfficeArrivalListService;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.ReceiptPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class OfficeArrivalListImpl implements OfficeArrivalListService{
	FileHelper help;
	public OfficeArrivalListImpl(){
		help = new FileHelper(new File("file"+File.separator+"officeArrivalList.txt"));
	}
	public ArrayList<OfficeArrivalListPO> getAll() {
		// TODO 自动生成的方法存根
		ArrayList<OfficeArrivalListPO> re = new ArrayList<OfficeArrivalListPO>();
		ArrayList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new OfficeArrivalListPO(temp));
		}
		return re;

		
	}
	//add方法有问题
	public boolean add(OfficeArrivalListPO o) {
		// TODO 自动生成的方法存根
		ArrayList<OfficeArrivalListPO> temp = this.getAll();
		temp.add(o);
		return false;
	}

	public boolean update(OfficeArrivalListPO newone) {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<OfficeArrivalListPO> getByState(State s) {
		// TODO 自动生成的方法存根
		ArrayList<OfficeArrivalListPO> oal = this.getAll();
		ArrayList<OfficeArrivalListPO> newone = new ArrayList<OfficeArrivalListPO>();
		for(OfficeArrivalListPO a : oal){
			if(a.getState().equals(s)){
				newone.add(a);
			}
		}
		return newone;
	}

}
