package moi.projet.carrental.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VoitureDTO {
    private Long id;
    private String nomVoiture;
    private String marque ;
    private String typeVoiture;
    private String typeMoteur;
    private String anneeFabrication;
    private int kilometrage;
    private int nombreDisponible;

}
