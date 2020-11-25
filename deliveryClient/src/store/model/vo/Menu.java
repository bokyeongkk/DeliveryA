package store.model.vo;

public class Menu {
	
	private int menuNo;
	private int menuPrice;
	private int menuStoreNo;
	private String menuDet;
	private String menuName;
	private String menuFilepath;
	private String menuFilname;
	
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Menu(int menuNo, int menuPrice, int menuStoreNo, String menuDet, String menuName, String menuFilepath,
			String menuFilname) {
		super();
		this.menuNo = menuNo;
		this.menuPrice = menuPrice;
		this.menuStoreNo = menuStoreNo;
		this.menuDet = menuDet;
		this.menuName = menuName;
		this.menuFilepath = menuFilepath;
		this.menuFilname = menuFilname;
	}
	
	
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}
	public int getMenuStoreNo() {
		return menuStoreNo;
	}
	public void setMenuStoreNo(int menuStoreNo) {
		this.menuStoreNo = menuStoreNo;
	}
	public String getMenuDet() {
		return menuDet;
	}
	public void setMenuDet(String menuDet) {
		this.menuDet = menuDet;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuFilepath() {
		return menuFilepath;
	}
	public void setMenuFilepath(String menuFilepath) {
		this.menuFilepath = menuFilepath;
	}
	public String getMenuFilname() {
		return menuFilname;
	}
	public void setMenuFilname(String menuFilname) {
		this.menuFilname = menuFilname;
	}
	
}
