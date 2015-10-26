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
	 * 依赖：ReceiptListService.getAll 返回所有的收款单信息
	 * @return
	 */
	public ArrayList<ReceiptListVO> showIncomeList(double startTime,double endTime);

}
