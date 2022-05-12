package org.lanqiao.bean;

/**
 * 商品类
 */
public class Goods {
	private String name;//商品名称
	private float price;//商品价格
	private int num;//商品数量

	public Goods() {

	}

	public Goods(String name, float price, int num) {
		this.name = name;
		this.price = price;
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	//请修改该方法，并且在赋值时，商品数量不能超过100
	public void setNum(int num) {
		if (num <= 100) {
			this.num = num;	
		}
	}
}
