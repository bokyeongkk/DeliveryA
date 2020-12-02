package store.model.vo;

import java.util.ArrayList;

import order.model.vo.OrderDetData;

public class ReviewData {
	private ArrayList<Review> listRev;
	private ArrayList<OrderDetData> listOrdDet;
	private int cntRev;
	private double avgRev;
	
	public ReviewData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewData(ArrayList<Review> listRev, ArrayList<OrderDetData> listOrdDet, int cntRev, double avgRev) {
		super();
		this.listRev = listRev;
		this.listOrdDet = listOrdDet;
		this.cntRev = cntRev;
		this.avgRev = avgRev;
	}

	public ArrayList<Review> getListRev() {
		return listRev;
	}

	public void setListRev(ArrayList<Review> listRev) {
		this.listRev = listRev;
	}

	public ArrayList<OrderDetData> getListOrdDet() {
		return listOrdDet;
	}

	public void setListOrdDet(ArrayList<OrderDetData> listOrdDet) {
		this.listOrdDet = listOrdDet;
	}

	public int getCntRev() {
		return cntRev;
	}

	public void setCntRev(int cntRev) {
		this.cntRev = cntRev;
	}

	public double getAvgRev() {
		return avgRev;
	}

	public void setAvgRev(double avgRev) {
		this.avgRev = avgRev;
	}

	
}
