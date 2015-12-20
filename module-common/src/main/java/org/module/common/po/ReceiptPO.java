package org.module.common.po;

import java.io.Serializable;


public class ReceiptPO implements Serializable{
	
	
	private static final long serialVersionUID = -1488661806746880954L;
	final private String split = ":%:%:";
	//收款单
		private String date;
		private String money;
		private String Courier;
		private String[] orderId;
		
		private State state;
		
		private String writer;
		final private String inlinespt = "&&&&&&&";
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
			this.ID = s[5];
			this.writer = s[6];
		}
		
		@Override
		public String toString(){
			return this.date + this.split +
					this.money + this.split +
					this.Courier + this.split +
					this.getArrayToString( this.orderId )+ this.split +
					this.state.toString()
					+ this.split + this.ID+this.split + this.writer;
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
				String[] orderId, State state,String id,String w) {
			super();
			this.date = date;
			this.money = money;
			Courier = courier;
			this.orderId = orderId;
			this.state = state;
			this.ID = id;
			this.writer = w;
		}
		private String ID;
		public String getID() {
			return ID;
		}
		public String getWriter() {
			return this.writer;
		}
		
		
}
