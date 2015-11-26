package org.module.client.vo;

import org.module.common.po.State;

public class ReceivingListVO {

	//�ռ���
		private String date;
		private String location;
		//LogisticsVO logistics;
		private String origin;
		private String estination;
		private String orderId;
		private State state;
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
		public ReceivingListVO(String date, String location, String origin,
				String estination, String orderId,String state) {
			super();
			this.date = date;
			this.location = location;
			this.origin = origin;
			this.estination = estination;
			this.orderId = orderId;
			this.state = State.getInstance(state);
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		

}
