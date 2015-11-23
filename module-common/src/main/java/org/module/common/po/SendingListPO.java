package org.module.common.po;

public class SendingListPO {
	//派件单
		private String date;
		private String shippingId;
		private String SendMember;
		private State state;
		public SendingListPO(String date, String shippingId, String sendMember,
				String state) {
			super();
			this.date = date;
			this.shippingId = shippingId;
			SendMember = sendMember;
			this.state = State.getInstance(state);;
		}
		public SendingListPO(String[] a){
			this(a[0],a[1],a[2],a[3]);
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
