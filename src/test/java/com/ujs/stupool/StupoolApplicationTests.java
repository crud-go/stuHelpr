package com.ujs.stupool;

import com.ujs.stupool.mapper.PostsMapper;
import com.ujs.stupool.mapper.UserMapper;
import com.ujs.stupool.model.Post;
import com.ujs.stupool.model.PostComment;
import com.ujs.stupool.model.PostCommentStruct;
import com.ujs.stupool.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class StupoolApplicationTests {
    @Autowired
    PostsMapper postsMapper;
    @Test
    void contextLoads() {
// List<String> urls=new ArrayList<>();
// urls.add("aaaaaa");
// urls.add("bbbb");
// urls.add("cccc");
//  postsMapper.addPostPictures(urls,52);
        postsMapper.getPostDetailById(52);


    }

}
