package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Student;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.lang.reflect.Constructor;

/**
 * Student的测试类
 */
public class StudentTest {
	@Test
	public void testStudent() throws Exception{
		Class c = Class.forName("org.lanqiao.bean.Student");
		Constructor c1 = c.getConstructor();
		Constructor c2 = c.getConstructor(String.class,String.class);

		Student stu = (Student)c2.newInstance("zs", "123");
		assertEquals("zs", stu.getName());
		assertEquals("123", stu.getPwd());
	}
}
