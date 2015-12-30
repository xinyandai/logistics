package org.module.client.businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import org.module.client.vo.CostListVO;


/**
 * 付款单管理（成本管理）
 * @author 
 *
 */
public interface CostManageBLService {

	/**
	 * 前置：VO中信息符合规范
                date是年-月-日-时-分-秒 ,
				money必须是数值,
				people不能为空 ,
				accout必须存在,
				state必须是State.submitted
				this.ID不能为空且与数据文件中已存在持久化对象的ID相同
	 * 后置：更新当前列表项，增加相应持久化对象，根据操作结果返回
	 * 依赖：CostDataService.add 增加一个付款单PO
	 * @param c
	 * @return
	 */
	public boolean add(CostListVO vo);
	/**
	 * 前置：无
	 * 后置：显示所有付款单
	 * 依赖：CostDataService.getAll 返回所有付款单
	 * @return
	 */
	public ArrayList<CostListVO> showAll(long startTime,long endTime);
	/**
	 * 前置：VO中信息符合规范
                date是年-月-日-时-分-秒 ,
				money必须是数值,
				people不能为空 ,
				accout必须存在,
				state必须State.submitted
				this.ID不能为空且与数据文件中已存在持久化对象的ID相同
	 * 后置：更新当前列表项，更新持久化对象，根据操作结果返回		
	 * 修改一个未审批或者审批不通过的付款单
	 * @param vo
	 * @return
	 */
	public boolean update(CostListVO vo);
	
}
