package org.module.client.vo;

import org.module.common.po.State;


public class SendingListVO {

		private String date;
		private String shippingId;
		private String SendMember;
		private State state;
		
		public SendingListVO(String date, String shippingId, String sendMember,String state) {
			super();
			this.date = date;
			this.shippingId = shippingId;
			SendMember = sendMember;
			this.setState(State.getInstance(state));
		}
		public SendingListVO(String[] a){
			this(a[0],a[1],a[2],a[3]);
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getShippingId() {
			return shippingId;
		}
		public void setShippingId(String shippingId) {
			this.shippingId = shippingId;
		}
		public String getSendMember() {
			return SendMember;
		}
		public void setSendMember(String sendMember) {
			SendMember = sendMember;
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		

}
