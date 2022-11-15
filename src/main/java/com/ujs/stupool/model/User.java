package com.ujs.stupool.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


//    id int unsigned primary key auto_increment,
//            username varchar(20) unique not null ,
//            password varchar(30) not null ,
//            sex ENUM('男','女')   DEFAULT NULL,
//            age tinyint,
//            avatar varchar(100),
//            introduction varchar(200),
//            postnum int
@Data
public class User {
    int id;
    String username;
    @JsonIgnore
    String password;
    String sex;
    int age;
    String avatar;
    String introduction;
    int postnum;

}
