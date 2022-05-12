package org.lanqiao.dao;

import org.lanqiao.bean.Goods;

public interface GoodsDao {
	 /**
	 * 查询所有商品中价钱最贵的商品名称
	 * @return 返回商品名称
	 */
	public String queryExpensiveGoods();

	 /**
	 * 查询所有商品的总价值金额
	 * @return 返回所有商品的总价值金额
	 */
	public double querySum();

	/**
	 * 插入商品
	 * @param goods 商品对象
	 * @return
	 */
	public int add(Goods goods);

	/**
	 * 依据商品名称来删除商品
	 * @param name 商品名称
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteGoods(String name);
}