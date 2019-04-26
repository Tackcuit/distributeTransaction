package com.xinshen.servicec.service.impl;

import com.codingapi.txlcn.tc.annotation.*;
import com.xinshen.servicec.dao.DemoDao;
import com.xinshen.servicec.model.Demo;
import com.xinshen.servicec.service.DemoSerivce;
import com.xinshen.servicec.service.FeignServiceB;
//import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lzx
 * @date 2019/3/4 9:40
 */
@Service
public class DemoServiceImpl implements DemoSerivce {
    @Autowired
    private DemoDao demoSerivce;
    @Autowired
    private FeignServiceB feignServiceB;


//    @TxTransaction(propagation = DTXPropagation.REQUIRED)
    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
//    @TxcTransaction(propagation = DTXPropagation.REQUIRED)
//    @GlobalTransactional(rollbackFor = RuntimeException.class)
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public int add(Demo demo) {
        try {
            int add = feignServiceB.add(demo.getName());
            int i = demoSerivce.insertDemo(demo);
//            int ex = 10 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("出现问题,抛出异常" + e);
            throw new RuntimeException(e);
//            return 999;
        }
    }
}
