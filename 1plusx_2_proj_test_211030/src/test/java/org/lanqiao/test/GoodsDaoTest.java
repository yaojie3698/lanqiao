package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Goods;
import org.lanqiao.dao.GoodsDao;
import org.lanqiao.daoimpl.GoodsDaoImpl;

import static org.junit.Assert.*;

public class GoodsDaoTest {
	GoodsDao dao = new GoodsDaoImpl();

	@Test
	public void testQueryExpensiveGoods() {
		assertEquals(dao.queryExpensiveGoods(), "中华");
		dao.add(new Goods("熊猫", 88, 10));
		assertEquals(dao.queryExpensiveGoods(), "熊猫");
		dao.deleteGoods("熊猫");
	}

	@Test
	public void testQuerySum() {
		assertEquals(dao.querySum(), 1077.0, 0.1);
		dao.add(new Goods("玫瑰", 8.81f, 1));
		assertEquals(dao.querySum(), 1085.81, 0.1);
		dao.deleteGoods("玫瑰");
	}
}
