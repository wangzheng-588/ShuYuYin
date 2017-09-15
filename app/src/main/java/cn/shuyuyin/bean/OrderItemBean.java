package cn.shuyuyin.bean;

import java.util.ArrayList;

public class OrderItemBean {

	//这个是订单列表的一个条目bean
	private String time;
	private int orderState;
	private long totalPrice;
	private ArrayList<Goods> goodslist;
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getOrderState() {
		return orderState;
	}
	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public ArrayList<Goods> getList() {
		return goodslist;
	}
	public void setList(ArrayList<Goods> list) {
		this.goodslist = list;
	}
	
}
