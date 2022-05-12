package org.lanqiao.test;

import org.lanqiao.bean.Member;
import org.lanqiao.dao.MemberDao;
import org.lanqiao.daoimpl.MemberDaoImpl;
import org.lanqiao.db.ObjectUtil;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.junit.Test;

public class MemberDaoTest {
	MemberDao dao = new MemberDaoImpl();

	@Test
	public void testUpdatePwd() throws Exception {
		dao.updatePwd();
		Member m1 = dao.queryMember("zs");
		assertEquals(m1.getPwd(), "321");
		Member m2 = dao.queryMember("ls");
		assertEquals(m2.getPwd(), "654");
		Member m3 = dao.queryMember("ww");
		assertEquals(m3.getPwd(), "654321");

		Class c = Class.forName("org.lanqiao.bean.Member");
		Constructor c1 = c.getConstructor(String.class,String.class,Float.TYPE,Integer.TYPE);
		Member m = (Member)c1.newInstance("熊猫", "kof", 88, 0);

		dao.add(m);
		dao.updatePwd();
		assertEquals(dao.queryMember("熊猫").getPwd(), "fok");
		dao.deleteMember("熊猫");
	}

	@Test
	public void testUpdateRank()  throws Exception {
		dao.updateRank();
	
		Member m1 = dao.queryMember("zs");
		assertEquals(m1.getRank(), 1);
		Member m2 = dao.queryMember("ls");
		assertEquals(m2.getRank(), 3);
		Member m3 = dao.queryMember("ww");
		assertEquals(m3.getRank(), 5);

		Class c = Class.forName("org.lanqiao.bean.Member");
		Constructor c1 = c.getConstructor(String.class,String.class,Float.TYPE,Integer.TYPE);
		Member m = (Member)c1.newInstance("熊猫", "kof", 430, 0);

		dao.add(m);
		dao.updateRank();
		Member m4 = dao.queryMember("熊猫");
		assertEquals(m4.getRank(), 4);
		dao.deleteMember("熊猫");
	}
}
