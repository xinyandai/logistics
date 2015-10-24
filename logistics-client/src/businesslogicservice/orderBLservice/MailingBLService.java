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
	 * @param m
	 * @return
	 */
	public double calculatePrice(MailingListVO m);

	/**
	 * 前置：订单输入
	 * 后置：显示估计时间
	 * @param m
	 * @return
	 */
	public double calculateTime(MailingListVO m);
	/**
	 * 前置：新建寄件单
	 * 后置：更新信息
	 * @param o
	 * @return
	 */
	public boolean creat(MailingListVO o);
	/**
	 * 前置：选择查看所有订单
	 * 后置：显示所有订单
	 * @return
	 */
	public ArrayList<MailingListVO> getAll();
	
}
