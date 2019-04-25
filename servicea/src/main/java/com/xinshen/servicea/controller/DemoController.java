package com.xinshen.servicea.controller;

import com.xinshen.servicea.model.Demo;
import com.xinshen.servicea.service.DemoSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzx
 * @date 2019/3/4 9:31
 */
@RestController
public class DemoController {

    @Autowired
    private DemoSercice demoSercice;

    @GetMapping("/demoinsert/{userName}")
    public int demoInsert(@PathVariable("userName")String name) {
        Demo demo = new Demo();
        demo.setName(name);
        return demoSercice.addDemo(demo);
    }
}
