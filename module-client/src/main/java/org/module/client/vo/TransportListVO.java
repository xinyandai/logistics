package org.module.client.vo;

import org.module.common.po.State;

/**
 * 业务员每天根据库存的状况，录入中转单（包括飞机、铁路、公路）。
 * 中转单前缀为：
 * 装车日期、
 * 本中转中心中转单编号（中转中心编号+日期+0000000七位数字），
 * 航班号、
 * 出发地、
 * 到达地、
 * 货柜号、
 * 监装员、
 * 本次装箱所有托运单号、
 * 运费（运费根据出发地和目的地自动生成）
 * @author 
 *
 */
public class TransportListVO {

	/**
	 * 运送方式
	 */
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
		
		
		public TransportListVO(String car, String loadingDate, String transId,
				String carId, String origin, String arrival, String counterId,
				String supervision, String[] shippingId, String price,String state) {
			super();
			this.car = car;
			LoadingDate = loadingDate;
			this.transListId = transId;
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
		public void setCar(String car) {
			this.car = car;
		}
		public String getLoadingDate() {
			return LoadingDate;
		}
		public void setLoadingDate(String loadingDate) {
			LoadingDate = loadingDate;
		}
		public String getTransId() {
			return transListId;
		}
		public void setTransId(String transId) {
			this.transListId = transId;
		}
		public String getCarId() {
			return carId;
		}
		public void setCarId(String carId) {
			this.carId = carId;
		}
		public String getOrigin() {
			return origin;
		}
		public void setOrigin(String origin) {
			this.origin = origin;
		}
		public String getArrival() {
			return arrival;
		}
		public void setArrival(String arrival) {
			this.arrival = arrival;
		}
		public String getCounterId() {
			return counterId;
		}
		public void setCounterId(String counterId) {
			this.counterId = counterId;
		}
		public String getSupervision() {
			return Supervision;
		}
		public void setSupervision(String supervision) {
			Supervision = supervision;
		}
		public String[] getShippingId() {
			return shippingId;
		}
		public void setShippingId(String[] shippingId) {
			this.shippingId = shippingId;
		}
		public String getPrice() {
			return price;
		}
		public void setPrice(String price) {
			this.price = price;
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
		
}
