package com.ujs.stupool.service;

import com.ujs.stupool.mapper.PostsMapper;
import com.ujs.stupool.model.Post;
import com.ujs.stupool.model.PostComment;
import com.ujs.stupool.model.PostCommentStruct;
import com.ujs.stupool.model.request.PostRequest;
import com.ujs.stupool.model.response.PostBasicInfo;
import com.ujs.stupool.model.response.PostDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    PostsMapper postsMapper;


    @Autowired
    public PostService(PostsMapper postsMapper) {
        this.postsMapper = postsMapper;
    }
   public List<PostBasicInfo> getHotPosts(){

        return postsMapper.getHotPost();
    }

    public PostDetail GetPostDetail(int id)
    {
        return postsMapper.getPostDetailById(id);
    }

    public List<PostCommentStruct> GetAllComment(int id){

        return  postsMapper.getPostComByPostId( id);
    }
    public int SavaPost(PostRequest postRequest)
    {
        Post post =new Post();
        post.setContent(postRequest.getContent());
        post.setSubarea(postRequest.getSubarea());
        post.setTitle(postRequest.getTitle());
        post.setUsername(postRequest.getUsername());
        post.setCover(postRequest.getCover());
        post.setMini_content(postRequest.getMini_content());
        post.setView(0);
        post.setLike(0);
        post.setDate(System.currentTimeMillis());
        post.setComment_num(0);
        int a= postsMapper.insertPost(post);

        if(postRequest.getPictures()==null)
        {


            return a>0?1:0;
        }
        if(postRequest.getPictures().size()==0)
        {
            return a>0?1:0;

        }

        int b= postsMapper.addPostPictures(postRequest.getPictures(),post.getId());
        return b>0?1:0;



    }

    public List<PostBasicInfo> getPostsBySubarea(String subarea, int page, int pageSize){

        return postsMapper.getPostBySubarea(subarea,page,pageSize);
    }


    public int SaveComment(PostComment postComment){

        return postsMapper.insertComment(postComment);
    }


    public List<PostBasicInfo> getAllMyPosts(int userid,int currentPage,int pageSize){

        return postsMapper.getAllMyPosts(userid,currentPage,pageSize);
    }




}
