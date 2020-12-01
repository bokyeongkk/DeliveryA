package client.model.vo;

public class Client {
	private String cliId;
	private String cliPw;
	private String cliName;
	private String cliNickname;
	private String cliTel;
	private String cliEmail;
	private String cliAddr;
	private String cliGender;
	private String cliBirth;
	private String cliEnrollDate;
	private String cliAddrDet;

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Client(String cliId, String cliPw, String cliName, String cliNickname, String cliTel, String cliEmail,
			String cliAddr, String cliGender, String cliBirth, String cliEnrollDate, String cliAddrDet) {
		super();
		this.cliId = cliId;
		this.cliPw = cliPw;
		this.cliName = cliName;
		this.cliNickname = cliNickname;
		this.cliTel = cliTel;
		this.cliEmail = cliEmail;
		this.cliAddr = cliAddr;
		this.cliGender = cliGender;
		this.cliBirth = cliBirth;
		this.cliEnrollDate = cliEnrollDate;
		this.cliAddrDet = cliAddrDet;
	}
	public String getCliId() {
		return cliId;
	}
	public void setCliId(String cliId) {
		this.cliId = cliId;
	}
	public String getCliPw() {
		return cliPw;
	}
	public void setCliPw(String cliPw) {
		this.cliPw = cliPw;
	}
	public String getCliName() {
		return cliName;
	}
	public void setCliName(String cliName) {
		this.cliName = cliName;
	}
	public String getCliNickname() {
		return cliNickname;
	}
	public void setCliNickname(String cliNickname) {
		this.cliNickname = cliNickname;
	}
	public String getCliTel() {
		return cliTel;
	}
	public void setCliTel(String cliTel) {
		this.cliTel = cliTel;
	}
	public String getCliEmail() {
		return cliEmail;
	}
	public void setCliEmail(String cliEmail) {
		this.cliEmail = cliEmail;
	}
	public String getCliAddr() {
		return cliAddr;
	}
	public void setCliAddr(String cliAddr) {
		this.cliAddr = cliAddr;
	}
	public String getCliGender() {
		return cliGender;
	}
	public void setCliGender(String cliGender) {
		this.cliGender = cliGender;
	}
	public String getCliBirth() {
		return cliBirth;
	}
	public void setCliBirth(String cliBirth) {
		this.cliBirth = cliBirth;
	}
	public String getCliEnrollDate() {
		return cliEnrollDate;
	}
	public void setCliEnrollDate(String cliEnrollDate) {
		this.cliEnrollDate = cliEnrollDate;
	}
	public String getCliAddrDet() {
		return cliAddrDet;
	}
	public void setCliAddrDet(String cliAddrDet) {
		this.cliAddrDet = cliAddrDet;
	}
	
}
