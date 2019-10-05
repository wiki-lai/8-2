package com.ali.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.ali.domain.User;

public class Tset {
	public static void main(String[] args) throws IOException {
		
		//获取配置文件
		String resource = new String("SqlMapConfig.xml");
		//获取配置文件输入流
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory（sql会话工厂）
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//通过工厂的到sqlsession（会话）
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//执行查询-->关闭会话
	
//		Object stu = sqlSession.selectOne("test.selUserById",1);
//		
//		System.out.println(stu);
		
		User k = new User();
		k.setId(5);
		k.setAge("18");
		k.setName("sakura2");
		k.setPhone("22222");
		
		int i = sqlSession.insert("test.addUser",k);
		sqlSession.commit();
		
		System.out.println(i);
		

	
        sqlSession.close();
		inputStream.close();
	
	}

}
