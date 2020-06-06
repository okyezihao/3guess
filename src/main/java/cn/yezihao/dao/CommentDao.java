package cn.yezihao.dao;

import cn.yezihao.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentDao {

    // 添加一个评论
    int saveComment(Comment comment);

    // 查询 父级评论 , 通过父id
    List<Comment> findByParentIdNull(@Param("ParentId") Long ParentId);

    // 查询 一级回复
    List<Comment> findByParentIdNotNull(@Param("id") Long id);

    // 查询二级以及所有 子集回复
    List<Comment> findByReplayId(@Param("childId") Long childId);

    // 根据评论id 删除评论
    int deleteComment(@Param("id") Long id);

    // 查询所有数据
    List<Comment> findAllComment();

    // 通过id查询评论内容
    Comment findCommentById(@Param("id") Long id);

    // 修改评论内容
    int updateComment(Comment comment);

    // 通过名字模糊搜索
    List<Comment> selectBySearch(@Param("commSearch") String commSearch);

}