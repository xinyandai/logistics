package org.module.common.po;

public class TransportListPO {
	//中转单
		private String car;
		private String LoadingDate;
		private String transListId;
		private String carId;
		private String origin;
		private String arrival;
		/**
		 * 货柜号
		 */
		private String counterId;
		/**
		 * 监装员
		 */
		private String Supervision;
		private String[] shippingId;
		private String price;
		private State state;
		
		
		
		public TransportListPO(String car, String loadingDate,
				String transListId, String carId, String origin,
				String arrival, String counterId, String supervision,
				String[] shippingId, String price, String state) {
			super();
			this.car = car;
			LoadingDate = loadingDate;
			this.transListId = transListId;
			this.carId = carId;
			this.origin = origin;
			this.arrival = arrival;
			this.counterId = counterId;
			Supervision = supervision;
			this.shippingId = shippingId;
			this.price = price;
			this.state = State.getInstance(state);
		}
		public String getCar() {
			return car;
		}
		public String getLoadingDate() {
			return LoadingDate;
		}
		public String getTransListId() {
			return transListId;
		}
		public String getCarId() {
			return carId;
		}
		public String getOrigin() {
			return origin;
		}
		public String getArrival() {
			return arrival;
		}
		public String getCounterId() {
			return counterId;
		}
		public String getSupervision() {
			return Supervision;
		}
		public String[] getShippingId() {
			return shippingId;
		}
		public String getPrice() {
			return price;
		}
		public State getState() {
			return state;
		}
				
}