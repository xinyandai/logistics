package org.module.common.po;

import java.io.Serializable;

public class SendingListPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
			this.SendMember = sendMember;
			this.state = state;
		}
		
		final private String spt = ":%:%:";
		
		public SendingListPO(String string) {
			String[] s = string.split(spt);
			this.date = s[0];
			this.shippingId = s[1];
			this.SendMember = s[2];
			this.state = State.getInstance(s[3]);
		}
		
		@Override
		public String toString(){
			return this.date + this.spt +
					this.shippingId +this.spt +
					this.SendMember + this.spt +
					this.state.toString();
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
