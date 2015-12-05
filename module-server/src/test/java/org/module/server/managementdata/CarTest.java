package org.module.server.managementdata;

import java.rmi.RemoteException;

import org.module.common.po.CarPO;
import org.module.server.data.managementdata.CarDataImpl;

import junit.framework.TestCase;

public class CarTest extends TestCase{
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void test(){
		CarDataImpl car;
		try {
			car = new CarDataImpl();
			CarPO po=new CarPO("08025001001","09025001001","20080808");
			car.add(po);
			CarPO po1=car.getAll().get(0);
			assert(po.toString().equals(po1.toString()));
			
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

