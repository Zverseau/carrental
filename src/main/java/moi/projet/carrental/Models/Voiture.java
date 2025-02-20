package moi.projet.carrental.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Voiture extends AuditTable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomVoiture;
    private String marque;
    private String typeVoiture;
    private String typeMoteur;
    private String anneeFabrication;
    private int kilometrage;
    private int nombreDisponible;

    @JsonIgnore
    @OneToMany(mappedBy = "voitureReserve", cascade = CascadeType.ALL)
    private List<Reservation> reservations;
}
