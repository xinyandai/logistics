package org.module.client.businesslogicservice.management;

import org.module.client.vo.AbstractVO;
import org.module.common.dataservice.MyList;

public interface TicketAndorderVerify {
	/**
	 * 返回对应的vo由界面显示
	 * @return
	 */
	public MyList<? extends AbstractVO> getAll();
	/**
	 * 选择通过
	 * list中删除选择通过的vo 界面不再显示
	 * 并更改单据状态
	 * @param ids
	 * @return
	 */
	public boolean pass(int[] ids);
	/**
	 * 选择通过
	 * list中删除选择不通过的vo 界面不再显示
	 * 并更改单据状态
	 * @param ids
	 * @return
	 */
	public boolean unpass(int[] ids);
}
