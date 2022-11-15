package com.ujs.stupool.model;

import lombok.Data;

@Data
public class Post {
    int id;
    String username;
    String subarea;
    String title;
    String mini_content;
    String content;
    long   date;
    int    view;
    int    like;
    int    comment_num;
    String Cover;
}
