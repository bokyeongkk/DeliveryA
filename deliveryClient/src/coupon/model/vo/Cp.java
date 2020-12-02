package coupon.model.vo;

public class Cp {
	private int cpNo;
	private String cpValidT;
	private String cpName;
	private int cpPrice;
	private int cpCate;
	private int cpStoreId;
	public Cp() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Cp(int cpNo, String cpValidT, String cpName, int cpPrice, int cpCate, int cpStoreId) {
		super();
		this.cpNo = cpNo;
		this.cpValidT = cpValidT;
		this.cpName = cpName;
		this.cpPrice = cpPrice;
		this.cpCate = cpCate;
		this.cpStoreId = cpStoreId;
	}
	public int getCpNo() {
		return cpNo;
	}
	public void setCpNo(int cpNo) {
		this.cpNo = cpNo;
	}
	public String getCpValidT() {
		return cpValidT;
	}
	public void setCpValidT(String cpValidT) {
		this.cpValidT = cpValidT;
	}
	public String getCpName() {
		return cpName;
	}
	public void setCpName(String cpName) {
		this.cpName = cpName;
	}
	public int getCpPrice() {
		return cpPrice;
	}
	public void setCpPrice(int cpPrice) {
		this.cpPrice = cpPrice;
	}
	public int getCpCate() {
		return cpCate;
	}
	public void setCpCate(int cpCate) {
		this.cpCate = cpCate;
	}
	public int getCpStoreId() {
		return cpStoreId;
	}
	public void setCpStoreId(int cpStoreId) {
		this.cpStoreId = cpStoreId;
	}
	
	
}
