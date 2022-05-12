package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Course;
import static org.junit.Assert.assertEquals;

/**
 * Course的测试类
 */
public class CourseTest {
	@Test
	public void testCourse() throws Exception{
		Course g = new Course("体育", "周伯通", "中");
		assertEquals("体育", g.getName());
		g.setDifficulty("难");
		assertEquals("中", g.getDifficulty());
	}
}
