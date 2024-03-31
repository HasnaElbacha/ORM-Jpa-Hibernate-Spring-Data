package com.example.tp2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date dateNaissanec ;
    private boolean malade;
    private int score;
    @OneToMany(mappedBy="patient",fetch=FetchType.LAZY)
    private Collection<RendezVous> rendezVous;
}
