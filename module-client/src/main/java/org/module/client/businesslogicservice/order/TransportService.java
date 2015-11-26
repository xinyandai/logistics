package org.module.client.businesslogicservice.order;

import java.util.ArrayList;

import org.module.client.vo.TransportListVO;
import org.module.common.po.State;


/**
 * 中转单
 * @author 
 *
 */
public interface TransportService {
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
	public ArrayList<TransportListVO> getAll(State s);
	
	
}
