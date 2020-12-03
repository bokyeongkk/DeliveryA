package order.model.vo;

public class Order {
	private int ordNo;
	private int ordTPrice;
	private String ordCliId;
	private int ordStoreNo;
	private String ordAddr;
	private String ordSub;
	private int ordCpId;
	private String ordDate;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Order(int ordNo, int ordTPrice, String ordCliId, int ordStoreNo, String ordAddr, String ordSub, int ordCpId,
			String ordDate) {
		super();
		this.ordNo = ordNo;
		this.ordTPrice = ordTPrice;
		this.ordCliId = ordCliId;
		this.ordStoreNo = ordStoreNo;
		this.ordAddr = ordAddr;
		this.ordSub = ordSub;
		this.ordCpId = ordCpId;
		this.ordDate = ordDate;
	}
	
	public int getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(int ordNo) {
		this.ordNo = ordNo;
	}
	public int getOrdTPrice() {
		return ordTPrice;
	}
	public void setOrdTPrice(int ordTPrice) {
		this.ordTPrice = ordTPrice;
	}
	public String getOrdCliId() {
		return ordCliId;
	}
	public void setOrdCliId(String ordCliId) {
		this.ordCliId = ordCliId;
	}
	public int getOrdStoreNo() {
		return ordStoreNo;
	}
	public void setOrdStoreNo(int ordStoreNo) {
		this.ordStoreNo = ordStoreNo;
	}
	public String getOrdAddr() {
		return ordAddr;
	}
	public void setOrdAddr(String ordAddr) {
		this.ordAddr = ordAddr;
	}
	public String getOrdSub() {
		return ordSub;
	}
	public void setOrdSub(String ordSub) {
		this.ordSub = ordSub;
	}
	public int getOrdCpId() {
		return ordCpId;
	}
	public void setOrdCpId(int ordCpId) {
		this.ordCpId = ordCpId;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	
}
