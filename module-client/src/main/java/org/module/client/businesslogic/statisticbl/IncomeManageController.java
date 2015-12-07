package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogic.deparmentbl.DeparmentCount;
import org.module.client.businesslogicservice.statistic.IncomeService;
import org.module.client.businesslogicservice.statisticBLservice.IncomeManageBLService;
import org.module.client.vo.ReceiptVO;

public class IncomeManageController implements IncomeManageBLService {

	
	private IncomeService income;
	private DeparmentCount office;
	public IncomeManageController() {
		super();
		this.income = new Income();
		this.office = new DeparmentCount("营业厅");
	}

	public IncomeManageController(IncomeService income) {
		super();
		this.income = income;
	}


	public ArrayList<ReceiptVO> showIncomeList(String office,
			long startTime, long endTime) {
		
		return income.getAllIncomeList(office, startTime, endTime);
	}

	public boolean add(String date, String money, String courier, String[] orderId) {
		return false;
	}

	public String[] getAllOffice() {
		return this.office.getName();
	}

	

}
