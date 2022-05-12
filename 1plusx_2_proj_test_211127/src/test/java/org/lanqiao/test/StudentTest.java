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
		Class c = Class.forName("org.lanqiao.bean.Student");
		Constructor c1 = c.getConstructor();
		Constructor c2 = c.getConstructor(String.class,String.class,Integer.TYPE,Integer.TYPE,Integer.TYPE);

		Student m = (Student)c2.newInstance("ldh", "123", 25, 2, 0);
		assertEquals("ldh", m.getName());
		assertEquals("123", m.getPwd());
		assertEquals(25, m.getAge());
		assertEquals(2, m.getGrade());
		assertEquals(0, m.getRate());
	}
}
