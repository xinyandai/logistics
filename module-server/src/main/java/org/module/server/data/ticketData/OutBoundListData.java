package org.module.server.data.ticketData;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import org.module.common.dataservice.MyList;
import org.module.common.dataservice.ticketdataservice.OutBoundListService;
import org.module.common.po.OutBoundListPO;
import org.module.common.po.State;
import org.module.server.data.FileHelper;

public class OutBoundListData extends UnicastRemoteObject implements OutBoundListService {
	protected OutBoundListData() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileHelper helper = new FileHelper(new File("src"+File.separator+".txt"));
	

	public MyList<OutBoundListPO> getAll() {
		MyList<OutBoundListPO> re = new MyList<OutBoundListPO>();
		ArrayList<String> strs = this.helper.read();
		for (String string : strs) {
			re.add(new OutBoundListPO(string));
		}
		return re;
	}

	public boolean add(OutBoundListPO ticket) {
		return this.helper.add(ticket);
	}

	public boolean update(OutBoundListPO newone) {
		ArrayList<OutBoundListPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getId().equals(newone.getId())){
				re.remove(i);
				re.add(newone);
				this.helper.rewrite(re);
				return true;
			}
		}
		return false;
	}

	public MyList<OutBoundListPO> getByState(State s) {
		MyList<OutBoundListPO> all = this.getAll();
		MyList<OutBoundListPO> re = new MyList<OutBoundListPO>();
		for (int i = 0; i < re.size(); i++) {
			if(all.get(i).getState().toString().equals(s.toString())){
				re.add(all.get(i));
			}
		}
		return re;
	}

}
