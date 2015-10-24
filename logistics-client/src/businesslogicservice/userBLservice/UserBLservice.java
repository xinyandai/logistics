package businesslogicservice.userBLservice;

import vo.UserVO;

public interface UserBLservice {

	/**
	 * 前置：用户存在，口令正确，选择正确的用户类型
	 * 后置：登录
	 * @param u
	 * @return
	 */
	public boolean login(UserVO u);
	/**
	 * 前置：管理员选择用户删除
	 * 后置：更新
	 * @param u
	 * @return
	 */
	public boolean deleteUser(UserVO u);
	/**
	 * 前置：管理新增用户
	 * 后置：更新
	 * @param u
	 * @return
	 */
	public boolean addUser(UserVO u);
	/**
	 * 前置：用户更改账户信息
	 * 后置：更新
	 * @param u
	 * @return
	 */
	public boolean updata(UserVO u);
}
