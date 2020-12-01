package store.model.vo;

import java.io.Serializable;

//직렬화
public class Cart implements Serializable{
	
	private int menuNo;
	private String menuName;
	private int menuCount;
	private int menuPrice;
	private int countPrice;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int menuNo, String menuName, int menuCount, int menuPrice, int countPrice) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuCount = menuCount;
		this.menuPrice = menuPrice;
		this.countPrice = countPrice;
	}



	public int getMenuNo() {
		return menuNo;
	}

	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
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


	public int getCountPrice() {
		return menuPrice*menuCount;
	}


}
