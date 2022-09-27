package com.star.bean;

import java.util.List;

/* 角色表 */
public class Role {
    private Integer id;
    private String rolename;
    private String roleDesc;

    //代表当前角色所拥有的用户
    private List<User> userList;


    public Role() {
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", rolename='" + rolename + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", userList=" + userList +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
