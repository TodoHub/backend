package com.hiro.todohub.domain.data.user;

public class Role {
    private Long roleId;

    private RoleType role;

    public Role() {
    }

    public Role(Long roleId, RoleType role) {
        this.roleId = roleId;
        this.role = role;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }
}