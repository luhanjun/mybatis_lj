package com.lj.mybatis.model;

import java.util.Date;
/**
 * 
 * @author ：lj
 * @date ：  2015年9月7日 下午1:14:27
 */
public class User {
	private int id;
	private String userName;//用户名
	private String passwd;//用户密码
	private String 	sex;//性别
	private Date birthday;//出生日期
	private String address;//住址
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	

}
