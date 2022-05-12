package org.lanqiao.daoimpl;

import java.util.List;

import org.lanqiao.bean.Goods;
import org.lanqiao.dao.GoodsDao;
import org.lanqiao.db.ObjectUtil;

/**
 * 接口实现类
 */
public class GoodsDaoImpl implements GoodsDao{
        /*
         * ObjectUtil工具类提供的方法能实现对数据库的CRUD操作
         * */
        ObjectUtil<Goods> goodsUtil = new ObjectUtil<Goods>();

        /**
	 * 查询所有商品中价钱最贵的商品名称
	 * @return 返回商品名称
	 */
	public String queryExpensiveGoods() {
                // 请补全sql语句
                String sql = "select name from goods where price = (select max(price) from goods)";
                Goods g = goodsUtil.getOne(sql, Goods.class);
                return g.getName();
        }

         /**
	 * 查询所有商品的总价值金额
	 * @return 返回所有商品的总价值金额
	 */
	public double querySum() {
                String sql = "select * from goods";
                double sum = 0;
                List<Goods> list = goodsUtil.getList(sql, Goods.class);
                for (Goods goods : list) {
                        // 请补全代码
                       sum += goods.getNum()*goods.getPrice();
                }
                return sum;
        }

        /**
	 * 插入商品
	 * @param goods 商品对象
	 * @return
	 */
	public int add(Goods goods) {
                String sql = "insert into goods values(?,?,?)";
                return goodsUtil.add(sql, goods.getName(),goods.getPrice(),goods.getNum());
        }

        /**
	 * 依据商品名称来删除商品
	 * @param name 商品名称
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteGoods(String name) {
                // 请补全sql语句
                String sql = "delete from goods where name=?";
                int a = goodsUtil.delete(sql, name);
                if(a>0){
                          return true;
                }else{
                          return false;  
                }
        }
}