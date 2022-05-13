package org.lanqiao.test;

import org.junit.Test;
import org.lanqiao.bean.Score;

import static org.junit.Assert.assertEquals;

/**
 * Score的测试类
 */
public class ScoreTest {
	@Test
	public void testScore() {
		Score m = new Score("hmm", "化学", 95);
		assertEquals("[sname:hmm;cname:化学;score:95]", m.toString());
	}
}
