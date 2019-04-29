package com.xinshem.serviceb.service.impl;

//import com.codingapi.txlcn.tc.annotation.DTXPropagation;
//import com.codingapi.txlcn.tc.annotation.LcnTransaction;
//import com.codingapi.txlcn.tc.annotation.TxTransaction;
//import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.alibaba.fastjson.JSON;
import com.xinshem.serviceb.dao.DemoDao;
import com.xinshem.serviceb.model.Demo;
import com.xinshem.serviceb.model.MessageBody;
import com.xinshem.serviceb.service.DemoSerivce;
import com.xinshem.serviceb.service.FeignServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.*;

/**
 * @author lzx
 * @date 2019/3/4 9:40
 */
@Service
public class DemoServiceImpl implements DemoSerivce, MessageListener {
    @Autowired
    private DemoDao demoDao;
    @Autowired
    private FeignServiceA feignServiceA;
    @Autowired
    private JmsTemplate jmsTemplate;


//    @TxcTransaction(propagation = DTXPropagation.REQUIRED)
//    @TxTransaction(propagation = DTXPropagation.REQUIRED)
    @Transactional(rollbackFor = Exception.class)
//    @LcnTransaction(propagation = DTXPropagation.REQUIRED)
    @Override
    public int add(Demo demo) {
        try {
//            feignServiceA.add(demo.getName());
            int i = demoDao.insertDemo(demo);
//            int ex = 10 / 0;
            MessageBody messageBody = new MessageBody();
            messageBody.setName(demo.getName());
//            sendMessage(messageBody);
            return i;
        } catch (Exception e) {
            System.out.println("出现问题,抛出异常" + e);
            throw new RuntimeException(e);
        }
    }

    private void sendMessage(MessageBody messageBody) {
        jmsTemplate.send("create_table", (session -> session.createTextMessage(JSON.toJSONString(messageBody))));
    }

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String text = textMessage.getText();
            MessageBody messageBody = JSON.parseObject(text, MessageBody.class);
            Demo demo = new Demo();
            demo.setName(messageBody.getName());
            demoDao.insertDemo(demo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
