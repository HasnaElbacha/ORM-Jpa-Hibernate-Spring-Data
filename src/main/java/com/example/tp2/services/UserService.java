package com.example.tp2.services;

import com.example.tp2.entities.Role;
import com.example.tp2.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findUserByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User authenticate(String userName,String password);
}
