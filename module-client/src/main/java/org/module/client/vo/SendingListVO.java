package org.module.client.vo;


public class SendingListVO {

	//�ɼ���
		private String date;
		private String shippingId;
		private String SendMember;
		public SendingListVO(String date, String shippingId, String sendMember) {
			super();
			this.date = date;
			this.shippingId = shippingId;
			SendMember = sendMember;
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
		

}
