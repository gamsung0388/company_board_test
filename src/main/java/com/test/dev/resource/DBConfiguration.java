package com.test.dev.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:/application.properties")
public class DBConfiguration {

//	@Autowired
//	private ApplicationContext applicationContext;
//	
//	@Bean
//	@ConfigurationProperties(prefix="spring.datasource.hikari")
//	public HikariConfig hikariConfig() {
//		return new HikariConfig();
//	}
//	
//	@Bean
//	public DataSource dataSource() {
//		return new HikariDataSource(hikariConfig());
//	}
//	
//	@Bean
//	public SqlSessionFactory sqlSessionFactory() throws Exception{
//		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
//		factoryBean.setDataSource(dataSource());
//		
//		//추가
//		factoryBean.setMapperLocations(applicationContext.getResources
//				("classpath:/mabis/mapper/**/*Mapper.xml"));
//		factoryBean.setTypeAliasesPackage("com.test.dev");
//		factoryBean.setConfiguration(mybatisConfg());
//		
//		return factoryBean.getObject();
//	}
//	
//	@Bean
//	public SqlSessionTemplate sqlSession() throws Exception{
//		return new SqlSessionTemplate(sqlSessionFactory());
//	}
//	
//	//추가
//	@Bean
//	@ConfigurationProperties(prefix="mybatis.configuration")
//	public org.apache.ibatis.session.Configuration mybatisConfg(){
//		return new org.apache.ibatis.session.Configuration();
//	}
	
}
