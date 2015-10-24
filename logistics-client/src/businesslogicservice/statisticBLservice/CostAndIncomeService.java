package businesslogicservice.statisticBLservice;


/**
 * 付款单管理
 * @author 
 *
 */
public interface CostAndIncomeService {

	/**
	 * 前置： 选择查看成本收益表
	 * 后置：显示总成本
	 * @return
	 */
	public double getCost();
	/**
	 * 前置：选择查看成本收益表
	 * 后置：显示总收益
	 * @return
	 */
	public double getIncome();
	
	}
