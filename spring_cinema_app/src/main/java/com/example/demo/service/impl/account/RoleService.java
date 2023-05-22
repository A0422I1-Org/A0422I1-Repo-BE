package com.example.demo.service.impl.account;

import com.example.demo.repository.account.IRoleRepository;


import com.example.demo.service.account.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {

    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public void setDefaultRole(String username, boolean isDelete, int roleId) {
        roleRepository.setDefaultRole(username, isDelete, roleId);
    }

    @Override
    public String getRole(int roleId) {
        return roleRepository.getRole(roleId);
    }

}
