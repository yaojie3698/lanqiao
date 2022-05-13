package org.lanqiao.bean;

/**
 * 学生类
 */
public class Student {
	private String name;//学生姓名
	private String pwd;//学生密码
	private int age;//学生年龄
	private int grade;//学生年级
	private int rate;//学生综合评级

	//补充完成该类的含参构造方法
	public Student(String name, String pwd, int age, int grade, int rate) {
		
	}

	public Student(){

	}

	public String getName() {
		return name;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
}
