package org.module.server.data.orderdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.ReceiveListService;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.ReceivingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class ReceiveListImpl implements ReceiveListService{
	FileHelper help;
	public ReceiveListImpl(){
		help = new FileHelper(new File("file"+File.separator+"ReceiveList.txt"));
	}
	public ArrayList<ReceivingListPO> getAll() {
		// TODO 自动生成的方法存根
		ArrayList<ReceivingListPO> re = new ArrayList<ReceivingListPO>();
		ArrayList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new ReceivingListPO(temp));
		}
		return re;
		
	}

	public boolean add(ReceivingListPO o) {
		// TODO 自动生成的方法存根
		ArrayList<ReceivingListPO> oll = new ArrayList<ReceivingListPO>();
		oll.add(o);
		return help.rewrite(oll);
	}

	public boolean update(ReceivingListPO newone) {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<ReceivingListPO> getByState(State s) {
		// TODO 自动生成的方法存根
		ArrayList<ReceivingListPO> oal = this.getAll();
		ArrayList<ReceivingListPO> newone = new ArrayList<ReceivingListPO>();
		for(ReceivingListPO a : oal){
			if(a.getState().equals(s)){
				newone.add(a);
			}
		}
		return newone;
	}

}
