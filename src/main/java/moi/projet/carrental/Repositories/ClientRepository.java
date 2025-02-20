package moi.projet.carrental.Repositories;

import moi.projet.carrental.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByNomClientAndPrenomClient(String nomClient, String prenomClient);

}
