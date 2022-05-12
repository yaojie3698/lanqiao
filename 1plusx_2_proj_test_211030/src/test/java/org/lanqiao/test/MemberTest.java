package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Member;
import static org.junit.Assert.assertEquals;
import java.lang.reflect.Constructor;

/**
 * Member的测试类
 */
public class MemberTest {
	@Test
	public void testMember() throws Exception{
		Class c = Class.forName("org.lanqiao.bean.Member");
		Constructor c1 = c.getConstructor();
		Constructor c2 = c.getConstructor(String.class,String.class,Float.TYPE,Integer.TYPE);

		Member m = (Member)c2.newInstance("zs", "123", 250, 2);
		assertEquals("zs", m.getName());
		assertEquals("123", m.getPwd());
		assertEquals(2, m.getRank());
	}
}
