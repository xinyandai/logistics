package dataservice.managementdataservice;

import java.util.ArrayList;

import po.WarehousePO;

/**
 * 20151022
 * 仓库信息
 * @author 颜
 */
public interface WarahouseDataService {
	/**
	 * 前置：无
	 * 后置：返回所有库存PO
	 * @return
	 */
	public ArrayList<WarehousePO> getAll();
	/**
	 * 前置：原PO不存在
	 * 后置：增加一个PO
	 * @param cp
	 * @return
	 */
	public boolean add(WarehousePO cp);
	/**
	 * 前置：原PO存在
	 * 后置：删除一个PO
	 * @param cp
	 * @return
	 */
	public boolean delete(WarehousePO cp);
    /**
     * 前置：原库存PO存在
     * 后置：修改一个PO
     * @param old
     * @param newone
     * @return
     */
	public boolean update(WarehousePO old,WarehousePO newone);
	/**
	 * 前置：无
	 * 后置：更新
	 * @param a
	 */
	public void setBorderline(double a); 
}
