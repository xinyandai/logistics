package businesslogicservice.statisticBLservice;

public interface InitAccountService {

	/**
	 * 前置：选择期初建账
	 * 后置：保存期初账户信息
	 * @return
	 */
	public boolean init();
}
