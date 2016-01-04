
package org.module.common.po;

import java.io.Serializable;

public class TransportListPO extends AbstractPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -163943237704529384L;
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
		
		private String writer;
		
		public TransportListPO(String car, String loadingDate,
				String transListId, String carId, String origin,
				String arrival, String counterId, String supervision,
				String[] shippingId, String price, State state,String w) {
			super();
			this.car = car;
			this.LoadingDate = loadingDate;
			this.transListId = transListId;
			this.carId = carId;
			this.origin = origin;
			this.arrival = arrival;
			this.counterId = counterId;
			this.Supervision = supervision;
			this.shippingId = shippingId;
			this.price = price;
			this.state = state;
			this.writer = w;
		}
		
		public TransportListPO(String string) {
			String[] s = string.split(spt);
			this.car = s[0];
			this.LoadingDate = s[1];
			this.transListId = s[2];
			this.carId = s[3];
			this.origin = s[4];
			this.arrival = s[5];
			this.counterId = s[6];
			this.Supervision = s[7];
			this.shippingId = s[8].split(inlinespt);
			this.price = s[9];
			this.state = State.getInstance(s[10]);
			this.writer = s[11];
		}

		@Override
		public String toString(){
			return this.car  + this.spt +
			this.LoadingDate  + this.spt +
			this.transListId  + this.spt +
			this.carId  + this.spt +
			this.origin  + this.spt +
			this.arrival  + this.spt +
			this.counterId  + this.spt +
			this.Supervision  + this.spt +
			this.getArrayToString(this.shippingId) + this.spt + 
			this.price + this.spt +
			this.state.toString()
			+this.spt + this.writer;
		}
		/**
		 * 把订单号数组转化为字符串
		 * @param s
		 * @return
		 */
		private String getArrayToString(String[] s){
			String re = "";
			for (String string : s) {
				re += string + this.inlinespt;
			}
			return re;
		}
		final private String spt = ":%:%:";
		final private String inlinespt = "&&&&&&&";
		@Override
		public String getBelongsToPersonOrDepartment() {
			// TODO Auto-generated method stub
			return this.writer;
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
		public String getWriter() {
			return this.writer;
		}

		@Override
		public String getNniqueID() {
			// TODO Auto-generated method stub
			return this.transListId;
		}		
}