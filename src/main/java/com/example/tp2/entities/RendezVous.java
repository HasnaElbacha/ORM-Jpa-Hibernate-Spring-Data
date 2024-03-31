package com.example.tp2.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class RendezVous {
    @Id
    private String id;
    private Date date;
    @Enumerated(EnumType.STRING)
    private StatusRDV status;
    @ManyToOne
    @JsonProperty(access =JsonProperty.Access.WRITE_ONLY)
    private Patient patient;
    @ManyToOne
    private Medcin medcin;
    @OneToOne(mappedBy="rendezVous",fetch=FetchType.LAZY)
    private Consultation consultation;
}
