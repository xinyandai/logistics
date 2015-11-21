package org.module.server.data.statistcdate;

import java.io.File;
import java.util.ArrayList;

import org.module.common.dataservice.statisticdataservice.CostDataService;
import org.module.common.po.CostListPO;
import org.module.server.data.FileHelper;

public class CostDataImpl implements CostDataService {
	private FileHelper helper = new FileHelper(new File("src"+File.separator+".txt"));
	public CostDataImpl() {
		// TODO Auto-generated constructor stub
	}

	public boolean addCostList(CostListPO c) {
		
		return this.helper.add(c);
	}

	public ArrayList<CostListPO> getAll() {
		ArrayList<CostListPO> re = new ArrayList<CostListPO>();
		ArrayList<String> strs = this.helper.read();
		for (String string : strs) {
			re.add(new CostListPO(string));
		}
		return re;
	}

}
