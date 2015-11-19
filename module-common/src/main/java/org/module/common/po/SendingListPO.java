package org.module.common.po;

public class SendingListPO {
	//派件单
		private String date;
		private String shippingId;
		private String SendMember;
		private State state;
		public SendingListPO(String date, String shippingId, String sendMember,
				State state) {
			super();
			this.date = date;
			this.shippingId = shippingId;
			SendMember = sendMember;
			this.state = state;
		}
		public String getDate() {
			return date;
		}
		public String getShippingId() {
			return shippingId;
		}
		public String getSendMember() {
			return SendMember;
		}
		public State getState() {
			return state;
		}
		

}
