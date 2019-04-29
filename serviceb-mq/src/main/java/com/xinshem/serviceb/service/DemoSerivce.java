package com.xinshem.serviceb.service;

import com.xinshem.serviceb.model.Demo;
import org.springframework.stereotype.Service;

/**
 * @author lzx
 * @date 2019/3/4 9:40
 */
@Service
public interface DemoSerivce {
    int add(Demo demo);
}
