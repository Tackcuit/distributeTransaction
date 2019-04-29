package com.xinshem.serviceb.controller;

import com.xinshem.serviceb.model.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.xinshem.serviceb.service.DemoSerivce;
import com.xinshem.serviceb.service.FeignServiceA;

/**
 * @author lzx
 * @date 2019/3/4 9:47
 */
@RestController
public class DemoController {
    @Autowired
    private DemoSerivce demoSerivce;
    @Autowired
    private FeignServiceA feignServiceA;

    @GetMapping("/demoinsert/{userName}")
    public int demoInsert(@PathVariable("userName")String name) {
        Demo demo = new Demo();
        demo.setName(name);
        //在b服务中调用a服务
//        feignServiceA.add(name);
        try {
            int add = demoSerivce.add(demo);
            return add;
        } catch (Exception e) {
            return 0;
        }
    }
}
