package com.example.tp2.services;

import com.example.tp2.entities.Consultation;
import com.example.tp2.entities.Medcin;
import com.example.tp2.entities.Patient;
import com.example.tp2.entities.RendezVous;

public interface IHospitalService {
    public Patient savePatient(Patient patient);
    Medcin saveMedcin(Medcin medcin);
    RendezVous saveRDV(RendezVous rendezVous);
    Consultation saveConsultation(Consultation consultation);
}
