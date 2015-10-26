package vo;
/**
 * 营业厅到达单
 * @author 颜
 *
 */
public class OfficeArrivalListVO {

	private String date;
	private String transportListId;
	private String origin;
	private String state;
	public OfficeArrivalListVO(String date, String transportListId,
			String origin, String state) {
		super();
		this.date = date;
		this.transportListId = transportListId;
		this.origin = origin;
		this.state = state;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransportListId() {
		return transportListId;
	}
	public void setTransportListId(String transportListId) {
		this.transportListId = transportListId;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

}
