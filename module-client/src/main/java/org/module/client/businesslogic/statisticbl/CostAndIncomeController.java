package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.CostService;
import org.module.client.businesslogicservice.statisticBLservice.CostAndIncomeBLService;
import org.module.client.vo.CostListVO;
import org.module.client.vo.ReceiptVO;

public class CostAndIncomeController implements CostAndIncomeBLService {

	private CostService cost;
	private Income income;
	
	private double costMoney;
	private double incomeMoney;
	public CostAndIncomeController(){
		cost = new Cost();
		income = new Income();
	}
	

	public CostAndIncomeController(CostService cost, Income income) {
		super();
		this.cost = cost;
		this.income = income;
	}


	public double getCost(double startTime, double endTime) {
		ArrayList<CostListVO> list = cost.getAllCostList(startTime, endTime);
		double re = 0.0;
		for (CostListVO v : list) {
			re+=v.getMoney();
		}
		this.costMoney = re;
		return re;
	}

	public double getIncome(double startTime, double endTime) {
		ArrayList<ReceiptVO> list = income.getAllIncomeList("所有", startTime, endTime);
		double re = 0.0;
		for (ReceiptVO v : list) {
			re+=v.getMoney();
		}
		this.incomeMoney = re;
		return re;
	}

	public double getPureIncome(double startTime, double endTime) {
		
		return this.incomeMoney-this.costMoney;
	}

}
