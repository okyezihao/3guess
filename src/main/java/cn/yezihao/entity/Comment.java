package cn.yezihao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Comment {
    // 评论id
    private Long id;
    // 用户名
    private String username;
    // 邮箱
    private String email;
    // 内容
    private String content;
    // 创建日期
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 父评论id
    private Long parentCommentId;
    // 子评论集合
    private List<Comment> replyComments = new ArrayList<>();
    // 父评论
    private Comment parentComment;
    // 父评论用户名
    private String parentUsername;

    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", content='" + content + '\'' +
                ", createTime=" + createTime +
                ", parentCommentId=" + parentCommentId +
                ", replyComments=" + replyComments +
                ", parentComment=" + parentComment +
                ", parentUsername='" + parentUsername + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(Long parentCommentId) {
        this.parentCommentId = parentCommentId;
    }

    public List<Comment> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<Comment> replyComments) {
        this.replyComments = replyComments;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public String getParentUsername() {
        return parentUsername;
    }

    public void setParentUsername(String parentUsername) {
        this.parentUsername = parentUsername;
    }

    public Comment() {
    }

    public Comment(Long id, String username, String email, String content, Date createTime, Long parentCommentId, List<Comment> replyComments, Comment parentComment, String parentUsername) {

        this.id = id;
        this.username = username;
        this.email = email;
        this.content = content;
        this.createTime = createTime;
        this.parentCommentId = parentCommentId;
        this.replyComments = replyComments;
        this.parentComment = parentComment;
        this.parentUsername = parentUsername;
    }

}
