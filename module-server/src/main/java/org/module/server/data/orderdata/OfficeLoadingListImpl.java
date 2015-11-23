package org.module.server.data.orderdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.OfficeLoadingListService;
import org.module.common.po.MailingListPO;
import org.module.common.po.OfficeArrivalListPO;
import org.module.common.po.OfficeLoadingListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class OfficeLoadingListImpl implements OfficeLoadingListService{
	FileHelper help;
	public OfficeLoadingListImpl(){
		help = new FileHelper(new File("file"+File.separator+"officeLoadingList.txt"));
	}
	public ArrayList<OfficeLoadingListPO> getAll() {
		// TODO 自动生成的方法存根
		ArrayList<OfficeLoadingListPO> re = new ArrayList<OfficeLoadingListPO>();
		ArrayList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			re.add(new OfficeLoadingListPO(temp));
		}
		return re;
	}

	public boolean add(OfficeLoadingListPO o) {
		ArrayList<OfficeLoadingListPO> oll = new ArrayList<OfficeLoadingListPO>();
		oll.add(o);
		return help.rewrite(oll);
	}

	public boolean update(OfficeLoadingListPO newone) {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<OfficeLoadingListPO> getByState(State s) {
		// TODO 自动生成的方法存根
		ArrayList<OfficeLoadingListPO> oal = this.getAll();
		ArrayList<OfficeLoadingListPO> newone = new ArrayList<OfficeLoadingListPO>();
		for(OfficeLoadingListPO a : oal){
			if(a.getState().equals(s)){
				newone.add(a);
			}
		}
		return newone;
	}

}
