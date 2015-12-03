package org.module.common.po;

import java.io.Serializable;


public class ReceiptPO implements Serializable{
	
	   /**
	 * 
	 */
	private static final long serialVersionUID = -1488661806746880954L;
	final private String split = ":%:%:";
	//收款单
		private String date;
		private String money;
		private String Courier;
		private String[] orderId;
		
		private State state;
		
		
		final private String inlinespt = "#*#*#";
		/**
		 * 把订单号数组转化为字符串
		 * @param s
		 * @return
		 */
		private String getArrayToString(String[] s){
			String re = "";
			for (String string : s) {
				re += string + this.inlinespt;
			}
			return re;
		}
		public ReceiptPO(String str){
			String[] s = str.split(split);
			this.date = s[0];
			this.money = s[1];
			this.Courier = s[2];
			this.orderId = s[3].split(inlinespt);
			this.state = State.getInstance(s[4]);
		}
		
		@Override
		public String toString(){
			return this.date + this.split +
					this.money + this.split +
					this.Courier + this.split +
					this.getArrayToString( this.orderId )+ this.split +
					this.state.toString();
		}
		
		public String getDate() {
			return date;
		}

		public String getMoney() {
			return money;
		}

		public String getCourier() {
			return Courier;
		}

		public String[] getOrderId() {
			return orderId;
		}

		public State getState() {
			return state;
		}

		public ReceiptPO(String date, String money, String courier,
				String[] orderId, State state) {
			super();
			this.date = date;
			this.money = money;
			Courier = courier;
			this.orderId = orderId;
			this.state = state;
		}

		
		
		
}
