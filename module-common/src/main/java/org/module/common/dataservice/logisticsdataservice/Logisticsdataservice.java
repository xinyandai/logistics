package org.module.common.dataservice.logisticsdataservice;

import java.util.ArrayList;

import org.module.common.po.LogisticsPO;


public interface Logisticsdataservice {
	/**
	 * 20151022
	 * 物流信息
	 * @author 颜
	 */
	public interface LogisticsDataService {

		/**
		 * 前置：无
		 * 后置：返回所有物流信息
		 * @return
		 */
		public ArrayList<LogisticsPO> getAll();
		/**
		 * 前置：订单号存在
		 * 后置：返回订单信息
		 * @return
		 */
		public LogisticsPO getOrder(String id);
		/**
		 * 前置：欲修改的PO存在
		 * 后置：更新PO信息
		 * @param old
		 * @param newone
		 * @return
		 */
		public boolean updata(LogisticsPO old,LogisticsPO newone);
		/**
		 * 前置：无
		 * 后置：删除所有PO
		 * @return
		 */
		public boolean clear();
	}

}
