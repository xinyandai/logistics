package vo;

import vo.LogisticsVO;

public class ReceiveListVO {

	//ÊÕ¼þµ¥
		private String date;
		private String location;
		//LogisticsVO logistics;
		private String origin;
		private String estination;
		private String orderId;
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getEstination() {
			return estination;
		}
		public void setEstination(String estination) {
			this.estination = estination;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public ReceiveListVO(String date, String location, String origin,
				String estination, String orderId) {
			super();
			this.date = date;
			this.location = location;
			this.origin = origin;
			this.estination = estination;
			this.orderId = orderId;
		}
		

}
