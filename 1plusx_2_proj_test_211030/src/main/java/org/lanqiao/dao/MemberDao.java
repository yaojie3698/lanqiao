package org.lanqiao.dao;

import org.lanqiao.bean.Member;

public interface MemberDao {
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
	public void updateRank();

	/**
	 * 给每个会员的密码加密
	 * 加密规则：密码的逆序。
	 * 如：原来的密码是123，加密后为321。
	 */
	public void updatePwd();

	 /**
	 * 根据会员名称来查询会员
	 * @return 返回会员对象
	 */
	public Member queryMember(String name);

	/**
	 * 插入会员
	 * @param member 会员对象
	 * @return
	 */
	public int add(Member member);

	/**
	 * 依据会员名称来删除会员
	 * @param name 会员名称
	 * @return 存在名字则删除，并返回true；不存在则不删除，并返回false
	 */
	public boolean deleteMember(String name);
}