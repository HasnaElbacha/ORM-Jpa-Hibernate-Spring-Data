package com.example.tp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "DESCRIPTION")
    private String desc;
    @Column(length=20,unique = true)
    private String roleName;
    @ManyToMany(fetch= FetchType.EAGER)
    //@JoinTable(name="USERS_ROLES")
    @ToString.Exclude
    private List<User> users=new ArrayList<>();
}
