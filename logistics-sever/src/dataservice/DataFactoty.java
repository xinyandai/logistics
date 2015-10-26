package dataservice;

public interface DataFactoty {

	/**
	 * 前置：  名为s 的对象应当是客观存在的
	 * 后置：  返回对应的对象
	 * @param s
	 * @return
	 */
	public Object creatDataObject(String s);
}
