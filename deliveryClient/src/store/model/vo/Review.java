package store.model.vo;

public class Review {
	
	private int revNo;
	private int revOrdNo;
	private int revScore;
	private String revContent;
	private String revCliId;
	private int revStore;
	private String revEnrollDate;
	//private String MenuName;
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Review(int revNo, int revOrdNo, int revScore, String revContent, String revCliId, int revStore,
			String revEnrollDate) {
		super();
		this.revNo = revNo;
		this.revOrdNo = revOrdNo;
		this.revScore = revScore;
		this.revContent = revContent;
		this.revCliId = revCliId;
		this.revStore = revStore;
		this.revEnrollDate = revEnrollDate;
	}

	public int getRevNo() {
		return revNo;
	}
	public void setRevNo(int revNo) {
		this.revNo = revNo;
	}
	public int getRevOrdNo() {
		return revOrdNo;
	}
	public void setRevOrdNo(int revOrdNo) {
		this.revOrdNo = revOrdNo;
	}
	public int getRevScore() {
		return revScore;
	}
	public void setRevScore(int revScore) {
		this.revScore = revScore;
	}
	public String getRevContent() {
		return revContent;
	}
	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}
	
	
	//br getter 추가
	public String getRevContentBr() {
		return revContent.replace("\r\n", "<br>");
	}

	
	public String getRevCliId() {
		return revCliId;
	}
	public void setRevCliId(String revCliId) {
		this.revCliId = revCliId;
	}
	public int getRevStore() {
		return revStore;
	}
	public void setRevStore(int revStore) {
		this.revStore = revStore;
	}
	public String getRevEnrollDate() {
		return revEnrollDate;
	}
	public void setRevEnrollDate(String revEnrollDate) {
		this.revEnrollDate = revEnrollDate;
	}
	
}
