package org.module.client.businesslogic.managementbl;

import org.module.client.javaRMI.RmiClient;
import org.module.common.dataservice.managementdataservice.WarehouseConfigService;

public class WarehouseConfig {
	private WarehouseConfigService data = new RmiClient().get(WarehouseConfigService.class);
}
