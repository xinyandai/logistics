package org.module.server.data.orderdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.SendingListService;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.ReceivingListPO;
import org.module.common.po.SendingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class SendingListImpl implements SendingListService{
	FileHelper help;
	public SendingListImpl(){
		help = new FileHelper(new File("file"+File.separator+"SendingList.txt"));
	}
	public ArrayList<SendingListPO> getAll() {
		// TODO 自动生成的方法存根
		ArrayList<SendingListPO> re = new ArrayList<SendingListPO>();
		ArrayList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new SendingListPO(temp));
		}
		return re;
	}

	public boolean add(SendingListPO o) {
		// TODO 自动生成的方法存根
		ArrayList<SendingListPO> oll = new ArrayList<SendingListPO>();
		oll.add(o);
		return help.rewrite(oll);
	}

	public boolean update(SendingListPO newone) {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<SendingListPO> getByState(State s) {
		// TODO 自动生成的方法存根
		ArrayList<SendingListPO> oal = this.getAll();
		ArrayList<SendingListPO> newone = new ArrayList<SendingListPO>();
		for(SendingListPO a : oal){
			if(a.getState().equals(s)){
				newone.add(a);
			}
		}
		return newone;
	}

}
