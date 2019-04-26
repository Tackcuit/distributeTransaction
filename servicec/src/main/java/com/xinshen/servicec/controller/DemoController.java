package com.xinshen.servicec.controller;

import com.xinshen.servicec.model.Demo;
import com.xinshen.servicec.service.DemoSerivce;
import com.xinshen.servicec.service.FeignServiceB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzx
 * @date 2019/3/4 9:47
 */
@RestController
public class DemoController {
    @Autowired
    private DemoSerivce demoSerivce;
    @Autowired
    private FeignServiceB feignServiceB;

    @GetMapping("/demoinsert/{userName}")
    public int demoInsert(@PathVariable("userName") String name) {
        Demo demo = new Demo();
        demo.setName(name);
        //在b服务中调用a服务
//        feignServiceB.add(name);
        try {
            int add = demoSerivce.add(demo);
            return add;
        } catch (Exception e) {
            return 12345;
        }
//        return demoSerivce.add(demo);
    }
}
