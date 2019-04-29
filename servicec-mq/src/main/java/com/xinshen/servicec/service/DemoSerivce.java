package com.xinshen.servicec.service;

import com.xinshen.servicec.model.Demo;
import org.springframework.stereotype.Service;

/**
 * @author lzx
 * @date 2019/3/4 9:40
 */
@Service
public interface DemoSerivce {
    int add(Demo demo);
}
