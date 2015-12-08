package org.module.client.businesslogic.ticketbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticket.OutBoundService;
import org.module.client.businesslogicservice.ticketBLservice.OutBoundBLService;
import org.module.client.vo.GoDownEntryVO;
import org.module.client.vo.OutBoundListVO;

public class OutBoundController implements OutBoundBLService{

	private OutBoundService outBound ;
	private ArrayList<OutBoundListVO> list;
	public OutBoundController(OutBoundService outBound) {
		super();
		this.outBound = outBound;
	}

	public OutBoundController() {
		this.outBound = new OutBound();
	}
	
	public boolean createTicket(OutBoundListVO vo) {
		this.list.add(vo);
		return outBound.createTicket(vo);
	}

	public ArrayList<OutBoundListVO> getAll(long start , long end){
		this.list = this.outBound.getAll( start ,  end);
		return list;
	}
	
	public boolean update(OutBoundListVO vo) {
		for (OutBoundListVO outBoundListVO : list) {
			if(outBoundListVO.getId().equals(vo.getId())){
				outBoundListVO.setDate(vo.getDate());
				outBoundListVO.setDestination(vo.getDestination());
				outBoundListVO.setTansportListId(vo.getTansportListId());
				outBoundListVO.setTypeOfLoading(vo.getTypeOfLoading());
				outBoundListVO.setWarehouseOfWhichTranCenter(vo.getWarehouseOfWhichTranCenter());
				return outBound.update(vo);
			}
		}
		return false;
	}
}
