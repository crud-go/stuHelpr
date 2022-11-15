package com.ujs.stupool.mapper;

import com.ujs.stupool.model.Hello;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HelloMapper {
  Hello getHello();
}
