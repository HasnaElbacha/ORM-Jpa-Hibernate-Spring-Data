package com.example.tp2.services;

import com.example.tp2.entities.Role;
import com.example.tp2.entities.User;
import com.example.tp2.repositories.RoleRepository;
import com.example.tp2.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;


    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUsername(userName);
    }

    @Override
    public Role findUserByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new IllegalArgumentException("User not found with username: " + username);
        }

        Role role = roleRepository.findByRoleName(roleName);
        if (role == null) {
            throw new IllegalArgumentException("Role not found with roleName: " + roleName);
        }

        if (user.getRoles() == null) {
            user.setRoles(new ArrayList<>());
        }

        user.getRoles().add(role);
        role.getUsers().add(user);


        // userRepository.save(user);
    }

    @Override
    public User authenticate(String userName, String password) {
        User user=userRepository.findByUsername(userName);
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad credentials");

    }
}
