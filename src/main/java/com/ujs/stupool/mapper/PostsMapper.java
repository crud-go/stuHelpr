package com.ujs.stupool.mapper;

import com.ujs.stupool.model.Post;
import com.ujs.stupool.model.PostComment;
import com.ujs.stupool.model.PostCommentStruct;
import com.ujs.stupool.model.ChildrenComment;
import com.ujs.stupool.model.response.PostBasicInfo;
import com.ujs.stupool.model.response.PostDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostsMapper {
    int insertPost(Post post);
    int insertComment(PostComment comment);
    List<PostBasicInfo> getHotPost();
    PostDetail getPostDetailById(int id);
    List<PostCommentStruct> getPostComByPostId(int id);
    List<ChildrenComment> getPostComChildByParent(int parent);
    List<PostBasicInfo> getPostBySubarea(@Param("subarea") String subarea,@Param("currentPage") int currentPage, @Param("PageSize") int PageSize);
    int addPostPictures (@Param("urls") List<String> urls,@Param("postId") int id);
    List<String> getPostPics(@Param("post_id") int pid);
    List<PostBasicInfo> getAllMyPosts(@Param("userid") int userid,@Param("currentPage") int currentPage, @Param("pageSize") int PageSize);

}
