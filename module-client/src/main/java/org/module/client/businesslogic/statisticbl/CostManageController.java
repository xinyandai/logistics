package org.module.client.businesslogic.statisticbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.CostService;
import org.module.client.businesslogicservice.statisticBLservice.CostManageBLService;
import org.module.client.vo.CostListVO;

public class CostManageController implements CostManageBLService {
	private CostService cost;
	private ArrayList<CostListVO> list;
	public CostManageController(CostService cost) {
		super();
		this.cost = cost;
	}

	public CostManageController() {
		cost = new Cost();
	}

	public boolean add(CostListVO vo) {
		for (CostListVO costListVO : list) {
			if(costListVO.getID().equals(vo.getID())){
				return false;
			}
		}
		this.list.add(vo);
		return cost.creatCostList(vo);
	}

	public ArrayList<CostListVO> showAll(long startTime, long endTime) {
		this.list = cost.getAllCostList(startTime, endTime);
		return list;
	}

	public boolean update(CostListVO vo) {
		
		return this.cost.update(vo);
	}

    

}
