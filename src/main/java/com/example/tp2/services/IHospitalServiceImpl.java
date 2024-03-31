package com.example.tp2.services;

import com.example.tp2.entities.Consultation;
import com.example.tp2.entities.Medcin;
import com.example.tp2.entities.Patient;
import com.example.tp2.entities.RendezVous;
import com.example.tp2.repositories.ConsultationRepository;
import com.example.tp2.repositories.MedcinRepository;
import com.example.tp2.repositories.PatientRepository;
import com.example.tp2.repositories.RendezVousRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class IHospitalServiceImpl implements IHospitalService {

    private PatientRepository patientRepository;
    private MedcinRepository medcinRepository;
    private RendezVousRepository rendezVousRepository;
    private ConsultationRepository consultationRepository;

    public IHospitalServiceImpl(PatientRepository patientRepository, MedcinRepository medcinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        this.patientRepository = patientRepository;
        this.medcinRepository = medcinRepository;
        this.rendezVousRepository = rendezVousRepository;
        this.consultationRepository = consultationRepository;
    }

    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);

    }

    @Override
    public Medcin saveMedcin(Medcin medcin) {

        return medcinRepository.save(medcin);
    }

    @Override
    public RendezVous saveRDV(RendezVous rendezVous) {
        rendezVous.setId(UUID.randomUUID().toString());
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {

        return consultationRepository.save(consultation);
    }
}
