package cn.yezihao.entity;

// 谜语实体类
public class Guess {
    private Integer id;
    private String question;
    private String answer;
    private Integer groupid;

    public String toString() {
        return "Guess{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", groupid=" + groupid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Guess(Integer id, String question, String answer, Integer groupid) {
        this.id = id;
        this.question = question;
        this.answer = answer;
        this.groupid = groupid;
    }

    public Guess() {
    }

}


