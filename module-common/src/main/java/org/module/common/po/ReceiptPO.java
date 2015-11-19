package org.module.common.po;

public class ReceiptPO {
	//收款单
		private String date;
		private String money;
		private String Courier;
		private String orderId;
		
		private State state;

		public String getDate() {
			return date;
		}

		public String getMoney() {
			return money;
		}

		public String getCourier() {
			return Courier;
		}

		public String getOrderId() {
			return orderId;
		}

		public State getState() {
			return state;
		}

		public ReceiptPO(String date, String money, String courier,
				String orderId, String state) {
			super();
			this.date = date;
			this.money = money;
			Courier = courier;
			this.orderId = orderId;
			this.state = State.getInstance(state);
		}
		
		
}
