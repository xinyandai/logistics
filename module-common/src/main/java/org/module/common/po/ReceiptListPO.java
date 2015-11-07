package org.module.common.po;

public class ReceiptListPO {
	//收款单
		private String date;
		private String money;
		private String Courier;
		private String orderId;
		public ReceiptListPO(String date, String money, String courier,
				String orderId) {
			super();
			this.date = date;
			this.money = money;
			Courier = courier;
			this.orderId = orderId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getMoney() {
			return money;
		}
		public void setMoney(String money) {
			this.money = money;
		}
		public String getCourier() {
			return Courier;
		}
		public void setCourier(String courier) {
			Courier = courier;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		
}
