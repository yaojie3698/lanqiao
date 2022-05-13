package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Score;
import org.lanqiao.dao.ScoreDao;
import org.lanqiao.daoimpl.ScoreDaoImpl;

import static org.junit.Assert.*;

import java.util.Set;

public class ScoreDaoTest {
	ScoreDao dao = new ScoreDaoImpl();

	@Test
	public void testQueryName() {
		Set<String> s = dao.queryName();
		assertEquals(s.toArray().length, 3);
		dao.add(new Score("zl","英语",85));
		Set<String> s1 = dao.queryName();
		assertEquals(s1.toArray().length, 4);
		dao.deleteScore("zl", "英语");
	}

	@Test
	public void testQueryAvgMax() {
		assertEquals(dao.queryAvgMax(), "zl");
		dao.deleteScore("zl", "C语言");
		assertEquals(dao.queryAvgMax(), "ww");
		dao.add(new Score("zl","C语言",80));
	}
}
