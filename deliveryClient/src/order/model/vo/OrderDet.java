package order.model.vo;

public class OrderDet {
	
	private int ordDetNo;
	private int ordDetMenuNo;
	private int ordDetCnt;
	
	public OrderDet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public OrderDet(int ordDetNo, int ordDetMenuNo, int ordDetCnt) {
		super();
		this.ordDetNo = ordDetNo;
		this.ordDetMenuNo = ordDetMenuNo;
		this.ordDetCnt = ordDetCnt;
	}
	
	public int getOrdDetNo() {
		return ordDetNo;
	}
	public void setOrdDetNo(int ordDetNo) {
		this.ordDetNo = ordDetNo;
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
	

}
