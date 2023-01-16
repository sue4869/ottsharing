package kr.flab.ottsharing.notification.infrastructure.config;

import kr.flab.ottsharing.notification.infrastructure.reader.MyBatisUserReader;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import javax.sql.DataSource;

@Import(value = MyBatisUserReader.class)
@Configuration
public class QueryModuleConfiguration {
    @Bean
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        var factoryBean = new SqlSessionFactoryBean();
        var configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);
        factoryBean.setDataSource(dataSource);
        factoryBean.setConfiguration(configuration);
        factoryBean.setTypeAliasesPackage("kr.flab.ottsharing.notification.*");
        var resolver = new PathMatchingResourcePatternResolver();
        factoryBean.setMapperLocations(resolver
                .getResources("classpath:mapper/*.xml"));

        return factoryBean.getObject();
    }
}
