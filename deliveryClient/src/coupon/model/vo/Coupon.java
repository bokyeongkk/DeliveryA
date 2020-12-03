package coupon.model.vo;
//cp_list_db
public class Coupon {
	private int cpListPk;
	private int cpListNo;
	private String cpListCliId;
	private String cpListDate;
	private String cpListAdminId;
	private String cpListUse;
	private String cpName;
	private int cpPrice;
	
	public Coupon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Coupon(int cpListPk, int cpListNo, String cpListCliId, String cpListDate, String cpListAdminId,
			String cpListUse, String cpName, int cpPrice) {
		super();
		this.cpListPk = cpListPk;
		this.cpListNo = cpListNo;
		this.cpListCliId = cpListCliId;
		this.cpListDate = cpListDate;
		this.cpListAdminId = cpListAdminId;
		this.cpListUse = cpListUse;
		this.cpName = cpName;
		this.cpPrice = cpPrice;
	}

	public int getCpListPk() {
		return cpListPk;
	}

	public void setCpListPk(int cpListPk) {
		this.cpListPk = cpListPk;
	}

	public int getCpListNo() {
		return cpListNo;
	}

	public void setCpListNo(int cpListNo) {
		this.cpListNo = cpListNo;
	}

	public String getCpListCliId() {
		return cpListCliId;
	}

	public void setCpListCliId(String cpListCliId) {
		this.cpListCliId = cpListCliId;
	}

	public String getCpListDate() {
		return cpListDate;
	}

	public void setCpListDate(String cpListDate) {
		this.cpListDate = cpListDate;
	}

	public String getCpListAdminId() {
		return cpListAdminId;
	}

	public void setCpListAdminId(String cpListAdminId) {
		this.cpListAdminId = cpListAdminId;
	}

	public String getCpListUse() {
		return cpListUse;
	}

	public void setCpListUse(String cpListUse) {
		this.cpListUse = cpListUse;
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
	
	
}
