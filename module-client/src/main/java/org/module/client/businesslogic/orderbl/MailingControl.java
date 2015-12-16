package org.module.client.businesslogic.orderbl;

import java.util.ArrayList;

import org.module.client.businesslogic.managementbl.PriceAndCity;
import org.module.client.businesslogicservice.management.PriceAndCityManageService;
import org.module.client.businesslogicservice.order.MailingService;
import org.module.client.businesslogicservice.orderBLservice.MailingBLService;
import org.module.client.vo.CityVO;
import org.module.client.vo.MailingListVO;


public class MailingControl implements MailingBLService{
	
	private MailingService mailingBLImpl;
	private ArrayList<CityVO> cityVOs;
	private PriceAndCityManageService priceAndcity = new PriceAndCity();
	private ArrayList<MailingListVO> list;
	
	
	private ArrayList<CityVO> showAllCity() {
		this.cityVOs = this.priceAndcity.showAllCity();
		return this.cityVOs;
	}
	
	public String[] getAllCitiesArray() {
		if(this.cityVOs==null){
			this.showAllCity();
		}
		String[] city = new String[cityVOs.size()];
		for (int i = 0; i < city.length; i++) {
			city[i] = cityVOs.get(i).getName();
		}
		return city;
	}
	
	
	public MailingControl( ) {
		super();
		this.mailingBLImpl = new Mailing();
	}
	public MailingControl(MailingService mailingBLImpl  ) {
		super();
		this.mailingBLImpl = mailingBLImpl;	
	}

	

	public int time(int senderCity, int receiveCity) {
		
		return mailingBLImpl.calculateTime(this.indexesToID(senderCity), this.indexesToID(receiveCity));
	}

	public double price(int senderCity, int receiveCity,  String costOfDecoration) {
		
		return mailingBLImpl.calculatePrice(this.indexesToID(senderCity),
				this.indexesToID(receiveCity),
				costOfDecoration);
	}
	
	
	public ArrayList<MailingListVO> getAll() {
		this.list =  this.mailingBLImpl.getAll();
		return this.list;
	}



	/**
	 * cityArraylist 的index查找该城市
	 * 然后返回城市ID
	 * @param i
	 * @return
	 */
	private String indexesToID(int i){
		return this.cityVOs.get(i).getId();
	}
	
	public boolean handleMailingList(MailingListVO mailingListVO) {
		
		if(this.list == null){
			this.getAll();
		}
		for(MailingListVO vo : list){
			if(vo.getId().equals(mailingListVO.getId())){
				return false;
			}
		}
		if(mailingBLImpl.creat(mailingListVO)){
			this.list.add(mailingListVO);
			return true;
		}
		return false;
	}

	public boolean update(MailingListVO vo) {
		if(this.list == null){
			this.getAll();
		}
		for(int i = 0; i<this.list.size(); i++){
			if(this.list.get(i).getId().equals(vo.getId())){
				this.list.remove(i);
				this.list.add(i, vo);
			}
		}
		return this.mailingBLImpl.update(vo);
	}
}
	


