package org.lanqiao.dao;

import org.lanqiao.bean.Course;

public interface CourseDao {
	 /**
	 * 根据课程名称来更新课程难度
	 * @return 更新成功返回true，没有更新成功返回false
	 */
	public boolean updateDifficultyByName(String name,String difficulty);

	 /**
	 * 根据课程名称来查询课程
	 * @return 返回课程对象
	 */
	public Course queryCourse(String name);

	/**
	 * 插入课程
	 * @param c 课程对象
	 * @return
	 */
	public int add(Course c);

	/**
	 * 依据课程名称来删除课程
	 * @param name 课程名称
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteCourse(String name);
}