package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.IncomeService;
import org.module.client.vo.ReceiptListVO;

public class Income implements IncomeService {

	private ArrayList<ReceiptListVO> list;

	public ArrayList<ReceiptListVO> getAllIncomeList(String office,
			double startTime, double endTime) {
		return list;
	}

	public boolean add(ReceiptListVO a) {
		// TODO Auto-generated method stub
		return false;
	}

}
