package businesslogicservice.managementBLservice;

import java.util.ArrayList;

import vo.PriceAndCityVO;

public interface PriceAndCityManageService {

	/**
	 * 前置：进入价格与城市管理
	 * 后置：显示所有城市
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<String> showAllCity();
	/**
	 * 前置：进入价格与城市管理，输入欲查找的城市
	 * 后置：显示各个城市与城市之间的距离
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @param city
	 * @return
	 */
	public ArrayList<PriceAndCityVO> showPartDirection(String city);
	/**
	 * 前置：进入价格与城市管理
	 * 后置：显示所有城市间价格
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<PriceAndCityVO> showAllDirection();
	/**
	 * 前置：选择增加城市，并输入
	 * 后置：默认新城市与其他城市间距离都是0；更新
	 * 依赖：PriceAndCityDataService.getAll 返回所有PO
	 * @return
	 */
	public boolean addCity(String city);
	
	/**
	 * 前置：选择城市，并输入城市间距离
	 * 后置：更新
	 * 依赖：PriceAndCityDataService.add 增加一个PO
	 * @param old
	 * @param direction
	 * @return
	 */
	public boolean setDiretion(PriceAndCityVO old,int direction);
	/**
	 * 前置：选择设置各费用（包装费/元，运费/元/km）
	 * 后置：更新
	 * 依赖：PriceAndCityDataService.update 更改一个PO
	 * @return
	 */
	public boolean setPrice(PriceAndCityVO old,double price);
}
