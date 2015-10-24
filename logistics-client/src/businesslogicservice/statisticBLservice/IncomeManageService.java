package businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import vo.ReceiptListVO;

/**
 * 收款单统计
 * @author 
 *
 */
public interface IncomeManageService {

	/**
	 * 前置：选择查看所有收款
	 * 后置：显示所有收款单
	 * @return
	 */
	public ArrayList<ReceiptListVO> showIncomeList(double startTime,double endTime);

}
