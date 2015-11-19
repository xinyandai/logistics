package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.IncomeService;
import org.module.client.vo.ReceiptVO;

public class Income implements IncomeService {

	private ArrayList<ReceiptVO> list;

	public ArrayList<ReceiptVO> getAllIncomeList(String office,
			double startTime, double endTime) {
		return list;
	}

	public boolean add(ReceiptVO a) {
		// TODO Auto-generated method stub
		return false;
	}

}
