package org.lanqiao.bean;

/**
 * 订单类
 */
public class Order {
	private int id;//订单号
	private String mname;//会员姓名
	private String gname;//商品名称
	private int num;//商品数量
	private float price;//商品单价

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMname() {
		return mname;
	}

	public void setMname(String mname) {
		this.mname = mname;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Order() {

	}

	public Order(int id, String mname, String gname, int num, float price) {
		this.id = id;
		this.mname = mname;
		this.gname = gname;
		this.num = num;
		this.price = price;
	}
}