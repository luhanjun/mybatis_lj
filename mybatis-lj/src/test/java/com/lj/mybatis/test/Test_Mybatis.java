package com.lj.mybatis.test;

import java.io.IOException;
import java.io.InputStream;
import java.security.acl.LastOwnerException;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.lj.mybatis.model.User;

public class Test_Mybatis {
	
	/**
	 * 根据用户id，获取用户信息
	 * @throws IOException 
	 */
	@Test
	public void findUserById(){
		//mybatis配置文件
		String resource="mybatis-config.xml";
		SqlSession session=null;
		
		//得到mybatis配置文件流
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		//1、创建会话工厂SqlSessionFactory(SqlSessionFactory通过SqlSessionFactoryBuilder获取)
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//2、根据会话工厂SqlSessionFactory获取会话SqlSession
		session=sessionFactory.openSession();
		
		//3、通过SqlSession操作数据库
		//第一个参数statement：映射文件中statement的id，namaspace+"."statement的id
		//第二个参数paerameter:映射文件中中所匹配的paremeterType类型的参数
		User user=session.selectOne("test.findUserById",1);
		System.out.println(user.getUserName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session!=null){
				//释放资源
				session.close();
			}
		}
		
	}
	
	
	/**
	 * 根据用户名模糊查询用户
	 * 
	 */
	@Test
	public void  findUserByName(){
		String resource="mybatis-config.xml";
		SqlSession session=null;
		try {
			InputStream inputStream=Resources.getResourceAsStream(resource);
			
			SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
			
			session=sessionFactory.openSession();
			
			List<User> list=session.selectList("test.findUserByName", "张三");
			System.out.println(list.size());
			for(User user:list){
				System.out.println(user.getPasswd());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session!=null){
				session.close();
			}
		}
	}
	
	
	/**
	 * 新增用户
	 */
	@Test
	public void insertUser(){
		//mybatis配置文件
		String resource="mybatis-config.xml";
		SqlSession session=null;
		
		//得到mybatis配置文件流
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		//1、创建会话工厂SqlSessionFactory(SqlSessionFactory通过SqlSessionFactoryBuilder获取)
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//2、根据会话工厂SqlSessionFactory获取会话SqlSession
		session=sessionFactory.openSession();
		
		User user=new User();
		user.setUserName("李思思");
		user.setPasswd("1230");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("我家");
		//添加用户
		session.insert("test.insertUser", user);
		
		
		//执行提交事务
		session.commit();

		System.out.println(user.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session!=null){
				//释放资源
				session.close();
			}
		}
	}
	
	
	
	
	/**
	 * 根据用户id删除用户
	 */
	@Test
	public void deleteUserById(){
		//mybatis配置文件
		String resource="mybatis-config.xml";
		SqlSession session=null;
		
		//得到mybatis配置文件流
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		//1、创建会话工厂SqlSessionFactory(SqlSessionFactory通过SqlSessionFactoryBuilder获取)
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//2、根据会话工厂SqlSessionFactory获取会话SqlSession
		session=sessionFactory.openSession();
		
		//删除用户
		session.delete("test.deleteUserById", 1);
		
		
		//执行提交事务
		session.commit();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session!=null){
				//释放资源
				session.close();
			}
		}
	}
	
	
	/**
	 * 根据用户id修改用户
	 */
	@Test
	public void updateUserById(){
		//mybatis配置文件
		String resource="mybatis-config.xml";
		SqlSession session=null;
		
		//得到mybatis配置文件流
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		//1、创建会话工厂SqlSessionFactory(SqlSessionFactory通过SqlSessionFactoryBuilder获取)
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		
		//2、根据会话工厂SqlSessionFactory获取会话SqlSession
		session=sessionFactory.openSession();
		
		User user=new User();
		user.setId(4);;
		user.setUserName("李思思");
		user.setPasswd("1230");
		user.setSex("女");
		user.setBirthday(new Date());
		user.setAddress("我家");
		//修改用户
		session.update("test.updateUserById", user);
		
		
		//执行提交事务
		session.commit();

		System.out.println(user.getId());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(session!=null){
				//释放资源
				session.close();
			}
		}
	}
	

}
