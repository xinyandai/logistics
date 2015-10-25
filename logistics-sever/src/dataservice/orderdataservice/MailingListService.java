package dataservice.orderdataservice;

import java.util.ArrayList;
import po.MailingListPO;

/**
 * 寄件单
 * @author 
 *
 */
public interface MailingListService {
 
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<MailingListPO> getAll();
	/**
	 * 前置：不存在相同ID的寄件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(MailingListPO o);
    /**
	 * 前置：欲修改的PO存在
	 * 后置：更新PO信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean updata(MailingListPO newone);
    /**
	 * 前置：无
	 * 后置：删除所有PO
	 * @return
	 */
	public boolean clear();
}
