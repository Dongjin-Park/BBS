package com.benple.bbs;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@MapperScan(value={"com.benple.bbs.board.mapper"})
public class BbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BbsApplication.class, args);
	}
	
	/*
	 * SqlSessionFactory 설정 
	 * */
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		
		sessionFactory.setDataSource(dataSource);
		return sessionFactory.getObject();
	}
	
}
