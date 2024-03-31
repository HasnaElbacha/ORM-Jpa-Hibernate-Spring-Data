package com.example.tp2.repositories;

import com.example.tp2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
Patient findByNom(String name);
}
