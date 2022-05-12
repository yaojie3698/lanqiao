package org.lanqiao.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.lanqiao.bean.Student;
import org.lanqiao.bean.SB;
import org.lanqiao.bean.Book;
import org.lanqiao.dao.SBDao;
import org.lanqiao.daoimpl.SBDaoImpl;
import org.lanqiao.db.ObjectUtil;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class SBDaoTest {
	SBDao dao = new SBDaoImpl();
	Random random = new Random(Instant.now().getEpochSecond());

	@After
	public void clear(){
		new ObjectUtil<Book>().delete("delete from book where name not in ('三国演义','射雕英雄传','水浒传','红楼梦','西游记')");
	}
	@Test
	public void testFindByName() {
		String s1 = ranString();
		String s2 = ranString();
		int n1 = random.nextInt(100) + 1;
		int n2 = random.nextInt(100) + 1;
		dao.add(new Book(s1, s2, n1, n2));
		Book book = dao.findByName(s1);
		assertNotNull(book);
		assertEquals(s2, book.getAuthor());
	}

	private String ranString() {
		String s1 = "";
		for (int i = 0; i < 5; i++) {
			s1 += (char) ('a' + random.nextInt(26));
		}
		return s1;
	}

	@Test
	public void testQueryExpensiveBook() {
		IntStream limit = random.ints(1000, 5000).limit(4);
		int arr[]=limit.toArray();
		Book[] books = new Book[4];
		books[0]=new Book(ranString(), ranString(), arr[0], 10);
		books[1] = new Book(ranString(), ranString(), arr[1], 10);
		books[2] = new Book(ranString(), ranString(), arr[2], 10);
		books[3] = new Book(ranString(), ranString(), arr[3], 10);
		dao.add(books[0]);
		dao.add(books[1]);
		dao.add(books[2]);
		dao.add(books[3]);
		Book mmax = Arrays.stream(books).max((x,y)->{return x.getPrice()-y.getPrice();}).get();
		assertEquals(dao.queryExpensiveBook(), mmax.getName());
	}

	@Test
	public void testDeleteStudent() {
		String name = ranString();
		String pwd = ranString();

		new ObjectUtil<Student>().add("insert into student values(?,?)", name, pwd);
		assertTrue(dao.deleteStudent(name));
	}

	@Test
	public void testChangePwd() {
		dao.changePwd("ls", "123", "333");
		Student s1 = new ObjectUtil<>().getOne("select * from student where name='ls'", Student.class);
		assertNotEquals(s1.getPwd(), "333");
		String newPwd = ranString();
		Student s2 = new ObjectUtil<>().getOne("select * from student where name='ww'", Student.class);
		dao.changePwd("ww", s2.getPwd(), newPwd);
		s2 = new ObjectUtil<>().getOne("select * from student where name='ww'", Student.class);
		assertEquals(s2.getPwd(), newPwd);
	}

	@Test
	public void testBorrow() {
		new ObjectUtil<>().clean("sb"); // 先清空sb表
		SB sb = new SB(0, "zs", "三国演义", new Date(), null);// 预借的书籍
		Book b1 = dao.findByName(sb.getBname());
		int num1 = b1.getNum();// 借之前的数量
		boolean f = dao.borrow(sb);// 借书
		assertTrue(f);// 借书是否成功
		Book b2 = dao.findByName(sb.getBname());
		int num2 = b2.getNum();// 借之后的数量
		assertEquals(num1 - 1, num2);
	}

	@Test
	public void testGiveBack() {
		new ObjectUtil<>().clean("sb"); // 先清空sb表
		SB sb = new SB(0, "zs", "三国演义", new Date(), null);
		dao.borrow(sb);// 先借书
		Book b1 = dao.findByName(sb.getBname());
		int num1 = b1.getNum();// 借书之后的数量
		boolean f = dao.giveBack(sb);// 再还书
		assertTrue(f);// 还书是否成功
		Book b2 = dao.findByName(sb.getBname());
		int num2 = b2.getNum();// 还书之后的数量
		assertEquals(num1 + 1, num2);
	}
}
