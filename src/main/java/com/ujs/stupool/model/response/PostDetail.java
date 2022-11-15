package com.ujs.stupool.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class PostDetail {
    int id;
    @JsonProperty("author")
    String username;
    String subarea;
    String title;
    String content;
    long   date;
    int    view;
    int    like;
    int    comment_num;
    String avatar;
    List<String> pictures;

}
