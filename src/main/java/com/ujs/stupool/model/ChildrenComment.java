package com.ujs.stupool.model;

import lombok.Data;

@Data
public class ChildrenComment {
    int id;
    String content;
    String username;
    int post_id;
    int parent;
    long date;
    String avatar;
    String replyto;

}
