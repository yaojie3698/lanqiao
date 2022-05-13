package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Student;
import org.lanqiao.dao.StudentDao;
import org.lanqiao.daoimpl.StudentDaoImpl;
import org.lanqiao.db.ObjectUtil;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

public class StudentDaoTest {
	StudentDao dao = new StudentDaoImpl();
	ObjectUtil<Student> studentUtil = new ObjectUtil<Student>();

	@Test
	public void testQueryMaxAge() throws Exception {
		assertEquals(dao.queryMaxAge(), "zl");

		Student s = new Student("熊猫", "123", 40, 1, 0);
		dao.add(s);
		assertEquals(dao.queryMaxAge(), "熊猫");
		dao.deleteStudent(s.getName());
	}

	@Test
	public void testQueryNum() throws Exception {
		assertEquals(dao.queryNum(), 3);

		Student s = new Student("熊猫", "123", 50, 1, 0);
		dao.add(s);
		assertEquals(dao.queryNum(), 4);
		dao.deleteStudent(s.getName());
	}

	@Test
	public void testAdd() throws Exception {
		Student s = new Student("熊猫", "123", 10, 1, 0);

		dao.add(s);
		Student s1 = studentUtil.getOne("select * from student where name=?", Student.class, s.getName());
		assertEquals(s1.getPwd(), s.getPwd());
		assertEquals(s1.getAge(), s.getAge());
		assertEquals(s1.getGrade(), s.getGrade());
		assertEquals(s1.getRate(), s.getRate());
		dao.deleteStudent(s.getName());
	}
}
