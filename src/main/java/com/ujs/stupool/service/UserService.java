package com.ujs.stupool.service;

import com.ujs.stupool.mapper.UserMapper;
import com.ujs.stupool.model.ResponseStatus;
import com.ujs.stupool.model.User;
import com.ujs.stupool.model.response.BasicUser;
import com.ujs.stupool.model.response.CommonRes;
import com.ujs.stupool.utils.TokenUtil;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    UserMapper mapper;

    public UserService(UserMapper mapper) {
        this.mapper = mapper;
    }

    public ResponseStatus<BasicUser> UserLogin(String name, String pwd){
        User user= mapper.getUserByName(name);
        if(user==null)
        {
            return new ResponseStatus<>(0,null,"用户不存在");
        }
        if(user.getPassword().equals(pwd))
        {
            return new ResponseStatus<>(1,new BasicUser(user.getUsername(),user.getAvatar()),TokenUtil.GenerateToken(user.getUsername(),user.getId()));
        }
        return new ResponseStatus<>(0,null,"密码错误");


   }
   public CommonRes UserRegister(String name,String pwd){
       User user= mapper.getUserByName(name);
       if(user==null)
       {
           mapper.insertUser(name,pwd);
           return new CommonRes(1,"注册成功");//执行插入
       }else
       {
           return new CommonRes(0,"用户名已经存在");//用户名已被注册
       }


   }


   public int  changePassword(String psw,int id){

        return mapper.ChangePassword(psw,id);

   }


   public int changeUsername(int id,String newname)
   {

       return mapper.ChangeUsername(newname,id);

   }
   public int changeUserInfo(User user)
   {
       return mapper.UpdateUserInfo(user);
   }
   public User getUserInfoById(int id)
   {
       return  mapper.getUserById(id);
   }


}
