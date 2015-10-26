package businesslogicservice.managementBLservice;

import java.util.ArrayList;

import vo.DriverVO;

public interface DriversMangeService {

	/**
	 * 前置：选择司机信息管理
	 * 后置：显示所有司机信息
	 * 依赖：DriversDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<DriverVO> showAll();
	/**
	 * 前置：选择增加司机并输入司机信息
	 * 后置：更新
	 * 依赖：DriversDataService.add  增加一个PO
	 * @param c
	 * @return
	 */
	public boolean add(DriverVO c);
	/**
	 * 前置：选择司机进行更改
	 * 后置：更新
	 * 依赖：DriversDataService.update 修改一个PO
	 * @param 
	 * @return
	 */
	public boolean modify(DriverVO newone);
	/**
	 * 前置：批量选择司机信息并删除
	 * 后置：更新
	 * 依赖：DriversDataService.delete 删除一些PO
	 * @param al
	 * @return
	 */
	public boolean delete(ArrayList<DriverVO> al);
	/**
	 * 前置：输入关键字模糊查找
	 * 后置：返回查找结果
	 * 依赖：DriversDataService.getAll 返回所有PO
	 * @param s
	 * @return
	 */
	public ArrayList<DriverVO> fuzzySearch(String s);
	
}
