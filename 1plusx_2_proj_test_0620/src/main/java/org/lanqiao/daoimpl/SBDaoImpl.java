package org.lanqiao.daoimpl;

import org.lanqiao.bean.Book;
import org.lanqiao.bean.SB;
import org.lanqiao.bean.Student;
import org.lanqiao.dao.SBDao;
import org.lanqiao.db.ObjectUtil;
import org.lanqiao.util.DateUtil;

import java.util.Date;

/**
 * 接口实现类
 */
public class SBDaoImpl implements SBDao{
        /*
         * ObjectUtil工具类提供的方法能实现对数据库的CRUD操作
         * */
        ObjectUtil<SB> ou = new ObjectUtil<SB>();
        ObjectUtil<Book> bookUtil = new ObjectUtil<Book>();

        public int add(Book book){
                String sql = "insert into book values(?,?,?,?)";
                return bookUtil.add(sql, book.getName(),book.getAuthor(),book.getPrice(),book.getNum());
        }
        /**
	 * 依据书名查询书籍
         * @param bname 书名
	 * @return 有的话返回书籍对象（唯一），没有的话返回null
	 */
	public Book findByName(String bname){
                // 请补全sql语句
                String sql = "select * from `book` where `name` = ?";
                Book b = ou.getOne(sql, Book.class, bname);
                return b;
        }

        /**
	 * 查询所有书籍中价钱最贵的书籍名称
	 * @return 返回书籍名称
	 */
	public String queryExpensiveBook(){
                // 请补全sql语句
                String sql = "select name from book where price = (select max(price) from book)";
                Book b = ou.getOne(sql, Book.class);
                return b.getName();
        }

        /**
	 * 依据学生的姓名来删除学生
	 * @param name 学生姓名
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteStudent(String name){
              // 请补全sql语句
              String sql = "delete from student where name = ?";
              int a = ou.delete(sql, name);
              if(a>0){
                        return true;
              }else{
                        return false;  
              }
        }

        /**
	 * 根据学生姓名、旧密码、新密码来更新密码
	 * 如果学生姓名和旧密码不正确，则不更新
	 * 如果学生姓名和旧密码正确，则更新
	 *
	 * @param name 姓名
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 */
	public void changePwd(String name,String oldPwd,String newPwd){
                // 1.先判断学生姓名和旧密码是否正确
                // 请补全sql语句
                String sql1 = "select * from student where name = ? and pwd = ?";
                Student s = ou.getOne(sql1, Student.class, name, oldPwd);

                // 2.姓名和旧密码正确，则更新；姓名和旧密码不正确，则不更新
                if(s!=null){
                        // 请补全sql语句
                        String sql2 = "update student set pwd = ? where name = ?";
                        ou.update(sql2, newPwd, name);
                }
        }

        /**
	 * 借书
	 * @param sb 需要借阅的书籍信息
	 * @return 借书成功返回true，借书失败返回false
	 */
        public boolean borrow(SB sb) {
                // 1.首先依据要借的书名来获取书籍对象
                Book b = findByName(sb.getBname());
                
                // 2.有书则借书，并返回true；没有书则不借书，并返回false
                if(b!=null&&b.getNum()>0){
                        // 往 sb 表中插入相关信息：学生姓名，书籍名称，借书时间。自增id和还书时间不用插入。
                        // 请补全sql语句
                        String sql1 = "insert into sb (sname,bname,begintime) values (?,?,?)";
                        ou.add(sql1,sb.getSname(),sb.getBname(),DateUtil.convertFromDateToString(sb.getBeginTime()));
                        // 更新 book 表中对应书籍的数量减1
                        // 请补全sql语句
                        String sql2 = "update book set num = num - 1 where name = ?";
                        ou.update(sql2, sb.getBname());
                        return true;
                }else{
                        return false;
                }
        }

        /**
	 * 还书
	 * @param sb 需要归还的书籍信息
	 * @return 还书成功返回true，还书失败返回false
	 */
	public boolean giveBack(SB sb){
                //1.首先查询某人是否在某个时间借阅了某书，但是还没有归还
                // 请补全sql语句
                String sql = "select endtime from sb where sname = ? and bname = ? and begintime = ?";
                String btime = DateUtil.convertFromDateToString(sb.getBeginTime());
                SB f = ou.getOne(sql, SB.class, sb.getSname(),sb.getBname(), btime);

                //2.借了则归还，并返回true；没有借则不用归还，并返回false
                if(f!=null){
                        // 根据借书人、借书名称、借书时间来更新 sb 表中的还书时间为当前时间
                        // 请补全sql语句
                        String sql1 = "update sb set endtime = ? where sname = ? and bname = ? and begintime = ?";
                        ou.update(sql1, DateUtil.convertFromDateToString(new Date()),sb.getSname(),sb.getBname(),DateUtil.convertFromDateToString(sb.getBeginTime()));
                        // 更新 book 表中对应书籍的数量加1
                        // 请补全sql语句
                        String sql2 = "update book set num = num + 1 where name = ?";
                        ou.update(sql2, sb.getBname());
                        return true;
                }else{
                        return false;
                }
        }
}