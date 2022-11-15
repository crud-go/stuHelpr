package com.ujs.stupool.controller;

import com.ujs.stupool.model.ResponseStatus;
import com.ujs.stupool.model.User;
import com.ujs.stupool.model.response.BasicUser;
import com.ujs.stupool.model.response.CommonRes;
import com.ujs.stupool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class UserController {
UserService userService;
 @Autowired
    public UserController(UserService userService) {
        this.userService = userService;

    }


    @PostMapping("/login")
    public ResponseStatus<BasicUser> Login(@RequestBody Map<String,Object> data){
      String username=  (String) data.get("username");
      String password=  (String) data.get("password");
      if(username==null||password==null)return new ResponseStatus<>(0,null,"上传参数错误");
      return  userService.UserLogin(username,password);


    }
    @PostMapping("/register")
    public CommonRes Register(@RequestBody Map<String,Object> data){
        String username=  (String) data.get("username");
        String password=  (String) data.get("password");
        if(username==null||password==null)return new CommonRes(0,"上传参数错误");
        return userService.UserRegister(username,password);

    }

    @PutMapping("/password")
    public CommonRes changePassword(@RequestBody Map<String,Object> data,HttpServletRequest request){
        String newpwd =(String) data.get("newPassword");
        HttpSession s = request.getSession();
         Integer id= (Integer) s.getAttribute("userid");
         if(id==null)
         {
             return  new CommonRes(0,"token解析错误");

         }
         else {
             userService.changePassword(newpwd,id);
             return  new CommonRes(1,"修改密码成功");
         }



    }
    @PutMapping ("/updatename")
    public CommonRes ChangeUserName(@RequestBody Map<String,Object> data, HttpServletRequest request)
    {
        String newName =(String) data.get("newName");
        if(newName==null){

            return new CommonRes(0,"上传的参数错误");
        }
        HttpSession s = request.getSession();
        Integer id= (Integer) s.getAttribute("userid");
        if(id==null)
        {
            return  new CommonRes(0,"token解析错误");

        }else{
            userService.changeUsername(id,newName);

            return  new CommonRes(1,"修改名字成功");
        }



    }
    @PutMapping("/changeinfo")
    public  CommonRes changeUserInfo(@RequestBody User user,HttpServletRequest request){
        int id= (int) request.getSession().getAttribute("userid");
        if(id!=0)
        {
            user.setId(id);
            if(userService.changeUserInfo(user)==1)
            {
                return  new CommonRes(1,"修改成功");

            }
            return new CommonRes(0,"修改失败");

        }else {
            return new CommonRes(0,"token解析出错");
        }


    }



        @GetMapping("/userinfo")
       public ResponseStatus<User> GetUserInfo(HttpServletRequest request){

            int id= (int) request.getSession().getAttribute("userid");
            if(id!=0)
            {
               User user= userService.getUserInfoById(id);
               if(user!=null)
               {
                   return new ResponseStatus<>(1,user,"success");
               }
               return new ResponseStatus<>(0,null,"用户已经注销");

            }else {
                return new ResponseStatus<>(0,null,"Token错误");
            }


        }


}
