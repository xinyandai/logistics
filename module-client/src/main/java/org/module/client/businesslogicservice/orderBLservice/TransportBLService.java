package org.module.client.businesslogicservice.orderBLservice;

import java.util.ArrayList;

import org.module.client.vo.TransportListVO;


/**
 * 中转单
 * @author 
 *
 */
public interface TransportBLService {
	/**
	 * 前置：新建中转单
	 * 后置：更新
	 * 依赖：TransportListService.add 增加一个中转单PO
	 * @param o
	 * @return
	 */
	public boolean creat(TransportListVO o);
	/**
	 * 前置：选择查看所有中转单
	 * 后置：显示所有中转单
	 * 依赖：TransportListService.getAll 返回所有中转单PO
	 * @return
	 */
	public ArrayList<TransportListVO> getAll();
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * 依赖：TransportListService.clear 清空数据
	 * @return
	 */
	public boolean clear();
	
}
