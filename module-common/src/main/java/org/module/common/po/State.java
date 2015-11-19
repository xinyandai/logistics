package org.module.common.po;
/**
 * 所有单据的状态  
 * @author 
 *
 */
public enum State {

	/**
	 * 提交未审核状态
	 */
	SUBMITTED("提交"),
   /**
    * 审核通过状态
    */
	PASS("通过"),
	/**
	 * 审核不通过状态
	 */
	UNPASS("不通过");
	
	private String s;
	
	private State(String string){
		s = string;
	}
	
	@Override
	public String toString(){
		return s;
	}
	public static State getInstance(String s){
		if(s.equals("提交"))       return State.SUBMITTED;
		else if(s.equals("通过"))  return State.PASS;
		else if(s.equals("不通过"))  return State.UNPASS;
		return null;
	}
}
