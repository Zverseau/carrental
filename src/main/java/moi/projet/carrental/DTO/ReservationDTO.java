package moi.projet.carrental.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import moi.projet.carrental.Models.Client;
import moi.projet.carrental.Models.Voiture;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long id;
    private double prixParJour;
    private int nombreVoitureReserve;
    private LocalDate dateReservation;
    private LocalDate dateRetour;
    private Client client; // Stocker directement l'objet Client
    private Voiture voitureReserve; // Stocker directement l'objet Voiture
}
