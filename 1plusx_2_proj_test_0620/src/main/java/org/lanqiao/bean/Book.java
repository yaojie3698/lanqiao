package org.lanqiao.bean;

/**
 * 书籍类
 */
public class Book {
	private String name;//书名
	private String author;//作者
	private int price;//价钱
	private int num;//数量

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Book() {
	}

	public Book(String name, String author, int price, int num) {
		this.name = name;
		this.author = author;
		this.price = price;
		this.num = num;
	}

	@Override
	public String toString() {
		return "Book [author=" + author + ", name=" + name + ", num=" + num + ", price=" + price + "]";
	}
}
