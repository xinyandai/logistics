package org.module.client.businesslogicservice.userBLservice;

import java.util.ArrayList;

import org.module.client.vo.UserVO;

public interface UserManageBLService {

	/**
	 * 前置：id必须有效存在
	 * 后置：更新当前显示列表； 删除一个持久化对象； 根据操作结果返回
	 * 依赖: UserDataService.delete 删除一个账号PO
	 * @param u
	 * @return
	 */
	public boolean delete(String id);
	/**
	 * 前置：userVO的属性必须符合规范且id不与已存在账户相同
	 * 后置：更新当前显示列表， 增加一个账户持久化对象， 根据操作结果返回
	 * 依赖: UserDataService.add 增加一个账号PO
	 * @param u
	 * @return
	 */
	public boolean add(UserVO u);
	/**
	 * 前置：userVO的属性必须符合规范且id与已存在账户相同
	 * 后置：更新当前显示列表，更新一个账户持久化对象， 根据操作结果返回
	 * 依赖: UserDataService.update 修改一个账号信息
	 * @param u
	 * @return
	 */
	public boolean update(UserVO u);
	/**
	 * 前置：无
	 * 后置：返回所有账户组成的列表
	 * 依赖: UserDataService.allUsers 返回所有账号信息
	 * @return
	 */
	public ArrayList<UserVO> getAll();
	
	/**
	 * 前置：indexes是当前显示列表的索引号数组， 其中每个值不能越界
	 * 后置：更新当前显示列表，删除对应账户持久化对象， 根据操作结果返回
	 * 依赖: UserDataService.delete 删除一个账号PO
	 * @param u
	 * @return
	 */
	public boolean delete(int[] indexes);
}
