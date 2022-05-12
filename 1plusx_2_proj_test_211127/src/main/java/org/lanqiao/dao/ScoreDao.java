package org.lanqiao.dao;

import java.util.Set;

import org.lanqiao.bean.Score;

public interface ScoreDao {
	/**
	 * 查询至少考了2门课程的学生姓名
	 * @return 返回所有满足条件的学生姓名的集合
	 */
	public Set<String> queryName();

	 /**
	 * 查询平均成绩最高的学生姓名
	 * @return 返回学生姓名
	 */
	public String queryAvgMax();

	/**
	 * 插入成绩
	 * @param score 成绩对象
	 * @return
	 */
	public int add(Score score);

	/**
	 * 依据学生姓名和课程名称来删除成绩
	 * @param sname 学生姓名
	 * @param cname 课程名称
	 * @return 存在则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteScore(String sname,String cname);
}