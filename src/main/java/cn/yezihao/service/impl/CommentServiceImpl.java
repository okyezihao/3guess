package cn.yezihao.service.impl;

import cn.yezihao.dao.CommentDao;
import cn.yezihao.entity.Comment;
import cn.yezihao.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    //存放迭代找出的所有子代的集合
    private List<Comment> tempReplys = new ArrayList<>();

    // 查询 评论列表
    public List<Comment> listComment() {
        //查询出父节点
        List<Comment> comments = commentDao.findByParentIdNull(Long.parseLong("-1"));
        for(Comment comment : comments){
            Long id = comment.getId();
            String parentUsername1 = comment.getUsername();
            List<Comment> childComments = commentDao.findByParentIdNotNull(id);
            //查询出子评论
            combineChildren(childComments, parentUsername1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    /**
     * 查询出子评论
     * childComments：所有子评论
     * parentUsername1：父评论的姓名
     */
    private void combineChildren(List<Comment> childComments, String parentUsername1) {
        //判断是否有一级子回复
        if(childComments.size() > 0){
            //循环找出子评论的id
            for(Comment childComment : childComments){
                String parentUsername = childComment.getUsername();
                childComment.setParentUsername(parentUsername1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //查询二级以及所有子集回复
                recursively(childId, parentUsername);
            }
        }
    }

    /**
     * 循环迭代找出子集回复
     * childId：子评论的id
     * parentUsername1：子评论的姓名
     */
    private void recursively(Long childId, String parentUsername1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByReplayId(childId);

        if(replayComments.size() > 0){
            for(Comment replayComment : replayComments){
                String parentUsername = replayComment.getUsername();
                replayComment.setParentUsername(parentUsername1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                //循环迭代找出子集回复
                recursively(replayId,parentUsername);
            }
        }
    }

    //存储评论信息
    public int saveComment(Comment comment) {
        comment.setCreateTime(new Date());
        return commentDao.saveComment(comment);
    }

    // 根据id删除评论
    public int deleteComment(Long id) {
        return commentDao.deleteComment(id);
    }

    // 查询所有数据
    public List<Comment> findAllComment() {
        return commentDao.findAllComment();
    }

    // 通过id查询评论内容
    public Comment findCommentById(Long id) {
        return commentDao.findCommentById(id);
    }

    // 修改评论内容
    public int updateComment(Comment comment) {
       return commentDao.updateComment(comment);
    }

    // 通过名字模糊搜索
    public List<Comment> selectBySearch(String commSearch) {
        return commentDao.selectBySearch(commSearch);
    }

}