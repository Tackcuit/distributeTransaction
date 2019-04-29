//package com.xinshem.serviceb.config;
//
//import com.codingapi.txlcn.tc.aspect.weave.DTXResourceWeaver;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.core.Ordered;
//import org.springframework.stereotype.Component;
//
//import java.sql.Connection;
//
///**
// * @author lzx
// * @date 2019/4/25 18:39
// */
////@Component
////@Aspect
//public class TomcatDataSourceAspect implements Ordered {
//
//    @Autowired
//    private DTXResourceWeaver dtxResourceWeaver;//TX-LCN 资源切面处理对象
//
//    @Around("execution(public java.sql.Connection org.apache.tomcat.jdbc.pool.DataSourceProxy.getConnection(..) )")
//    public Object around(ProceedingJoinPoint point) throws Throwable {
//        return dtxResourceWeaver.getConnection(() -> (Connection) point.proceed());
//    }
//
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
