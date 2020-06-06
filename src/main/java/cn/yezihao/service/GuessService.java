package cn.yezihao.service;

import cn.yezihao.entity.Guess;

import java.util.List;

public interface GuessService {

    // 添加 谜语
    int saveGuess(Guess guess);

    // 删除 谜语
    int deleteGuess(Integer id);

    // 修改 谜语
    int updateGuess(Guess guess);

    // 查询 所有谜语
    List<Guess> findAllGuess();

    // 查询 谜语 ById
    Guess findGuessById(Integer id);

    // 模糊搜索
    List<Guess> selectBySearch(String search);


    // 模糊搜索答案
    List<Guess> selectGuess(String guess);

}
