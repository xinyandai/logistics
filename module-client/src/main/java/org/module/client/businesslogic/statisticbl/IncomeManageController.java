package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.IncomeService;
import org.module.client.businesslogicservice.statisticBLservice.IncomeManageBLService;
import org.module.client.vo.ReceiptVO;

public class IncomeManageController implements IncomeManageBLService {

	
	private IncomeService income;
	public IncomeManageController() {
		super();
		this.income = new Income();
	}

	public IncomeManageController(IncomeService income) {
		super();
		this.income = income;
	}


	public ArrayList<ReceiptVO> showIncomeList(String office,
			double startTime, double endTime) {
		
		return income.getAllIncomeList(office, startTime, endTime);
	}

	public boolean add(String date, String money, String courier, String orderId) {
		// TODO Auto-generated method stub
		return false;
	}

}
