package org.module.server.data.orderdata;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.orderdataservice.TranCenterLoadingService;
import org.module.common.po.SendingListPO;
import org.module.common.po.State;
import org.module.common.po.TranCenterLoadingListPO;
import org.module.server.data.FileHelper;

public class TranCenterLoadingImpl implements TranCenterLoadingService{
	FileHelper help;
	public TranCenterLoadingImpl(){
		help = new FileHelper(new File("file"+File.separator+"TranCenterLoadingList.txt"));
	}
	public ArrayList<TranCenterLoadingListPO> getAll() {
		// TODO 自动生成的方法存根
		ArrayList<TranCenterLoadingListPO> re = new ArrayList<TranCenterLoadingListPO>();
		ArrayList<String>    strs = help.read();
		for (String string : strs) {
			String[] temp = string.split(":%:%:");
			
			
		}
		return re;
	}

	public boolean add(TranCenterLoadingListPO o) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean update(TranCenterLoadingListPO newone) {
		// TODO 自动生成的方法存根
		return false;
	}

	public ArrayList<TranCenterLoadingListPO> getByState(State s) {
		// TODO 自动生成的方法存根
		return null;
	}

}
