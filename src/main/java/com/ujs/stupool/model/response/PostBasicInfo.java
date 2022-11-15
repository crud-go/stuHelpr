package com.ujs.stupool.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PostBasicInfo {
    int id;
    @JsonProperty("author")
    String username;
    String subarea;
    String title;
    String mini_content;
    long   date;
    int    view;
    int    like;
    int    comment_num;
    String avatar;
    String Cover;

}
