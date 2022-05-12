package org.lanqiao.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;
import org.lanqiao.bean.Order;
import org.lanqiao.dao.OrderDao;
import org.lanqiao.daoimpl.OrderDaoImpl;

public class OrderDaoTest {
	OrderDao dao = new OrderDaoImpl();

	@Test
	public void testQueryNum() {
		assertEquals(dao.queryNum(), 4);
		dao.add(new Order(10,"熊猫", "中华", 2, 50));
		assertEquals(dao.queryNum(), 5);
		dao.deleteOrder(10);
	}

	@Test
	public void testQueryMax() {
		assertEquals(dao.queryMax(), "ls");
		dao.add(new Order(10,"熊猫", "中华", 2, 50));
		assertEquals(dao.queryMax(), "熊猫");
		dao.deleteOrder(10);
	}
}
