package com.ujs.stupool.model;

import java.util.List;

public class PostCommentStruct extends PostComment{
    String avatar;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    List<PostComment> children;

    public List<PostComment> getChildren() {
        return children;
    }

    public void setChildren(List<PostComment> children) {
        this.children = children;
    }
}
