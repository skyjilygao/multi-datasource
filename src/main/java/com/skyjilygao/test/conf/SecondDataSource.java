package com.skyjilygao.test.conf;

import com.zaxxer.hikari.HikariDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import javax.sql.DataSource;


/**
 * Created by SKYJILYGAO on 2018/5/5.
 */
@SpringBootConfiguration
@MapperScan(basePackages = "com.skyjilygao.test.dao.second", sqlSessionFactoryRef = "sessionFactory2")
public class SecondDataSource {

    /**
     * 将properties中以mysql为前缀的参数值，写入方法返回的对象中
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource2")
    public DataSource dataSource2() {
        //通过DataSourceBuilder构建数据源
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    /**
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sessionFactory2(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "mapper/second/*.xml";
        bean.setMapperLocations(pathMatchingResourcePatternResolver.getResources(packageSearchPath));
        return bean.getObject();
    }
}
