package org.lanqiao.daoimpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.lanqiao.bean.Score;
import org.lanqiao.dao.ScoreDao;
import org.lanqiao.db.ObjectUtil;

/**
 * 接口实现类
 */
public class ScoreDaoImpl implements ScoreDao{
        /*
         * ObjectUtil工具类提供的方法能实现对数据库的CRUD操作
         * */
        ObjectUtil<Score> scoreUtil = new ObjectUtil<Score>();

        /**
	 * 查询至少考了2门课程的学生姓名
	 * @return 返回所有满足条件的学生姓名的集合
	 */
	public Set<String> queryName() {
                // 查询出满足条件的成绩集合
                String sql = "select * from score where sname in(select sname from score group by sname having count(*)>=2)";
                List<Score> li = scoreUtil.getList(sql, Score.class);
                Set<String> s = new HashSet<String>();
                // 把集合 li 中的每个成绩对象的名字取出来放进集合 s 中,并返回
                // 请补全以下代码
                for (int i = 0; i < li.size(); i++) {     
                        s.add(li.get(i).getSname());
                }
                return s;
        }


        /**
	 * 查询平均成绩最高的学生姓名
	 * @return 返回学生姓名
	 */
	public String queryAvgMax() {
                // 请补全sql语句
                String sql = "select sname from (select sname,avg(score) as aa from score group by sname)tab1 where aa = (select max(aa) from (select `sname`,avg(score) as aa from score group by sname)tab1)";
                Score s = scoreUtil.getOne(sql, Score.class);
                return s.getSname();
        }

        /**
	 * 插入成绩
	 * @param score 成绩对象
	 * @return
	 */
	public int add(Score score) {
                String sql = "insert into score values(?,?,?)";
                return scoreUtil.add(sql, score.getSname(),score.getCname(),score.getScore());
        }

        /**
	 * 依据学生姓名和课程名称来删除成绩
	 * @param sname 学生姓名
	 * @param cname 课程名称
	 * @return 存在则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteScore(String sname,String cname) {
                String sql = "delete from score where sname=? and cname=?";
                int a = scoreUtil.delete(sql, sname, cname);
                if(a>0){
                          return true;
                }else{
                          return false;  
                }
        }
}