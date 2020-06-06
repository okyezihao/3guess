package cn.yezihao.controller;

import cn.yezihao.entity.Guess;
import cn.yezihao.service.GuessService;
import cn.yezihao.util.LayuiTypeJson;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class GuessController {

    @Autowired
    private GuessService guessService;

    // 返回 admin谜语列表
    @GetMapping("/admin/guessList")
    @ResponseBody
    public LayuiTypeJson<Guess> findAllGuess() {
        List<Guess> list = guessService.findAllGuess();
        LayuiTypeJson<Guess> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
//        System.out.println("admin谜语列表加载成功...");
        return json;
    }

    // 弹出层 跳转 添加表单
    @RequestMapping("/admin/toAAddForm")
    public String toAAddForm() {
        return "admin/GuessAddForm";
    }

    // 弹出层 提交 增加谜语
    @PostMapping("/admin/addGuess")
    @ResponseBody
    public int addGuess(Guess guess) {
        System.out.println("插入Guess=>[" + guess + "]");
        guessService.saveGuess(guess);
        return 200;
    }

    // 弹出层 跳转 更新谜语
    @RequestMapping("/admin/toAUpdateForm/{id}")
    public String updateForm(@PathVariable("id") Integer id, Model model) {
        Guess guess = guessService.findGuessById(id);
        model.addAttribute("QGuess", guess);
        return "admin/GuessUpdateForm";
    }

    // 弹出层 提交 更新谜语表单
    @RequestMapping("/admin/updateGuess")
    @ResponseBody
    public int updateData(Guess guess) {
        System.out.println("更新Guess=>[" + guess + "]");
        guessService.updateGuess(guess);
        return 200;
    }

    // 删除 行数据
    @RequestMapping("/admin/delGuess/{id}")
    @ResponseBody
    public String delGuess(@PathVariable("id") Integer id) {
        System.out.println("删除一个谜语,id=>[" + id + "]");
        guessService.deleteGuess(id);
        return JSON.toJSONString(id);
    }

    // 删除多行数据 返回json字符串
    @RequestMapping("/admin/delManyGuess")
    @ResponseBody
    public String delManyGuess(@RequestParam("id[]") String[] id) {
        for (int i = 0; i < id.length; i++) {
            String n = id[i];
            int t = Integer.parseInt(n);

            System.out.println("谜语删除,id=>[" + t + "] ");

            guessService.deleteGuess(t);
        }

        System.out.println("删除谜语数组,id=>[" + JSON.toJSONString(id) + "]");

        return JSON.toJSONString(id);
    }

    // 谜语 模糊查询
    @PostMapping("/admin/selectG")
    @ResponseBody
    public LayuiTypeJson<Guess> selectBySearch(@RequestParam("search") String search) {
        List<Guess> guesses = guessService.selectBySearch(search);
        LayuiTypeJson<Guess> json = new LayuiTypeJson<>();
        json.setCount(guesses.size());
        json.setData(guesses);
//        System.out.println("搜索谜语数据列表=>" + guesses);
        return json;
    }

    // 返回 index谜语列表
    @GetMapping("/guessList")
    @ResponseBody
    public LayuiTypeJson<Guess> findAll() {
        List<Guess> list = guessService.findAllGuess();
        LayuiTypeJson<Guess> json = new LayuiTypeJson<>();
        json.setCount(list.size());
        json.setData(list);
//        System.out.println("index谜语列表加载成功...");
        return json;
    }

    // 全局搜索
    @RequestMapping("/searchGuess")
    @ResponseBody
    public LayuiTypeJson<Guess> searchGuess(@RequestParam("guess") String guess) {
        List<Guess> guesses = guessService.selectGuess(guess);
        LayuiTypeJson<Guess> json = new LayuiTypeJson<>();
        json.setCount(guesses.size());
        json.setData(guesses);
//        System.out.println("搜索谜语数据列表=>" + guesses);
        return json;
    }

    // 首页轮播
    @RequestMapping("/carousel")
    @ResponseBody
    public Map<String, Object> carousel(@RequestParam("num") int num) throws JsonProcessingException {
        // 接收前端 num
//        System.out.println("前端接收num: "+num);
        // 查询所有谜语
        List<Guess> allGuess = guessService.findAllGuess();
        // 万能的 map
        Map<String,Object> map = new HashMap<>();
        // 所有谜语总数
        int total = allGuess.size();
//        System.out.println("后端谜语数据总数=>[" + total + "]");
        map.put("total",total);
        map.put("list",allGuess);
        return map;
    }

}