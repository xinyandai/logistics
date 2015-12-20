package org.module.client.businesslogic.orderbl;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.module.client.businesslogicservice.order.CalculateDriverCostService;
import org.module.client.businesslogicservice.order.CalculateTimeService;
import org.module.client.businesslogicservice.order.MailingService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.main.Main;
import org.module.client.vo.MailingListVO;
import org.module.common.dataservice.MyList;
import org.module.common.dataservice.logisticsdataservice.Logisticsdataservice;
import org.module.common.dataservice.orderdataservice.MailingListService;
import org.module.common.po.LogisticsPO;
import org.module.common.po.MailingListPO;
import org.module.common.po.State;

public class Mailing  implements MailingService{

	private CalculateDriverCostService driverCost;
	private ArrayList<MailingListVO> list;
	private MailingListService data = new RmiClient().get(MailingListService.class);
	private Logisticsdataservice logistics = new RmiClient().get(Logisticsdataservice.class);
	
	public Mailing(CalculateTimeService time,
			CalculateDriverCostService driverCost) {
		super();
		this.driverCost = driverCost;
	}

	public Mailing(){
		this.driverCost = new CalculateDriverCost();
	}
	public boolean creat(MailingListVO o) {
		try {
			o.setState(State.SUBMITTED);
			return this.data.add(o.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<MailingListVO> getAll() {
		this.list = new ArrayList<MailingListVO>();
		try {
			ArrayList<MailingListPO> pos = this.data.getAll(Main.currentUser.getId());
			for (MailingListPO mailingListPO : pos) {
				list.add(new MailingListVO(mailingListPO));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	public double calculatePrice(String senderCity, String receiveCity,
			String costOfDecoration) {
		double  re = this.driverCost.calculateDriverCost(senderCity, receiveCity);
		
		return re + Double.parseDouble(costOfDecoration);
	}

	public int calculateTime(String senderCity, String receiveCity) {
		int i = 0;
		int day = 0;
		try {
			MyList<LogisticsPO> pos = this.logistics.getAll();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			for (LogisticsPO logisticsPO : pos) {
				String[] times = logisticsPO.getHistoryTime();
				if(times.length>2){
					Date start = sdf.parse(logisticsPO.getHistoryTime()[0]);
					Date end = sdf.parse(times[times.length-1]);
					long between=(end.getTime()-start.getTime())/1000;//除以1000是为了转换成秒
					day += between/(24*3600);
					i++;
				}
				
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return i==0? 0 : day/i;
	}

	public boolean update(MailingListVO vo) {
		try {
			return this.data.update(vo.toPO());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

}
