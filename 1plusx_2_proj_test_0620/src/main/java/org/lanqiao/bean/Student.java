package org.lanqiao.bean;

/**
 * 学生类
 */
public class Student {
	private String name;//学生姓名
	private String pwd;//学生密码

	//已经提供Student类的属性，补充完成该类的有参（两个参数）及无参构造方法

	
	

	
	public String getName() {
		return name;
	}

	public Student() {
    }

    public Student(String name, String pwd) {
		this.name = name;
		this.pwd = pwd;
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
}