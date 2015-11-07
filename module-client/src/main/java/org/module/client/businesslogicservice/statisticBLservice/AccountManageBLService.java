package org.module.client.businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import org.module.client.vo.AccountVO;



/**
 * 账户管理
 * @author 
 *
 */
public interface AccountManageBLService {

	/**
	 * 前置：输入关键字查找账户
	 * 后置：显示模糊查找结果
	 * 依赖：AccountDataService.getAll 返回所有账户信息
	 * @param s
	 * @return
	 */
	public boolean fuzzySearch(String s);
	/**
	 * 前置：新建一个账户并输入信息
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.add 增加一个账户PO
	 * @param a
	 * @return
	 */
	public boolean add(AccountVO a);
	/**
	 * 前置：选择账户删除
	 * 后置：显示新账户列表 
	 * 依赖：AccountDataService.delete 删除一个账户PO 
	 * @param a
	 * @return
	 */
	public boolean delete(AccountVO a);
	/**
	 * 前置：选择账户删除
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.delete 删除账户
	 * @param a
	 * @return
	 */
	public boolean delete(ArrayList<AccountVO> a);
	/**
	 * 前置：选择账户修改信息
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.update 更新账户信息
	 * @param a
	 * @return
	 */
	public boolean updata(AccountVO a);
	/**
	 * 前置：新建收款单
	 * 后置：更新余额
	 * 依赖：AccountDataService.update 更改账户信息
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean income(AccountVO a,double b);
	/**
	 * 前置：新建付款单
	 * 后置：更新余额
	 * 依赖：AccountDataService.update 更改账户信息
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean pay(AccountVO a,double b);
}
