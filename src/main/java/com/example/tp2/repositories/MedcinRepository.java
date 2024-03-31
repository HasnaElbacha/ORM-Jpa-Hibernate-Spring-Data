package com.example.tp2.repositories;

import com.example.tp2.entities.Medcin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedcinRepository extends JpaRepository<Medcin,Long> {
Medcin findByNom(String name);
}
