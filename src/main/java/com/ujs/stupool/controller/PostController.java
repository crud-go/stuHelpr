package com.ujs.stupool.controller;

import com.ujs.stupool.model.Post;
import com.ujs.stupool.model.PostComment;
import com.ujs.stupool.model.PostCommentStruct;
import com.ujs.stupool.model.ResponseStatus;
import com.ujs.stupool.model.request.PostRequest;
import com.ujs.stupool.model.response.CommonRes;
import com.ujs.stupool.model.response.PostBasicInfo;
import com.ujs.stupool.model.response.PostDetail;
import com.ujs.stupool.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
public class PostController {
    PostService postService;
@Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/hot")
    ResponseStatus<List<PostBasicInfo>> getHotPosts()
    {
        List<PostBasicInfo> hotPosts = postService.getHotPosts();

        if(hotPosts!=null)
        {
            return new ResponseStatus<>(1,hotPosts,"ok");
        }
          return  new ResponseStatus<>(0,null,"未知错误");

    }
    @GetMapping("/fetchcomment/{id}")
    ResponseStatus<List<PostCommentStruct>> getAllComment(@PathVariable int id){

        List<PostCommentStruct> postComments = postService.GetAllComment(id);

        if(postComments!=null)
        {
            return new ResponseStatus<>(1,postComments,"评论获取成功");
        }

    return new ResponseStatus<>(0,null,"获取评论失败");
    }
    @GetMapping("/postdetail/{id}")
    ResponseStatus<PostDetail> getPostDetail(@PathVariable int id){

    PostDetail postDetail=postService.GetPostDetail(id);
    if(postDetail!=null)
    {
        return new ResponseStatus<>(1,postDetail,"帖子获取成功");
    }

        return new ResponseStatus<>(0,null,"获取帖子失败");
    }
    @PostMapping("/savecomment")
    CommonRes SaveComment(@RequestBody PostComment postComment){

       postComment.setDate(System.currentTimeMillis());

        if(postService.SaveComment(postComment)==1)
        {
            return  new CommonRes(1,"success");
        }

       return new CommonRes(0,"评论失败");
    }

    @PostMapping("/savepost")
    CommonRes SavePost(@RequestBody PostRequest postRequest){

     if(postService.SavaPost(postRequest)==1)
     {
         return  new CommonRes(1,"success");
     }
     return  new CommonRes(0,"保存失败");


    }
    @PostMapping("/subarea")
   ResponseStatus<List<PostBasicInfo>>getPostsBySubarea(@RequestBody Map<String,Object> data){
        int page = (int) data.get("page");
        int pageSize= (int) data.get("pagesize");
        String sub= (String) data.get("subarea");
        List<PostBasicInfo> basicInfoList=postService.getPostsBySubarea(sub,page*pageSize,pageSize);
        if(basicInfoList!=null)
        {
            return new ResponseStatus<>(1,basicInfoList,"success");
        }
        else
        {
            return new ResponseStatus<>(0,null,"查询出错");
        }

    }

      @PostMapping ("/myposts")
    ResponseStatus<List<PostBasicInfo>> getAllMyPosts(HttpServletRequest request,@RequestBody Map<String,Object> data){
          HttpSession s = request.getSession();
          Integer id= (Integer) s.getAttribute("userid");
          int page = (int) data.get("page");
          int pageSize= (int) data.get("pagesize");
          if(id==null)
          {
              return  new ResponseStatus<>(0,null,"token解析错误");
          }
         List<PostBasicInfo> basicInfoList= postService.getAllMyPosts(id,page*pageSize,pageSize);
          if(basicInfoList!=null)
          {
              return new ResponseStatus<>(1,basicInfoList,"success");

          }
          return new ResponseStatus<>(0,null,"获取失败");


    }



}
