package org.lanqiao.bean;

/**
 * 会员类
 */
public class Member {
	private String name;//会员名称
	private String pwd;//会员密码
	private float score;//会员积分
	private int rank;//会员等级

	//已经提供Member类的属性，补充完成该类的有参（四个参数）及无参构造方法

	


	public String getName() {
		return name;
	}

	public Member() {
	}

	public Member(String name, String pwd, float score, int rank) {
		this.name = name;
		this.pwd = pwd;
		this.score = score;
		this.rank = rank;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
}
