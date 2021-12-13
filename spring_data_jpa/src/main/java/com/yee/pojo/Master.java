package com.yee.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: Master
 * Description:
 * date: 2021/12/13 19:06
 * 多对多关系
 * @author Yee
 * @since JDK 1.8
 */
@Entity
@Table(name = "sys_user")
public class Master implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="age")
    private Integer age;

    //配置多对多的关系,第二个参数表示级联操作
    @ManyToMany(targetEntity = Role.class,cascade = CascadeType.ALL)
    //name中间表名字,joinColumns配置中间表外键,inverseJoinColumns配置引用的另一个表
    @JoinTable(name = "sys_user_role",joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "role_id")})
    private Set<Role> roles = new HashSet<>();

    public Master() {
    }

    public Master(Long userId, String userName, Integer age, Set<Role> roles) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.roles = roles;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "Master{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", age=" + age +
                ", roles=" + roles +
                '}';
    }
}
