package org.lanqiao.daoimpl;

import org.lanqiao.bean.Member;
import org.lanqiao.dao.MemberDao;
import org.lanqiao.db.ObjectUtil;

/**
 * 接口实现类
 */
public class MemberDaoImpl implements MemberDao{
        /*
         * ObjectUtil工具类提供的方法能实现对数据库的CRUD操作
         * */
        ObjectUtil<Member> memberUtil = new ObjectUtil<Member>();

        /**
	 * 根据会员的积分来更新会员的等级
	 * 0<=score<100分，等级为0
	 * 100<=score<200分，等级为1
	 * 200<=score<300分，等级为2
	 * 300<=score<400分，等级为3
	 * 400<=score<500分，等级为4
	 * 500<=score分，等级为5
	 * @return
	 */
	public void updateRank() {
                // 请补全sql语句
                String sql = "update `member` set `rank` = (case when score between 0 and 99 then 0 "+
                                                                "when score between 100 and 199 then 1 "+
                                                                "when score between 200 and 299 then 2 "+
                                                                "when score between 300 and 399 then 3 "+
                                                                "when score between 400 and 499 then 4 "+
                                                                "when score>=500 then 5 end "+
                                ") ";
                memberUtil.update(sql); 
        }

        /**
	 * 给每个会员的密码加密
	 * 加密规则：密码的逆序。
	 * 如：原来的密码是123，加密后为321。
	 */
	public void updatePwd(){
                // 请补全sql语句
                String sql = "update member set pwd = reverse(pwd)";
                memberUtil.update(sql); 
        }

         /**
	 * 根据会员名称来查询会员
	 * @return 返回会员对象
	 */
	public Member queryMember(String name) {
                String sql = "select * from member where name=?";
                Member g = memberUtil.getOne(sql, Member.class, name);
                return g; 
        }

         /**
	 * 插入会员
	 * @param member 会员对象
	 * @return
	 */
	public int add(Member member){
                String sql = "insert into member values(?,?,?,?)";
                return memberUtil.add(sql, member.getName(),member.getPwd(),member.getScore(),member.getRank());
        }

        /**
	 * 依据会员名称来删除会员
	 * @param name 会员名称
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteMember(String name) {
                // 请补全sql语句
                String sql = "delete from member where name=?";
                int a = memberUtil.delete(sql, name);
                if(a>0){
                          return true;
                }else{
                          return false;  
                }
        }
}