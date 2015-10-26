package businesslogicservice.userBLservice;

import java.util.ArrayList;

import vo.UserVO;

public interface UserBLservice {

	/**
	 * 前置：用户存在，口令正确，选择正确的用户类型
	 * 后置：登录
	 * 依赖: UserDataService.allUsers 返回所有账号信息
	 * @param u
	 * @return
	 */
	public boolean login(UserVO u);
	/**
	 * 前置：管理员选择用户删除
	 * 后置：更新
	 * 依赖: UserDataService.delete 删除一个账号PO
	 * @param u
	 * @return
	 */
	public boolean deleteUser(UserVO u);
	/**
	 * 前置：管理新增用户
	 * 后置：更新
	 * 依赖: UserDataService.add 增加一个账号PO
	 * @param u
	 * @return
	 */
	public boolean addUser(UserVO u);
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
	public ArrayList<UserVO> allUsers();
}
