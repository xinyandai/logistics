package org.module.common.po;

public abstract class AbstractPO {
	/**
	 * 唯一标识符
	 * @return
	 */
	public abstract String getNniqueID();
	/**
	 * the writer : like who submitted this order
	 * or the department: like which warehouse the goDownEntryList belongs to
	 * @return
	 */
	public abstract String getBelongsToPersonOrDepartment();
	/**
	 * 当前单据的状态
	 * @return
	 */
	public abstract State getState() ;
}
