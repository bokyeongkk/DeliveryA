package order.model.vo;

public class OrderDetData {
	
	private int ordDetNo;
	private int ordDetOrdNo;
	private int ordDetMenuNo;
	private int ordDetCnt;
	private String menuName;
	
	public OrderDetData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDetData(int ordDetNo, int ordDetOrdNo, int ordDetMenuNo, int ordDetCnt, String menuName) {
		super();
		this.ordDetNo = ordDetNo;
		this.ordDetOrdNo = ordDetOrdNo;
		this.ordDetMenuNo = ordDetMenuNo;
		this.ordDetCnt = ordDetCnt;
		this.menuName = menuName;
	}
	
	public int getOrdDetNo() {
		return ordDetNo;
	}
	public void setOrdDetNo(int ordDetNo) {
		this.ordDetNo = ordDetNo;
	}
	public int getOrdDetOrdNo() {
		return ordDetOrdNo;
	}
	public void setOrdDetOrdNo(int ordDetOrdNo) {
		this.ordDetOrdNo = ordDetOrdNo;
	}
	public int getOrdDetMenuNo() {
		return ordDetMenuNo;
	}
	public void setOrdDetMenuNo(int ordDetMenuNo) {
		this.ordDetMenuNo = ordDetMenuNo;
	}
	public int getOrdDetCnt() {
		return ordDetCnt;
	}
	public void setOrdDetCnt(int ordDetCnt) {
		this.ordDetCnt = ordDetCnt;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	
}
