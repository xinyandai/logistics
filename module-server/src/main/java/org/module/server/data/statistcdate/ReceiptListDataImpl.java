package org.module.server.data.statistcdate;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.statisticdataservice.ReceiptListService;
import org.module.common.po.ReceiptPO;
import org.module.server.data.FileHelper;

public class ReceiptListDataImpl implements ReceiptListService {

	FileHelper dh;
	
	public ReceiptListDataImpl() {
		dh = new FileHelper(new File("file"+File.separator+"receiptlist.txt"));
	}

	public ArrayList<ReceiptPO> getAll() {
		ArrayList<ReceiptPO> re = new ArrayList<ReceiptPO>();
		ArrayList<String>    strs = dh.read();
		for (String string : strs) {
			re.add(new ReceiptPO(string));
		}
		return re;
	}

	public boolean add(ReceiptPO ticket) {
		
		return this.dh.add(ticket);
	}

	public boolean delete(ReceiptPO ticket) {
		ArrayList<ReceiptPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getOrderId().equals(ticket.getOrderId())){
				re.remove(i);
				return true;
			}
		}
		
		return false;
	}

	

	public boolean update(ReceiptPO newone) {
		
		ArrayList<ReceiptPO> re = this.getAll();
		for (int i = 0; i < re.size(); i++) {
			if(re.get(i).getOrderId().equals(newone.getOrderId())){
				re.remove(i);
				re.add(newone);
				return true;
			}
		}
		
		return false;
	}

}
