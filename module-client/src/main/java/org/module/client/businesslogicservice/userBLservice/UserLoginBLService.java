package org.module.client.businesslogicservice.userBLservice;


public interface UserLoginBLService {
	/**
	 * 前置：用户存在，口令正确，选择正确的用户类型
	 * 后置：根据输入信息查找PO，返回是否登录成功，成功则设置当前用户信息
	 * 依赖: UserDataService.find（String id） 根据账户名查找ID
	 * @param u
	 * @return
	 */
	public boolean login(String id,String password,String role);
	
}
