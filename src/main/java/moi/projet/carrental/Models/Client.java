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
@AllArgsConstructor
@NoArgsConstructor
public class Client extends AuditTable implements Serializable {
 private static final long serialVersionUID = 1L;

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 private String nomClient;
 private String prenomClient;
 private String adresse;
 private Long telephoneClient;
 private Long numeroCni;

 @JsonIgnore
 @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
 private List<Reservation> reservations;

 @JsonIgnore
 @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
 private List<Facture> factures;
}
