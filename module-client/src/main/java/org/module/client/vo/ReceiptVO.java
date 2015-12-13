package org.module.client.vo;

import org.module.common.po.ReceiptPO;
import org.module.common.po.State;

public class ReceiptVO extends AbstractVO{

	
	   
		private String date;
		private double money;
		private String Courier;
		private String[] orderId;
		private State state;
		
		public ReceiptVO (ReceiptPO po){
			this(po.getDate() , 
							po.getMoney() ,
							po.getCourier() ,
							po.getOrderId(),
							po.getState(),
							po.getID());
		}
		
		public ReceiptPO toPo (){
			return new ReceiptPO(
					getDate() , 
					getMoney()+"" ,
					getCourier() ,
					getOrderId(),
					getState(),
					this.getID()
					);
		}
		
		public State getState() {
			return state;
		}

		public void setState(State state) {
			this.state = state;
		}

		public ReceiptVO(String date, String money, String courier,
				String[] orderId,State state,String id) {
			super();
			this.date = date;
			this.money = Double.parseDouble(money) ;
			Courier = courier;
			this.orderId = orderId;
			this.state = state;
			this.ID = id;
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
		
		private String ID;
			
		public String getID() {
			return ID;
		}

		public void setID(String iD) {
			ID = iD;
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
			this.arrayToString(orderId),
			this.getState().toString()
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
		@Override
		public String[] names() {
			String[] s = {
					"日期","金额","快递员","托运单号","状态"
			};
		    return s;
		}
		

}
