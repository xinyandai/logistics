package org.module.client.vo;

import org.module.common.po.SendingListPO;
import org.module.common.po.State;


public class SendingListVO  extends AbstractVO{

		private String date;
		private String shippingId;
		private String SendMember;
		private State state;
		
		private String writer;
		
		public SendingListVO(String date, String shippingId, String sendMember,State state,String w) {
			super();
			this.date = date;
			this.shippingId = shippingId;
			SendMember = sendMember;
			this.setState(state);
			this.writer = w;
		}
		
		public SendingListVO(SendingListPO sendingListPO) {
			this(
					sendingListPO.getDate(),
					sendingListPO.getShippingId(),
					sendingListPO.getSendMember(),
					sendingListPO.getState(),
					sendingListPO.getWriter()
					);
		}
		
		public  SendingListPO toPO( ){
			return new SendingListPO(getDate(),getShippingId(),getSendMember(),getState(),writer); 
		}
		
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
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

		public String[] toArray(){
			String[] s = {
					getDate(),getShippingId(),getSendMember(),state.toString()
			};
			return s;
		}
		
		@Override
		public String get(int i) {
			return this.toArray()[i];
		}

		@Override
		public String[] names() {
			String[] s = {
					"派件时间","快递单号","派件人","单据状态"
			};
		    return s;
		}
		

}
