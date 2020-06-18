package cn.yezihao.service.impl;

import cn.yezihao.dao.GuessDao;
import cn.yezihao.entity.Guess;
import cn.yezihao.service.GuessService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class GuessServiceImpl implements GuessService {

    @Autowired
    private GuessDao guessDao;

    // 添加 谜语
    public int saveGuess(Guess guess) {
        return guessDao.saveGuess(guess);
    }

    // 删除 谜语
    public int deleteGuess(Integer id) {
        return guessDao.deleteGuess(id);
    }

    // 更新 谜语
    public int updateGuess(Guess guess) {
        return guessDao.updateGuess(guess);
    }

    // 查询 所有数据
    public List<Guess> findAllGuess() {
        return guessDao.findAllGuess();
    }

    // 查询 谜语 ById
    public Guess findGuessById(Integer id) {
        return guessDao.findGuessById(id);
    }

    // 模糊搜索
    public List<Guess> selectBySearch(String search) {
        return guessDao.selectBySearch(search);
    }

    // 模糊全局搜索
    public List<Guess> selectGuess(String guess) {
        return guessDao.selectGuess(guess);
    }

    // 删除多行数据 返回json字符串
    public String delManyGuess(String[] id) {
        for (int i = 0; i < id.length; i++) {
            String n = id[i];
            int t = Integer.parseInt(n);
            System.out.println("谜语删除,id=>[" + t + "] ");
            deleteGuess(t);
        }
        System.out.println("删除谜语数组,id=>[" + JSON.toJSONString(id) + "]");
        return JSON.toJSONString(id);
    }

}
