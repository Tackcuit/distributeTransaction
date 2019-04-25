package com.xinshen.servicea.service.impl;

import com.codingapi.txlcn.tc.annotation.*;
import com.xinshen.servicea.dao.DemoDao;
import com.xinshen.servicea.model.Demo;
import com.xinshen.servicea.service.DemoSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lzx
 * @date 2019/3/4 9:29
 */
@Service
public class DemoServiceImpl implements DemoSercice {
    @Autowired
    private DemoDao demoDao;

    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
//    @TxcTransaction
//    @TxTransaction
    @Override
    public int addDemo(Demo demo) {
        try {
            int i = demoDao.insertDemo(demo);
//            int ex = 10 / 0;
            return i;
        } catch (Exception e) {
            System.out.println("出现问题,抛出异常" + e);
            throw new RuntimeException(e);
        }
    }
}
