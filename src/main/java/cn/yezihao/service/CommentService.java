package cn.yezihao.service;

import cn.yezihao.entity.Comment;

import java.util.List;

public interface CommentService {

    // 保存 评论
    int saveComment(Comment comment);

    // 删除 评论
    int deleteComment(Long id);

    // 修改 评论
    int updateComment(Comment comment);

    // 查询 所有数据
    List<Comment> findAllComment();

    // 查询 评论列表
    List<Comment> listComment();

    // 查询 评论 ById
    Comment findCommentById(Long id);

    // 模糊搜索
    List<Comment> selectBySearch(String commSearch);

}