package org.lanqiao.dao;

import org.lanqiao.bean.SB;
import org.lanqiao.bean.Book;

public interface SBDao {
	public int add(Book book);
	 /**
	 * 依据书名查询书籍
     * 判断依据：1、是否有书名，2、数量是否大于0
	 * @param bname 书名
	 * @return 有的话返回书籍对象，没有的话返回null
	 */
	public Book findByName(String bname);

	/**
	 * 查询所有书籍中价钱最贵的书籍名称
	 * @return 返回书籍名称
	 */
	public String queryExpensiveBook();
	
	/**
	 * 依据学生的姓名来删除学生
	 * @param name 学生姓名
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteStudent(String name);

	/**
	 * 根据学生名称、旧密码、新密码来更新密码
	 * 如果学生名称和旧密码不正确，则不更新
	 * 如果学生名称和旧密码正确，则更新
	 *
	 * @param name 姓名
	 * @param oldPwd 旧密码
	 * @param newPwd 新密码
	 */
	public void changePwd(String name,String oldPwd,String newPwd);

	 /**
	 * 借书
	 * @param sb 需要借阅的书籍信息
	 * @return 借书成功返回true，借书失败返回false
	 */
	public boolean borrow(SB sb);

	 /**
	 * 还书
	 * @param sb 需要归还的书籍信息
	 * @return 还书成功返回true，还书失败返回false
	 */
	public boolean giveBack(SB sb);
}