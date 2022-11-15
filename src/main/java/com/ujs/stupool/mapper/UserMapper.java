package com.ujs.stupool.mapper;

import com.ujs.stupool.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

@Mapper
public interface UserMapper {
   User getUserByName(String name);
   User getUserById(int id);
   int  insertUser(@Param("username") String username,@Param("password") String password);
   int  UpdateUserInfo(User info);
   int  ChangePassword(@Param("password") String password,@Param("id") int id);
   int  ChangeUsername(@Param("username") String username,@Param("id") int id);
}
