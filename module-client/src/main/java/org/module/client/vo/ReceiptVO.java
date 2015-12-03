package org.module.client.vo;

public class ReceiptVO extends AbstractVO{

	    private String date;
		private double money;
		private String Courier;
		private String[] orderId;
		
		public ReceiptVO(String date, String money, String courier,
				String[] orderId) {
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
		public String[] getOrderId() {
			return orderId;
		}
		public void setOrderId(String[] orderId) {
			this.orderId = orderId;
		}
		
		public String arrayToString(String[] s){
			String spt = " ";
			StringBuffer re = new StringBuffer("");
			for (int i = 0; i < s.length; i++) {
				re.append( s[i]  );
				re.append(spt);
			}
			return re.toString();
		}
		
		public String[] array(){
			String[] s = {this.date ,
			this.money +"",
			Courier ,
			this.arrayToString(orderId)
			};
			return s;
			
		}
		
		public int getNum() {
			// TODO Auto-generated method stub
			return 0;
		}
		@Override
		public String get(int i) {
			// TODO Auto-generated method stub
			return this.array()[i];
		}
		

}
