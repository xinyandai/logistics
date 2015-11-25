package org.module.server.managementdata;


import org.module.common.po.WarehousePO;
import org.module.server.data.managementdata.WarahouseDataImpl;

import junit.framework.TestCase;

public class WarahouseTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}


	public void test(){
		WarahouseDataImpl Warahouse;
		Warahouse = new WarahouseDataImpl();
		WarehousePO po=new WarehousePO("001","01","01","01","01");
		/*Warahouse.setBorderline(3);
		assert(Warahouse.getBorderline()==5);*/
		WarehousePO po1=new WarehousePO("002","01","01","01","02");
		Warahouse.add(po);
		Warahouse.update(po, po1);
		assert(Warahouse.getAll().get(0).toString().equals(po1.toString()));
		
		
	}
}
