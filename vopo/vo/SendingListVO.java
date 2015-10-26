package vo;
/**
 * 派件单
 * @author 
 *
 */
public class SendingListVO {

	//派件单
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
