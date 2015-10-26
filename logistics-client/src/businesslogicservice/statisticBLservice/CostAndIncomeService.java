package businesslogicservice.statisticBLservice;


/**
 * 
 * @author 
 *
 */
public interface CostAndIncomeService {

	/**
	 * 前置： 选择查看成本收益表
	 * 后置：显示总成本
	 * 依赖：CostDataService.getAll 返回所有的付款单信息
	 * @return
	 */
	public double getCost();
	/**
	 * 前置：选择查看成本收益表
	 * 后置：显示总收益
	 * 依赖：ReceiptListService.getAll 返回所有的收款单
	 * @return
	 */
	public double getIncome();
	
	}
