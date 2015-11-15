package org.module.client.vo;

public class ReceiptListVO {
	//�տ
		private String date;
		private double money;
		private String Courier;
		private String orderId;
		public ReceiptListVO(String date, String money, String courier,
				String orderId) {
			super();
			this.date = date;
			this.money = Double.parseDouble(money) ;
			Courier = courier;
			this.orderId = orderId;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public double getMoney() {
			return money;
		}
		public void setMoney(double money) {
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
