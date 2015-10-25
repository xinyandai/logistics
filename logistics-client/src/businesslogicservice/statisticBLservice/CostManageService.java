package businesslogicservice.statisticBLservice;


import java.util.ArrayList;

import vo.CostListVO;

/**
 * 付款单管理（成本管理）
 * @author 
 *
 */
public interface CostManageService {

	/**
	 * 前置：新建付款单并输入信息
	 * 后置：保存付款单
	 * @param c
	 * @return
	 */
	public boolean creatCostList(CostListVO c);
	/**
	 * 前置：选择查看所有成本支出
	 * 后置：显示所有付款单
	 * @return
	 */
	public ArrayList<CostListVO> showCostList(double startTime,double endTime);
	/**
	 *前置：选择起初建账户进行初始化
	 *后置：清空订单
	 * @return
	 */
	public boolean clear();
}
