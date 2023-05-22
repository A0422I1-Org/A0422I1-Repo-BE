package com.example.demo.service.account;

public interface IRoleService {

    /**
     * Pham Trung Hieu
     * @param username
     * @param roleId
     */
    void setDefaultRole(String username, boolean isDelete, int roleId);

    String getRole(int roleId);
}
