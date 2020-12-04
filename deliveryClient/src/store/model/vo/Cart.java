package store.model.vo;

import java.io.Serializable;

//직렬화
public class Cart implements Serializable{
	
	private int menuNo;
	private String menuName;
	private int menuCount;
	private int menuPrice;
	private int countPrice;
	private int storeNo;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Cart(int menuNo, String menuName, int menuCount, int menuPrice, int countPrice, int storeNo) {
		super();
		this.menuNo = menuNo;
		this.menuName = menuName;
		this.menuCount = menuCount;
		this.menuPrice = menuPrice;
		this.countPrice = countPrice;
		this.storeNo = storeNo;
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


	public int getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	
	//리턴 값 변경!!!!!!
	public int getCountPrice() {
		return menuPrice*menuCount;
	}
	

	public void setCountPrice(int countPrice) {
		this.countPrice = countPrice;
	}





}
