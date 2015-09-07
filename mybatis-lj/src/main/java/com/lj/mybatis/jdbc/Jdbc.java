package com.lj.mybatis.jdbc;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	
	public void connection(){
		//数据库连接
		Connection coon=null;
		//预编译的statement ，使用预编译的statement提高数据库性能
		PreparedStatement statement=null;
		//结果集
		ResultSet resultSet=null;
		try {
			//加载数据库驱动
			Class.forName("com.oracle.jdbc.Driver");
			
			//通过驱动管理类获取数据库连接
			coon=DriverManager.getConnection("jdbc:oracle//localhost:1521/mybatis");
		   //定义sql语句？表示占位符
			String sql="select * from user where username=?";
			//获取预处理statement
			statement=coon.prepareStatement(sql);
			//设置参数，第一个参数为生气了语句中参数的序号（从1开始），第二个参数为设置的参数值
			statement.setString(1, "张三");
			//向数据库发出sql执行查询，获取结果集
			resultSet=statement.executeQuery();
			//
			while(resultSet.next()){
				System.out.println(resultSet.getString("id"));
			}
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//释放资源
			if(resultSet!=null){
				try {
					resultSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement!=null){
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(coon!=null){
				try {
					coon.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}

}
