package org.module.client.businesslogicservice.userBLservice;


public interface UserLoginBLService {
	/**
	 * 前置：用户存在，口令正确，选择正确的用户类型
	 * 后置：登录
	 * 依赖: UserDataService.allUsers 返回所有账号信息
	 * @param u
	 * @return
	 */
	public boolean login(String id,String password,String role);
}
