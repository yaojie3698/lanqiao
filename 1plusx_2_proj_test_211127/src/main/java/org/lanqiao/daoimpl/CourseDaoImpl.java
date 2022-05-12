package org.lanqiao.daoimpl;

import java.util.List;

import org.lanqiao.bean.Course;
import org.lanqiao.dao.CourseDao;
import org.lanqiao.db.ObjectUtil;

/**
 * 接口实现类
 */
public class CourseDaoImpl implements CourseDao{
        /*
         * ObjectUtil工具类提供的方法能实现对数据库的CRUD操作
         * */
        ObjectUtil<Course> courseUtil = new ObjectUtil<Course>();

         /**
	 * 根据课程名称来更新课程难度
	 * @return 更新成功返回true，没有更新成功返回false
	 */
	public boolean updateDifficultyByName(String name,String difficulty){
                // 请补全sql语句
                String sql = "update course set difficulty = ? where name = ?";
                int a = courseUtil.update(sql, difficulty, name);
                if(a>0){
                        return true;
                }else{
                        return false;  
                }
        }


         /**
	 * 根据课程名称来查询课程
	 * @return 返回课程对象
	 */
	public Course queryCourse(String name) {
                // 请补全sql语句
                String sql = "select * from `course` where `name` = ?";
                return courseUtil.getOne(sql, Course.class, name);
        }

        /**
	 * 插入课程
	 * @param c 课程对象
	 * @return
	 */
	public int add(Course c) {
                String sql = "insert into course values(?,?,?)";
                return courseUtil.add(sql, c.getName(),c.getTeacher(),c.getDifficulty());
        }

        /**
	 * 依据课程名称来删除课程
	 * @param name 课程名称
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteCourse(String name) {
                String sql = "delete from course where name=?";
                int a = courseUtil.delete(sql, name);
                if(a>0){
                          return true;
                }else{
                          return false;  
                }
        }
}