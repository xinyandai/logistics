package org.module.client.businesslogicservice.statisticBLservice;

import java.util.ArrayList;

import org.module.client.vo.AccountVO;
import org.module.common.dataservice.MyList;



/**
 * 账户管理
 * @author 
 *
 */
public interface AccountManageBLService {

	/**
	 * 前置：查看账户列表
	 * 后置：显示所有账户列表
	 * 依赖：AccountDataService.getAll 返回所有账户信息
	 * @param s
	 * @return
	 */
	public ArrayList<AccountVO> showAll();
	/**
	 * 前置：输入关键字查找账户
	 * 后置：显示模糊查找结果
	 * 依赖：AccountDataService.getAll 返回所有账户信息
	 * @param s
	 * @return
	 */
	public ArrayList<AccountVO> fuzzySearch(String s);
	/**
	 * 前置：新建一个账户并输入信息
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.add 增加一个账户PO
	 * @param 
	 * @return
	 */
	public boolean add(String id,String rest);
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
	public boolean delete(MyList<String> a);
	/**
	 * 前置：选择账户修改信息
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.update 更新账户信息
	 * @param a
	 * @return
	 */
	public boolean update(String id,String rest);
	/**
	 * 前置：选择账户删除
	 * 后置：显示新账户列表
	 * 依赖：AccountDataService.delete 删除账户
	 * @param a 所有的将删除的PO的索引
	 * @return
	 */
	public boolean delete(int[] a);
}
