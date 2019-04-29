package com.xinshem.serviceb.service.impl;

//import com.codingapi.txlcn.tc.annotation.DTXPropagation;
//import com.codingapi.txlcn.tc.annotation.LcnTransaction;
//import com.codingapi.txlcn.tc.annotation.TxTransaction;
//import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.xinshem.serviceb.dao.DemoDao;
import com.xinshem.serviceb.model.Demo;
import com.xinshem.serviceb.service.DemoSerivce;
import com.xinshem.serviceb.service.FeignServiceA;
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
    private FeignServiceA feignServiceA;


//    @TxcTransaction(propagation = DTXPropagation.REQUIRED)
//    @TxTransaction(propagation = DTXPropagation.REQUIRED)
    @Transactional(rollbackFor = Exception.class)
//    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
    @Override
    public int add(Demo demo) {
        try {
//            feignServiceA.add(demo.getName());
            int i = demoSerivce.insertDemo(demo);
//            int ex = 10 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("出现问题,抛出异常" + e);
            throw new RuntimeException(e);
        }
    }
}
