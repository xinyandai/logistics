package org.module.server.managementdata;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.module.common.po.WarehouseConfigPO;
import org.module.server.data.managementdata.WarehouseConfigDataImpl;

import junit.framework.TestCase;

public class WarehouseConfigTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}



	public void testFind() {
		try {
			WarehouseConfigDataImpl config = new WarehouseConfigDataImpl();
			ArrayList<WarehouseConfigPO> pos = config.getAll();
			if(pos.size()>0){
				System.out.println(pos.get(0).toString());
				String[] s = pos.get(0).getQus();
				assert(s.length>-1);
				
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

	

}
