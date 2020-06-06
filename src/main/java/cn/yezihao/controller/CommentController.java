package cn.yezihao.controller;

import cn.yezihao.entity.Comment;
import cn.yezihao.entity.User;
import cn.yezihao.service.CommentService;
import cn.yezihao.service.UserService;
import cn.yezihao.util.LayuiTypeJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private UserService userService;

    // 跳转到评论管理页面
    @GetMapping("/admin/toComm")
    public String toComm() {
        return "admin/adminCom";
    }

    // 跳转到评论页面 , 评论信息回显
    @GetMapping("/comment")
    public String comments(Model model) {
        List<Comment> comments = commentService.listComment();
        model.addAttribute("comments", comments);
        return "user/feedback :: commentList";
    }

    // 前端返回数据到后端
    @PostMapping("/comment")
    public String post(Comment comment) {
        // 获得 父评论的id , 不等于空 , 设置其父评论id
        if (comment.getParentComment().getId() != null) {
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        // 根据用户名获取user信息 , 添加email
        User user = userService.selectUserByName(comment.getUsername());
        comment.setEmail(user.getEmail());

        System.out.println("用户评论=>["+comment.getUsername()+"]");

        // 保存评论
        commentService.saveComment(comment);
        return "redirect:/comment";
    }

    // 返回admin评论列表
    @GetMapping("/admin/commList")
    @ResponseBody
    public LayuiTypeJson<Comment> findAllComment() {
        List<Comment> list = commentService.findAllComment();
        LayuiTypeJson<Comment> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
//        System.out.println("评论数据列表加载成功...");
        return json;
    }

    // 弹出层 跳转 修改评论表单
    @RequestMapping("/admin/toCUpdateForm/{id}")
    public String toCUpdateForm(@PathVariable("id") Long id, Model model) {
        Comment comment = commentService.findCommentById(id);
//        System.out.println("获取更新评论数据=>" + comment);
        model.addAttribute("comment", comment);
        return "admin/CommUpdateForm";
    }

    // 弹出层 提交 修改评论表单
    @PostMapping("/admin/UpdateComm")
    @ResponseBody
    public int updateComment(Comment comment) {

        System.out.println("用户评论被修改=>["+comment.getUsername()+"]");

        commentService.updateComment(comment);
        return 200;
    }

    // admin删除 单条评论
    @GetMapping("/admin/delComm/{id}")
    @ResponseBody
    public int delComment(@PathVariable("id") Long id) {

        System.out.println("删除一个评论,id=>[" + id + "]");

        commentService.deleteComment(id);
        return 1;
    }

    // admin删除 多条条评论
    @PostMapping("/admin/delManyComm")
    @ResponseBody
    public int delManyComm(@RequestParam("id[]") String[] id) {

        for (int i = 0; i < id.length; i++) {
            String n = id[i];
            int t = Integer.parseInt(n);
            commentService.deleteComment((long) t);
        }
        return 1;
    }

    // 评论 模糊查询
    @PostMapping("/admin/select")
    @ResponseBody
    public LayuiTypeJson<Comment> selectByUsername(@RequestParam("commSearch") String commSearch) {
        List<Comment> comments = commentService.selectBySearch(commSearch);
        LayuiTypeJson<Comment> json = new LayuiTypeJson<>();
        json.setCount(comments.size());
        json.setData(comments);
//        System.out.println("评论数据列表=>" + comments);
        return json;
    }

}
