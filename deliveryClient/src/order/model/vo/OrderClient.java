package order.model.vo;

import java.util.ArrayList;

import client.model.vo.Client;
import coupon.model.vo.Coupon;
import coupon.model.vo.Cp;

public class OrderClient {
	private Order order;
	private ArrayList<OrderDet> orderDet;
	private Client client;
	private ArrayList<Cp> cp;
	private ArrayList<Coupon> cpList;
	public OrderClient() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderClient(Order order, ArrayList<OrderDet> orderDet, Client client, ArrayList<Cp> cp,
			ArrayList<Coupon> cpList) {
		super();
		this.order = order;
		this.orderDet = orderDet;
		this.client = client;
		this.cp = cp;
		this.cpList = cpList;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public ArrayList<OrderDet> getOrderDet() {
		return orderDet;
	}
	public void setOrderDet(ArrayList<OrderDet> orderDet) {
		this.orderDet = orderDet;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public ArrayList<Cp> getCp() {
		return cp;
	}
	public void setCp(ArrayList<Cp> cp) {
		this.cp = cp;
	}
	public ArrayList<Coupon> getCpList() {
		return cpList;
	}
	public void setCpList(ArrayList<Coupon> cpList) {
		this.cpList = cpList;
	}
	
	
}
