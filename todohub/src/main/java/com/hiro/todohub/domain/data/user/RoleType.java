package com.hiro.todohub.domain.data.user;

public enum RoleType {
    ADMIN(1L),
    BASIC(2L);

    private long roleId;

    private RoleType(long roleId) {
        this.roleId = roleId;
    }

    public long getRoleId() {
        return roleId;
    }
}