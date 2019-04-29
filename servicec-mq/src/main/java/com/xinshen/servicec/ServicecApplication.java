package com.xinshen.servicec;

//import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.spring.annotation.GlobalTransactionScanner;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
//@EnableDistributedTransaction
//@EnableTransactionManagement
public class ServicecApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServicecApplication.class, args);
    }
//
//    @Bean
//    @ConfigurationProperties(prefix = "spring.datasource")
//    public DruidDataSource druidDataSource() {
//        DruidDataSource druidDataSource = new DruidDataSource();
//        return druidDataSource;
//    }
////
//    @Primary
//    @Bean
//    public DataSourceProxy dataSourceProxy(DruidDataSource druidDataSource) {
//        return new DataSourceProxy(druidDataSource);
//    }
//
//    @Bean
//    public SqlSessionFactory sqlSessionFactory(DataSourceProxy datasource) throws Exception {
//        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
//        sqlSessionFactoryBean.setDataSource(datasource);
//        sqlSessionFactoryBean.setTransactionFactory(new JdbcTransactionFactory());
//        return sqlSessionFactoryBean.getObject();
//    }
//
//    @Bean
//    public GlobalTransactionScanner globalTransactionScanner() {
//        return new GlobalTransactionScanner("serviceC", "ny_test_tx_group");
//    }

}
