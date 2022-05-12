package org.lanqiao.dao;

import org.lanqiao.bean.Order;

public interface OrderDao {
	/**
	 * 查询一共有多少笔订单
	 * @return 返回订单数量
	 */
	public int queryNum();

	 /**
	 * 查询消费金额最多的人
	 * @return 返回会员名称
	 */
	public String queryMax();

	/**
	 * 插入订单
	 * @param order 订单对象
	 * @return
	 */
	public int add(Order order);

	/**
	 * 依据订单号来删除订单
	 * @param id 订单号
	 * @return 存在订单号则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteOrder(int id);
}