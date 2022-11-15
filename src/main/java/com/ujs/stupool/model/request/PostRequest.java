package com.ujs.stupool.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostRequest {
    String username;
    String subarea;
    String title;
    String mini_content;
    String content;
    String Cover;
    List<String> pictures;
}
