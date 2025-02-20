package moi.projet.carrental.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import moi.projet.carrental.Models.Client;
import moi.projet.carrental.Models.Facture;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FactureDTO {
    private Long id;
    private Client client;
    private LocalDate dateFacture;
    private double montantTotal;
    private String statutReglement;

    public FactureDTO(Facture facture) {
        this.id = facture.getId();
        this.client = facture.getClient();
        this.dateFacture = facture.getDateFacture();
        this.montantTotal = facture.getMontantTotal();
        this.statutReglement = facture.getStatutReglement().name();
    }
}
