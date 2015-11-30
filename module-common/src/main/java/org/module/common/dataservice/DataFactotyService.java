package org.module.common.dataservice;

import java.rmi.RemoteException;


public interface DataFactotyService {

	/**
	 * 前置：  名为s 的对象应当是客观存在的
	 * 后置：  返回对应的对象
	 * @param s 包下类名
	 * @return
	 * @throws RemoteException 
	 */
	public Object creatDataObject(String s) throws RemoteException;
}
