package org.module.client.businesslogicservice.userBLservice;

import java.util.ArrayList;

import org.module.client.vo.UserVO;

public interface UserManageBLService {

	/**
	 * 前置：管理员选择用户删除
	 * 后置：更新
	 * 依赖: UserDataService.delete 删除一个账号PO
	 * @param u
	 * @return
	 */
	public boolean delete(String id);
	/**
	 * 前置：管理新增用户
	 * 后置：更新
	 * 依赖: UserDataService.add 增加一个账号PO
	 * @param u
	 * @return
	 */
	public boolean add(UserVO u);
	/**
	 * 前置：更改账户信息
	 * 后置：更新
	 * 依赖: UserDataService.update 修改一个账号信息
	 * @param u
	 * @return
	 */
	public boolean update(UserVO u);
	/**
	 * 前置：无
	 * 后置：管理员查看所有账号信息
	 * 依赖: UserDataService.allUsers 返回所有账号信息
	 * @return
	 */
	public ArrayList<UserVO> getAll();
	
	/**
	 * 前置：管理员选择用户删除
	 * 后置：更新
	 * 依赖: UserDataService.delete 删除一个账号PO
	 * @param u
	 * @return
	 */
	public boolean delete(int[] indexes);
}
