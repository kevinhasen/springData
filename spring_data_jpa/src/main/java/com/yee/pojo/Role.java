package com.yee.pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * ClassName: Role
 * Description:
 * date: 2021/12/13 19:11
 *
 * @author Yee
 * @since JDK 1.8
 */
@Entity
@Table(name = "sys_role")
public class Role implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long roleId;
    @Column(name = "role_name")
    private String roleName;
    //配置多对多
    @ManyToMany(mappedBy = "roles")
    private Set<Master> users = new HashSet<>();

    public Role() {
    }

    public Role(Long roleId, String roleName, Set<Master> users) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.users = users;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Master> getUsers() {
        return users;
    }

    public void setUsers(Set<Master> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", users=" + users +
                '}';
    }
}
