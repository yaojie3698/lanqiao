package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Student;

import static org.junit.Assert.assertEquals;
import java.lang.reflect.Constructor;

/**
 * Student的测试类
 */
public class StudentTest {
	@Test
	public void testStudent() throws Exception{
		Student m = new Student("ldh", "123", 25, 2, 10);
		assertEquals("ldh", m.getName());
		assertEquals("123", m.getPwd());
		assertEquals(25, m.getAge());
		assertEquals(2, m.getGrade());
		assertEquals(10, m.getRate());
	}
}
