package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Course;
import org.lanqiao.dao.CourseDao;
import org.lanqiao.daoimpl.CourseDaoImpl;

import static org.junit.Assert.*;

public class CourseDaoTest {
	CourseDao dao = new CourseDaoImpl();

	@Test
	public void testUpdateDifficultyByName() {
		dao.updateDifficultyByName("英语", "高");
		Course c = dao.queryCourse("英语");
		assertEquals(c.getDifficulty(), "高");
		dao.updateDifficultyByName("英语", "中");
	}

	@Test
	public void testQueryCourse() {
		Course c = dao.queryCourse("英语");
		assertEquals(c.getTeacher(), "洪七公");
		assertEquals(c.getDifficulty(), "中");
	}
}
