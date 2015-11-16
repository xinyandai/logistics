package org.module.client.businesslogicservice.order;

import java.util.ArrayList;

import org.module.client.vo.OfficeArrivalListVO;


/**
 * 
 * @author 营业厅接单
 *
 */
public interface OfficeArrivalService {
	/**
	 * 前置：新建营业厅接收单
	 * 后置：更新
	 * 依赖：OfficeArrivalListService.add 增加一个营业厅接受单PO
	 * @param o
	 * @return
	 */
	public boolean creat(OfficeArrivalListVO o);
	/**
	 * 前置：选择查看所有营业厅接收单
	 * 后置：显示所有营业厅接收单
	 * 依赖：OfficeArrivalListService.getAll 返回所有的营业厅接受单
	 * @return
	 */
	public ArrayList<OfficeArrivalListVO> getAll();
	
}
