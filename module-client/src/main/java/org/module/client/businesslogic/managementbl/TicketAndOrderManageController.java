package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.module.client.businesslogic.managementbl.ticketAndOrder.CostVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.IncomeVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.MainlingVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.OfficeArrivalVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.OfficeLoadingVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.ReceivingVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.SendingVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.TranCenterArrivalVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.TranCenterLoadingVerify;
import org.module.client.businesslogic.managementbl.ticketAndOrder.TransportVerify;
import org.module.client.businesslogic.managementbl.warehouseTicket.GoDownEntryVerify;
import org.module.client.businesslogic.managementbl.warehouseTicket.OutBoundVerify;
import org.module.client.businesslogicservice.management.TicketAndorderVerify;
import org.module.client.businesslogicservice.managementBLservice.TicketAndOrderManageBLService;
import org.module.client.vo.AbstractVO;


public class TicketAndOrderManageController implements TicketAndOrderManageBLService{
	
	String[] types = {
			"寄件单",
			"营业厅到达单",
			"营业厅装车单",
			"收件单",
			"派件单",
			"中转中心到达单",
			"中转中心装车单",
			"中转单",
			"出库单",
			"入库单",
			"付款单",
			"收款单"
	};
	
	Map<String,TicketAndorderVerify> map = new HashMap<String,TicketAndorderVerify>();
	public TicketAndOrderManageController(){
		map.put("寄件单", new MainlingVerify());
		map.put("营业厅到达单", new OfficeArrivalVerify());
		map.put("营业厅装车单", new OfficeLoadingVerify());
		map.put("收件单", new ReceivingVerify());
		map.put("派件单", new SendingVerify());
		map.put("中转中心到达单", new TranCenterArrivalVerify());
		map.put("中转中心装车单", new TranCenterLoadingVerify());
		map.put("中转单", new TransportVerify());
		map.put("出库单", new OutBoundVerify());
		map.put("入库单", new GoDownEntryVerify());
		map.put("付款单", new CostVerify());
		map.put("收款单", new IncomeVerify());
	}
	
	public String[] getTypes(){
		return types;
	}
	
	public boolean hasTicketToVerify(){
		return true;
	}
	
	public ArrayList<? extends AbstractVO> getAll(String type){
		return this.map.get(type).getAll();
	}
	
	public boolean pass(int[] indexes,String type){
		return this.map.get(type).pass(indexes);
	}
	
	public boolean unpass(int[] indexes,String type){
		return this.map.get(type).unpass(indexes);
	}
}
