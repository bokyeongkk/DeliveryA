package store.model.vo;

import java.util.ArrayList;

public class StoreReviewData {
	private ArrayList<Review> listRev;
	private int cntRev;
	private int avgRev;
	
	public StoreReviewData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public StoreReviewData(ArrayList<Review> listRev, int cntRev, int avgRev) {
		super();
		this.listRev = listRev;
		this.cntRev = cntRev;
		this.avgRev = avgRev;
	}

	
	public ArrayList<Review> getListRev() {
		return listRev;
	}
	public void setListRev(ArrayList<Review> listRev) {
		this.listRev = listRev;
	}
	public int getCntRev() {
		return cntRev;
	}
	public void setCntRev(int cntRev) {
		this.cntRev = cntRev;
	}
	public int getAvgRev() {
		return avgRev;
	}
	public void setAvgRev(int avgRev) {
		this.avgRev = avgRev;
	}

}
