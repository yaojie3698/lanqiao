package org.lanqiao.dao;

import org.lanqiao.bean.Student;

public interface StudentDao {
	 /**
	 * 查询最小年龄的学生姓名
	 * @return 返回学生姓名
	 */
	public String queryMinAge();

	/**
	 * 查询学生总人数
	 * @return 返回总人数
	 */
	public int queryNum();

	/**
	 * 插入学生
	 * @param s 学生对象
	 * @return
	 */
	public int add(Student s);

	/**
	 * 依据学生姓名来删除学生
	 * @param name 学生姓名
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteStudent(String name);
}