package org.module.client.businesslogic.ticketbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.ticket.GoDownEntryService;
import org.module.client.businesslogicservice.ticketBLservice.GoDownEntryBLService;
import org.module.client.vo.GoDownEntryVO;

public class GoDownEntryController implements GoDownEntryBLService{

	private GoDownEntryService goDownEntry ;
	private ArrayList<GoDownEntryVO> list;
	
	public GoDownEntryController(GoDownEntryService goDownEntry) {
		super();
		this.goDownEntry = goDownEntry;
	}

	public GoDownEntryController() {
		this.goDownEntry = new GoDownEntry();
		
	}
	
	

	public boolean createTicket(GoDownEntryVO vo) {
		for (GoDownEntryVO goDownEntryVO : list) {
			if(goDownEntryVO.getId().equals(vo.getId())){
				return false;
			}
			if(goDownEntryVO.getQu().equals(vo.getQu()) 
					&& goDownEntryVO.getPai().equals(vo.getPai())
					&& goDownEntryVO.getJia().equals(vo.getJia())
					&& goDownEntryVO.getWei().equals(vo.getWei())){
				return false;
			}
		}
		this.list.add(vo);
		return this.goDownEntry.createTicket(vo);
	}
	
	

	public ArrayList<GoDownEntryVO> getAll(long start , long end){
		this.list = this.goDownEntry.getAll(start , end);
		return list;
	}

	public boolean update(GoDownEntryVO vo) {
		for (GoDownEntryVO goDownEntryVO : list) {
			if(goDownEntryVO.getId().equals(vo.getId())){
				goDownEntryVO.setDate(vo.getDate());
				goDownEntryVO.setDestination(vo.getDestination());
				goDownEntryVO.setWarehouseOfWhichTranCenter(vo.getWarehouseOfWhichTranCenter());
				goDownEntryVO.setQu(vo.getQu());
				goDownEntryVO.setPai(vo.getPai());
				goDownEntryVO.setJia(vo.getJia());
				goDownEntryVO.setWei(vo.getWei());
				return this.goDownEntry.update(vo);
			}
		}
		return false;
	}
}
