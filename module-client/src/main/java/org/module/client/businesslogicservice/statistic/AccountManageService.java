package org.module.client.businesslogicservice.statistic;

import java.util.ArrayList;

import org.module.client.vo.AccountVO;

public interface AccountManageService {
	/**
	 * 前置：输入关键字查找账户
	 * 后置：显示模糊查找结果
	 * 依赖：AccountDataService.getAll 返回所有账户信息
	 * @param s
	 * @return
	 */
	public AccountVO fuzzySearch(String s);
	/**
	 * 前置：新建一个账户并输入信息
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.add 增加一个账户PO
	 * @param 
	 * @return
	 */
	public boolean add(AccountVO vo);
	/**
	 * 前置：选择账户删除
	 * 后置：显示新账户列表 
	 * 依赖：AccountDataService.delete 删除一个账户PO 
	 * @param a
	 * @return
	 */
	public boolean delete(String id);
	/**
	 * 前置：选择账户删除
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.delete 删除账户
	 * @param a
	 * @return
	 */
	public boolean delete(ArrayList<String> a);
	/**
	 * 前置：选择账户修改信息
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.update 更新账户信息
	 * @param a
	 * @return
	 */
	public boolean update(AccountVO vo);
	/**
	 * 前置：新建收款单
	 * 后置：更新余额
	 * 依赖：AccountDataService.update 更改账户信息
	 * @param a
	 * @param b
	 * @return
	 */
	public boolean income(AccountVO vo);
	/**
	 * 前置：新建付款单
	 * 后置：更新余额
	 * 依赖：AccountDataService.update 更改账户信息
	 * @param id
	 * @param b
	 * @return
	 */
	public boolean pay(String id,double b);
}
