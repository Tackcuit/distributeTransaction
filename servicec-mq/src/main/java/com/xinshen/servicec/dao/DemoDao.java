package com.xinshen.servicec.dao;

import com.xinshen.servicec.model.Demo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * @author lzx
 * @date 2019/3/4 9:38
 */
@Mapper
public interface DemoDao {
    @Insert("insert into tablec (name) values (#{name})")
    @Options(useGeneratedKeys = true)
    int insertDemo(Demo demo);
}
