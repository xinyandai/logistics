package dataservice.orderdataservice;

import java.util.ArrayList;

import po.OfficeArrivalListPO;

public interface OfficeArrivalListService {
	/**
	 * 前置：无
	 * 后置：返回所有PO
	 * @return
	 */
	public ArrayList<OfficeArrivalListPO> getAll();
	/**
	 * 前置：不存在相同ID的寄件单
	 * 后置：增加一个PO
	 * @return
	 */
    public boolean add(OfficeArrivalListPO o);
    /**
	 * 前置：欲修改的PO存在
	 * 后置：更新PO信息
	 * @param old
	 * @param newone
	 * @return
	 */
	public boolean updata(OfficeArrivalListPO newone);
    /**
	 * 前置：无
	 * 后置：删除所有PO
	 * @return
	 */
	public boolean clear();
}
