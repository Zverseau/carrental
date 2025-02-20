package moi.projet.carrental.Repositories;

import moi.projet.carrental.Models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FactureRepository extends JpaRepository<Facture, Long> {
}
