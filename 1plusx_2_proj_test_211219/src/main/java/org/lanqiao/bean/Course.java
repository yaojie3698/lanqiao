package org.lanqiao.bean;

/**
 * 课程类
 */
public class Course {
	private String name;//课程名称
	private String teacher;//授课老师
	private String difficulty;//课程难度：高、中、低

	public Course() {

	}

	public Course(String name, String teacher, String difficulty) {
		this.name = name;
		this.teacher = teacher;
		this.difficulty = difficulty;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getDifficulty() {
		return difficulty;
	}

	//请修改该方法，并且在赋值时，课程难度只能为：高、中、低这三种之一，其余值不做任何处理。
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
}
