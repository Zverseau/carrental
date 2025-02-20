package moi.projet.carrental.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation extends AuditTable implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double prixParJour;
    private int nombreVoitureReserve;
    private LocalDate dateReservation;
    private LocalDate dateRetour;

    @ManyToOne
    @JoinColumn(name = "voiture_id", nullable = false)
    @JsonBackReference
    private Voiture voitureReserve;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    @JsonBackReference
    private Client client;
}
