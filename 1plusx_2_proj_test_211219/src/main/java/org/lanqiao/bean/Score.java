package org.lanqiao.bean;

/**
 * 成绩类
 */
public class Score {
	private String sname;//学生姓名
	private String cname;//课程名称
	private int score;//成绩分数

	public Score(String sname, String cname, int score) {
		this.sname = sname;
		this.cname = cname;
		this.score = score;
	}

	public Score() {
		
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	//请修改该方法，以保证打印对象时输出格式如下：[sname:zs;cname:语文;score:80]
	@Override
	public String toString() {
		return "";
	}
}