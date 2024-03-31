package com.example.tp2.repositories;

import com.example.tp2.entities.Role;
import com.example.tp2.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RoleRepository  extends JpaRepository<Role,Long> {
    Role findByRoleName(String roleName);
}
