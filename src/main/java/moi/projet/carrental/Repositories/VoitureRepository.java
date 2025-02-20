package moi.projet.carrental.Repositories;

import moi.projet.carrental.Models.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoitureRepository extends JpaRepository<Voiture, Long> {
    Optional<Voiture> findByNomVoiture(String nomVoiture);
}
