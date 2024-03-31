package com.example.tp2;

import com.example.tp2.entities.*;
import com.example.tp2.repositories.ConsultationRepository;
import com.example.tp2.repositories.MedcinRepository;
import com.example.tp2.repositories.PatientRepository;
import com.example.tp2.repositories.RendezVousRepository;
import com.example.tp2.services.IHospitalService;
import com.example.tp2.services.UserServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2Application {

    public static void main(String[] args) {

        SpringApplication.run(Tp2Application.class, args);
    }
   @Bean //executé au demarrage
    CommandLineRunner start(IHospitalService hospitalService, PatientRepository patientRepository,
                            MedcinRepository medcinRepository,
                            RendezVousRepository rendezVousRepository,
                            UserServiceImpl userService){
        return args ->{
            Stream.of("Mohamed","Hassan","Najat")
                    .forEach(name ->{
                        Patient patient=new Patient();
                        patient.setNom(name);
                        patient.setDateNaissanec(new Date());
                        patient.setMalade(false);
                        hospitalService.savePatient(patient);
                    });
            Stream.of("Aymane","Hanane","Yasmine")
                    .forEach(name ->{
                        Medcin medcin=new Medcin();
                        medcin.setNom(name);
                        medcin.setEmail(name+"@gmail.com");
                        medcin.setSpecialite(Math.random()>0.5?"Cadio":"Dentiste");
                        hospitalService.saveMedcin(medcin);
                    });
            Patient patient=patientRepository.findById(1L).orElse(null);
            Patient patient1=patientRepository.findByNom("Mohamed");
            Medcin medcin=medcinRepository.findByNom("Yasmine");
            RendezVous rendezVous=new RendezVous();
            rendezVous.setDate(new Date());
            rendezVous.setStatus(StatusRDV.PENDING);
            rendezVous.setMedcin(medcin);
            rendezVous.setPatient(patient);
            RendezVous saveRDV= hospitalService.saveRDV(rendezVous);
            System.out.println(saveRDV.getId());
            RendezVous rendezVous1=rendezVousRepository.findAll().get(0);
            Consultation consultation=new Consultation();
            consultation.setDateConsultation(new Date());
            consultation.setRendezVous(rendezVous1);
            consultation.setRapport("Rapport de la consultation ....");
            hospitalService.saveConsultation(consultation);

            User user1=new User();
            user1.setUsername("user1");
            user1.setPassword("12334");
            userService.addNewUser(user1);

            User user2=new User();
            user2.setUsername("Admin");
            user2.setPassword("admin");
            userService.addNewUser(user2);

            Stream.of("STUDENT","USER","ADMIN")
                    .forEach(r ->{
            Role role1=new Role();
            role1.setRoleName(r);
            userService.addNewRole(role1);
                    });
            userService.addRoleToUser("user1","STUDENT");
            userService.addRoleToUser("user1","USER");
            userService.addRoleToUser("Admin","ADMIN");
        try {
            User user=userService.authenticate("user1","12334");
            System.out.println(user.getUserId());
            System.out.println(user.getUsername());
            System.out.println("Roles =>");
            user.getRoles().forEach(r->{
                System.out.println("Role => "+r.toString());
            });
        }
        catch (Exception exception){
            exception.printStackTrace();
        }
        };
}


}
