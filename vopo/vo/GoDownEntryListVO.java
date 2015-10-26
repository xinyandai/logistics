package vo;

public class GoDownEntryListVO {

	private String Courier;
	private String date;
	private String destination;
	private String qu;
	private String pai;
	private String jia;
	private String wei;
	public GoDownEntryListVO(String courier, String date, String destination,
			String qu, String pai, String jia, String wei) {
		super();
		Courier = courier;
		this.date = date;
		this.destination = destination;
		this.qu = qu;
		this.pai = pai;
		this.jia = jia;
		this.wei = wei;
	}
	public String getCourier() {
		return Courier;
	}
	public void setCourier(String courier) {
		Courier = courier;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getQu() {
		return qu;
	}
	public void setQu(String qu) {
		this.qu = qu;
	}
	public String getPai() {
		return pai;
	}
	public void setPai(String pai) {
		this.pai = pai;
	}
	public String getJia() {
		return jia;
	}
	public void setJia(String jia) {
		this.jia = jia;
	}
	public String getWei() {
		return wei;
	}
	public void setWei(String wei) {
		this.wei = wei;
	}

}
