package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Goods;
import static org.junit.Assert.assertEquals;

/**
 * Goods的测试类
 */
public class GoodsTest {
	@Test
	public void testStudent() throws Exception{
		Goods g = new Goods("辣条", 12.8f, 10);
		assertEquals("辣条", g.getName());
		g.setNum(101);
		assertEquals(10, g.getNum());
	}
}
