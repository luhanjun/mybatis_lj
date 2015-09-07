package com.lj.mybatis.dao;

import com.lj.mybatis.model.User;

public interface IUserDao {
	/**
	 * 根据id查询用户
	 */
	public User findUserById(int id)  throws Exception;
	
	/**
	 * 添加用户信息
	 */
	public void insertUser(User user) throws Exception;
	
	/**
	 * 删除用户信息
	 */
	public void deleteUserById(int id) throws Exception;

}
