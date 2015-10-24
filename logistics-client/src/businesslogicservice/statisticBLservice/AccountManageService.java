package businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import vo.AccountVO;

/**
 * 账户管理
 * @author 
 *
 */
public interface AccountManageService {

	/**
	 * 前置：输入关键字查找账户
	 * 后置：显示模糊查找结果
	 * @param s
	 * @return
	 */
	public boolean fuzzySearch(String s);
	/**
	 * 前置：新建一个账户并输入信息
	 * 后置：显示新账户列表
	 * @param a
	 * @return
	 */
	public boolean add(AccountVO a);
	/**
	 * 前置：选择账户删除
	 * 后置：显示新账户列表
	 * @param a
	 * @return
	 */
	public boolean delete(AccountVO a);
	/**
	 * 前置：选择账户删除
	 * 后置：显示新账户列表
	 * @param a
	 * @return
	 */
	public boolean delete(ArrayList<AccountVO> a);
	/**
	 * 前置：选择账户修改信息
	 * 后置：显示新账户列表
	 * @param a
	 * @return
	 */
	public boolean updata(AccountVO a);
	/**
	 * 前置：新建收款单
	 * 后置：更新余额
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean income(AccountVO a,double b);
	/**
	 * 前置：新建付款单
	 * 后置：更新余额
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean pay(AccountVO a,double b);
}
