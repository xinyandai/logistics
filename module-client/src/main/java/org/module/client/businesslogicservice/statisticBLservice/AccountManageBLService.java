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
	 * 前置：无
	 * 查看账户列表
	 * 后置：返回所有账户集合，更新当前账户列表
	 * 依赖：AccountDataService.getAll 返回所有账户信息
	 * @param s
	 * @return
	 */
	public ArrayList<AccountVO> showAll();
	/**
	 * 前置：输入关键字符合规范
	 * 后置：查找并返回所有匹配的账户集合，更新当前账户列表
	 * 依赖：AccountDataService.getAll 返回所有账户信息
	 * @param s
	 * @return
	 */
	public ArrayList<AccountVO> fuzzySearch(String s);
	
	
	/**
	 * 前置：账户信息符合规范
	 * 后置：增加一个持久化对象，更新当前账户列表，根据操作结果返回      如果ID重复则直接返回false 不在增加持久化对象
	 * 依赖：AccountDataService.add 增加一个账户PO
	 * 
	 * @param 
	 * @return
	 */
	public boolean add(String id,String rest);
	
	
	/**
	 * 前置：id有效
	 * 后置：删除一个持久化对象，更新当前列表，根据操作结果返回
	 *       如果ID不存在于当前列表则直接返回false， 不再进行持久化对象删除 
	 * 依赖：AccountDataService.delete 删除一个账户PO 
	 * @param a
	 * @return
	 */
	public boolean delete(String id);
	/**
	 * 前置：前置：a中的所有ID有效
	 * 后置：删除一个持久化对象，更新当前列表，根据操作结果返回
	 *       如果ID不存在于当前列表则直接返回false， 不再进行持久化对象删除 
	 * 依赖：AccountDataService.delete 删除账户PO
	 * @param a 包含ID的列表
	 * @return
	 */
	public boolean delete(MyList<String> a);
	
	/**
	 * 前置：id有效，余额必须是数值
	 * 后置：更新账户列表， 更新持久化对象， 根据操作结果返回
	 * 依赖：AccountDataService.update 更新账户信息
	 * @param a
	 * @return
	 */
	public boolean update(String id,String rest);
	/**
	 * 前置：a中含有要删除的所有账户在当前列表中的索引， 不能越界
	 * 后置：显示新账户列表， 删除对应账户持久化对象， 根据删除结果返回
	 * 依赖：AccountDataService.delete 删除账户
	 * @param a 所有的将删除的PO的索引
	 * @return
	 */
	public boolean delete(int[] a);
}
