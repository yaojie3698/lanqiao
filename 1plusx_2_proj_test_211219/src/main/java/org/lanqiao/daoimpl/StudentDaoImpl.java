package org.lanqiao.daoimpl;

import java.util.List;

import org.lanqiao.bean.Student;
import org.lanqiao.dao.StudentDao;
import org.lanqiao.db.ObjectUtil;

/**
 * 接口实现类
 */
public class StudentDaoImpl implements StudentDao{
        /*
         * ObjectUtil工具类提供的方法能实现对数据库的CRUD操作
         * */
        ObjectUtil<Student> studentUtil = new ObjectUtil<Student>();

        /**
	 * 查询最大年龄的学生姓名
	 * @return 返回学生姓名
	 */
	public String queryMaxAge() {
                // 请补全sql语句
                String sql = "###";
                Student g = studentUtil.getOne(sql, Student.class);
                return g.getName();
        }

        /**
	 * 查询年龄大于20岁的学生总人数
	 * @return 返回总人数
	 */
	public int queryNum() {
                String sql = "select * from student where age>20";
                List<Student> list = studentUtil.getList(sql, Student.class);
                // 请修改以下代码，保证返回值为总人数，假设所有学生名字都不一样
                int num = 0;
                return num;
        }

        /**
	 * 插入学生
	 * @param s 学生对象
	 * @return
	 */
	public int add(Student s) {
                // 请补全sql语句
                String sql = "###";
                return studentUtil.add(sql, s.getName(),s.getPwd(),s.getAge(),s.getGrade(),s.getRate());
        }

        /**
	 * 依据学生姓名来删除学生
	 * @param name 学生姓名
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteStudent(String name) {
                String sql = "delete from student where name=?";
                int a = studentUtil.delete(sql, name);
                if(a>0){
                          return true;
                }else{
                          return false;  
                }
        }
}