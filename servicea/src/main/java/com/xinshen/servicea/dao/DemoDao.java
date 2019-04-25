package com.xinshen.servicea.dao;

import com.xinshen.servicea.model.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lzx
 * @date 2019/3/4 9:26
 */
@Mapper
public interface DemoDao {
    @Insert("insert into tablea (name) values (#{name})")
    int insertDemo(Demo demo);
}
