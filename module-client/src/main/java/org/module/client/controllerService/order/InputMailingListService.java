package org.module.client.controllerService.order;


public interface InputMailingListService {

	/**
	 * 处理寄件单的输入
	 * @return
	 */
	public boolean handleMailingList(      
			
			String  senderName,
			String  senderCompany,
			String  senderMobile,
			String  senderPhone,
			String  senderCity,
			String  senderPosition,
			String  receiveName,
			String  receiveCompany,
			String  receiveMobile,
			String  receivePhone,
			String  receiveCity,
			String  receivePosition,
			String  nameOfGood,
			String  counts,
			String  weight,
			String  volume,
			String  costOfDecoration,
			String  type,
			String  id
			);


	/**
	 * 计算报价
	 * @param city1
	 * @param city2
	 * @return
	 */
    public int price(String senderCity,
    		String receiveCity,
    		String  counts,
			String  weight,
			String  volume,  
			String  costOfDecoration,
			String type);
    /**
     * 估算时间
     * @param city1
     * @param city2
     * @return
     */
    public int time(String city1,String city2);
}
