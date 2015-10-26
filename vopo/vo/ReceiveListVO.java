package vo;

import vo.LogisticsVO;

public class ReceiveListVO {

	//ÊÕ¼þµ¥
		private String date;
		private String location;
		LogisticsVO logistics;
		public ReceiveListVO(String date, String location, LogisticsVO logistics) {
			super();
			this.date = date;
			this.location = location;
			this.logistics = logistics;
		}
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
		public LogisticsVO getLogistics() {
			return logistics;
		}
		public void setLogistics(LogisticsVO logistics) {
			this.logistics = logistics;
		}


}
