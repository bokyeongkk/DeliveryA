package store.model.vo;

public class Cart {
	
	private String menuName;
	private int menuCount;
	private int menuPrice;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Cart(String menuName, int menuCount, int menuPrice) {
		super();
		this.menuName = menuName;
		this.menuCount = menuCount;
		this.menuPrice = menuPrice;
	}

	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getMenuCount() {
		return menuCount;
	}
	public void setMenuCount(int menuCount) {
		this.menuCount = menuCount;
	}
	public int getMenuPrice() {
		return menuPrice;
	}
	public void setMenuPrice(int menuPrice) {
		this.menuPrice = menuPrice;
	}

}
