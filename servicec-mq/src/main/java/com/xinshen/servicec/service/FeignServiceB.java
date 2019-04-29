package com.xinshen.servicec.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author lzx
 * @date 2019/3/4 9:45
 */
@FeignClient("serviceB")
public interface FeignServiceB {

    @GetMapping("/demoinsert/{userName}")
    int add(@PathVariable("userName") String name);
}
