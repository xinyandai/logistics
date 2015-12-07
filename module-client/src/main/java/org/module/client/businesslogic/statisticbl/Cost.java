package org.module.client.businesslogic.statisticbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.client.businesslogicservice.statistic.CostService;
import org.module.client.javaRMI.RmiClient;
import org.module.client.presentation.DateTransferHelper;
import org.module.client.vo.CostListVO;
import org.module.common.dataservice.statisticdataservice.CostDataService;
import org.module.common.po.CostListPO;

public class Cost implements CostService {
    private CostDataService data;
	public Cost() {
		this.data = new RmiClient().get(CostDataService.class);
	}

	public boolean creatCostList(CostListVO vo) {
		
		try {
			return data.addCostList(new CostListPO(vo.getDate(),vo.getMoney()+"",vo.getPeople(),
					vo.getAccout(),vo.getEntry(),vo.getNote()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<CostListVO> getAllCostList(long startTime, long endTime) {
		ArrayList<CostListVO> vos = new ArrayList<CostListVO>();
		try {
			ArrayList<CostListPO> pos = this.data.getAll();
			for (CostListPO po : pos) {
                long time = DateTransferHelper.getDate(po.getDate()).getTime();
				if(time<=endTime && time>=startTime){
					vos.add(new CostListVO(po.getDate(),po.getMoney()+"",po.getPeople(),
							po.getAccout(),po.getEntry(),po.getNote()));
				}
					
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vos;
	}

	

}
