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
@MapperScan(basePackages = "com.skyjilygao.test.dao.master")
public class MasterDataSource {

    /**
     * 默认数据源 </br>
     * 将properties中以mysql为前缀的参数值，写入方法返回的对象中
     * @return
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource dataSource() {
        //通过DataSourceBuilder构建数据源
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    /**
     * 默认 SqlSessionFactory
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    @Primary
    public SqlSessionFactory sessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + "mapper/master/*.xml";
        Resource[] resources = pathMatchingResourcePatternResolver.getResources(packageSearchPath);
        bean.setMapperLocations(resources);
        return bean.getObject();
    }
}