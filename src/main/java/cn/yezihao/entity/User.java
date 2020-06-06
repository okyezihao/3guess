package cn.yezihao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

// 用户实体类
public class User {
    private Integer id;
    private String username;
    private String password;
    private String role;
    // 男: 0 , 女: 1
    private Integer gender;
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cdate;

    public User() {
    }

    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", cdate=" + cdate +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public User(Integer id, String username, String password, String role, Integer gender, String email, Date cdate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.gender = gender;
        this.email = email;
        this.cdate = cdate;
    }

}