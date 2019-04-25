package com.xinshen.txmanager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@com.codingapi.txlcn.tm.config.EnableTransactionManagerServer
@EnableDiscoveryClient
@EnableEurekaClient
public class TxmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TxmanagerApplication.class, args);
    }

}
