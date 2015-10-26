package po;

public class ReceiveListPO {
//ÊÕ¼þµ¥
	private String date;
	private String location;
	LogisticsPO logistics;
	public ReceiveListPO(String date, String location, LogisticsPO logistics) {
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
	public LogisticsPO getLogistics() {
		return logistics;
	}
	public void setLogistics(LogisticsPO logistics) {
		this.logistics = logistics;
	}

}
