package org.module.common.po;

import java.io.Serializable;

public class SendingListPO extends AbstractPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//派件单
		private String date;
		private String shippingId;
		private String SendMember;
		private State state;
		
		private String writer;
		
		public SendingListPO(String date, String shippingId, String sendMember,
				State state, String w) {
			super();
			this.date = date;
			this.shippingId = shippingId;
			this.SendMember = sendMember;
			this.state = state;
			this.writer = w;
		}
		
		final private String spt = ":%:%:";
		
		public SendingListPO(String string) {
			String[] s = string.split(spt);
			this.date = s[0];
			this.shippingId = s[1];
			this.SendMember = s[2];
			this.state = State.getInstance(s[3]);
			this.writer = s[4];
		}
		
		@Override
		public String toString(){
			return this.date + this.spt +
					this.shippingId +this.spt +
					this.SendMember + this.spt +
					this.state.toString()+this.spt + this.writer;
		}
		@Override
		public String getBelongsToPersonOrDepartment() {
			// TODO Auto-generated method stub
			return this.writer;
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
		public String getWriter() {
			return this.writer;
		}

		@Override
		public String getNniqueID() {
			// TODO Auto-generated method stub
			return this.getShippingId();
		}

}
