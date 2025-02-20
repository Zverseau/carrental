package moi.projet.carrental.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import moi.projet.carrental.Models.Client;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private Long id;
    private String nomClient;
    private String prenomClient;
    private String adresse;
    private Long telephoneClient;
    private Long numeroCni;

}
