package cn.yezihao.dao;

import cn.yezihao.entity.Guess;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface GuessDao {

    // 查询所有数据
    List<Guess> findAllGuess();

    // 添加一个谜语
    int saveGuess(Guess guess);

    // 根据谜语id 删除谜语
    int deleteGuess(@Param("id") Integer id);

    // 通过id查询谜语
    Guess findGuessById(@Param("id") Integer id);

    // 修改评论内容
    int updateGuess(Guess guess);

    // 模糊搜索
    List<Guess> selectBySearch(@Param("search") String search);

    // 通过回答模糊搜索
    List<Guess> selectGuess(@Param("guess") String guess);

}
