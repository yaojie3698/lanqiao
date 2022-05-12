package org.lanqiao.daoimpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lanqiao.bean.Order;
import org.lanqiao.dao.OrderDao;
import org.lanqiao.db.ObjectUtil;

/**
 * 接口实现类
 */
public class OrderDaoImpl implements OrderDao{
        /*
         * ObjectUtil工具类提供的方法能实现对数据库的CRUD操作
         * */
        ObjectUtil<Order> orderUtil = new ObjectUtil<Order>();

        /**
	 * 查询一共有多少笔订单
	 * @return 返回订单数量
	 */
	public int queryNum() {
                String sql = "select * from `order`;";
                List<Order> o = orderUtil.getList(sql, Order.class); 
                Set<Integer> s = new HashSet<Integer>();
                for (Order order : o) {
                        // 请补全语句
                        s.add(order.getId());
                }
                return s.size();
        }

         /**
	 * 查询消费金额最多的人
	 * @return 返回会员名称
	 */
	public String queryMax() {
                // 请补全sql语句
                String sql = "SELECT `mname` from (SELECT `mname`,sum(`num`*`price`) as aa  from `order` GROUP BY `mname` ) tab1 where aa = (SELECT max(aa) from (SELECT sum(`num`*`price`) as aa  from `order` GROUP BY `mname`) tab1)";
                // String sql = "select mname from (select mname,sum(num*price) as aa from order group by mname ) tab1 where aa = (select max(aa) from (select sum(num*price) as aa from order group by mname ) tab1 )";
                Order o = orderUtil.getOne(sql, Order.class); 
                return o.getMname();
        }

	/**
	 * 插入订单
	 * @param order 订单对象
	 * @return
	 */
	public int add(Order order) {
                String sql = "insert into `order` values(?,?,?,?,?)";
                return orderUtil.add(sql, order.getId(), order.getMname(), order.getGname(), order.getNum(), order.getPrice());
        }

	/**
	 * 依据订单号来删除订单
	 * @param id 订单号
	 * @return 存在订单号则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteOrder(int id) {
                // 请补全sql语句
                String sql = "delete from `order` where id=?";
                int a = orderUtil.delete(sql, id);
                if(a>0){
                          return true;
                }else{
                          return false;  
                }
        }
}