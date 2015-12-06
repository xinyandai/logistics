package org.module.client.businesslogic.managementbl;

import java.util.ArrayList;

import org.module.client.businesslogicservice.management.WarehouseConfigService;
import org.module.client.businesslogicservice.managementBLservice.WarehouseConfigBLService;
import org.module.client.main.Main;
import org.module.client.vo.WarehouseConfigVO;

public class WarehouseConfigController implements WarehouseConfigBLService {

	private WarehouseConfigService warehouse = new WarehouseConfig();
	
	private WarehouseConfigVO warehouseConfigVO;

	public ArrayList<WarehouseConfigVO> getAll() {

		return this.warehouse.getAll();
	}

	

	public WarehouseConfigVO find() {

		return this.warehouse.find(Main.currentUser.getDepartmeny());
	}

	
	
	public boolean update(String qu, String size, String borderline) {
		
		WarehouseConfigVO vo = this.find();
		String[] priviousQus = vo.getQus();
		
		/**
		 * 如果没有增加区
		 */
		for (int i=0; i<priviousQus.length; i++) {
			if(priviousQus[i].equals(qu)){
				vo.getSizeOfQu()[i] = size;
				vo.getBorderline()[i] = borderline;
				return this.warehouse.update(vo);
			}
		}
		
		
		
		/**
		 * 如果增加了新的区
		 */
		//增加区
		String[] newQus = new String[priviousQus.length + 1];
		for (int i=0; i<priviousQus.length; i++) {
			newQus[i] = priviousQus[i];
		}
		newQus[priviousQus.length] = qu;
		
		//增加相应的区大小
		String[] priviousSizes = vo.getSizeOfQu();
		String[] newSize = new String[priviousSizes.length + 1];
		for (int i=0; i<priviousSizes.length; i++) {
			newSize[i] = priviousSizes[i];
		}
		newSize[priviousSizes.length] = qu;
		
		//增加相应的区警戒比例
		String[] previousBorderLine = vo.getBorderline();
		String[] newBorderLine = new String[previousBorderLine.length + 1];
		for (int i = 0; i < previousBorderLine.length; i++) {
			newBorderLine[i] = previousBorderLine[i];
		}
		newBorderLine[previousBorderLine.length] = borderline;
		
		
		vo.setQus(newQus);
		vo.setSizeOfQu(newSize);
		vo.setBorderline(newBorderLine);
		return this.warehouse.update(vo);
	}



	public String calculateCurrentBorderLine(String qu) {
		
		return null;
	}

	public String[] getQus(){
		if(this.warehouseConfigVO==null){
			this.warehouseConfigVO = this.find();
		}
		if(this.warehouseConfigVO == null){
			String[] s = {};
			return s;
		}
		return this.warehouseConfigVO.getQus();
	}



	public String getQuSize(String qu) {
		String[] qus = this.warehouseConfigVO.getQus();
		String[] size = this.warehouseConfigVO.getSizeOfQu();
		for (int i = 0; i < qus.length; i++) {
			if(qus[i].equals(qu)){
				return size[i];
			}
		}
		return "分区不存在";
	}



	public String getBorderLine(String qu) {
		
		String[] qus = this.warehouseConfigVO.getQus();
		String[] borderline = this.warehouseConfigVO.getBorderline();
		for (int i = 0; i < qus.length; i++) {
			if(qus[i].equals(qu)){
				return borderline[i];
			}
		}
		return "分区未创立";
	}
}
