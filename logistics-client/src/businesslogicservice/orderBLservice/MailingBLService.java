package businesslogicservice.orderBLservice;

import java.util.ArrayList;

import vo.MailingListVO;
/**
 * 寄件
 * @author 华硕
 */
public interface MailingBLService {

	/**
	 * 前置：订单输入
	 * 后置：显示价格
	 * 依赖：PriceAndCityDataService.getAll 得到所有城市间价格
	 * @param m
	 * @return
	 */
	public double calculatePrice(MailingListVO m);

	/**
	 * 前置：订单输入
	 * 后置：显示估计时间
	 * 依赖：MailingListService.getAll 得到所有PO
	 * @param m
	 * @return
	 */
	public double calculateTime(MailingListVO m);
	/**
	 * 前置：新建寄件单
	 * 后置：更新信息
	 * 依赖：MailingListService.add 增加一个PO
	 * @param o
	 * @return
	 */
	public boolean creat(MailingListVO o);
	/**
	 * 前置：选择查看所有订单
	 * 后置：显示所有订单
	 * 依赖：MailingListService.getAll 返回所有PO
	 * @return
	 */
	public ArrayList<MailingListVO> getAll();
	
}
