package com.example.demo.config

import org.apache.ibatis.session.SqlSessionFactory
import org.mybatis.spring.SqlSessionFactoryBean
import org.mybatis.spring.mapper.MapperScannerConfigurer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.Resource
import org.springframework.core.io.support.PathMatchingResourcePatternResolver
import javax.sql.DataSource

@Configuration
class MyBatisConfig {

    @Bean
    fun sqlSessionFactory(dataSource: DataSource): SqlSessionFactory {
        val sessionFactoryBean = SqlSessionFactoryBean()
        sessionFactoryBean.setDataSource(dataSource)

        // MyBatis Mapper XML 파일 경로 설정
        val resolver = PathMatchingResourcePatternResolver()
        val resources = resolver.getResources("classpath*:mappers/*.xml")

        // getResources()는 Array<Resource>를 반환하므로, 이를 setMapperLocations에 전달
        sessionFactoryBean.setMapperLocations(*resources)  // vararg로 전달
        return sessionFactoryBean.getObject()!!
    }

    @Bean
    fun mapperScannerConfigurer(): MapperScannerConfigurer {
        val scannerConfigurer = MapperScannerConfigurer()
        scannerConfigurer.setBasePackage("com.example.demo.mappers")  // Mapper 인터페이스가 위치한 패키지 지정
        return scannerConfigurer
    }
}