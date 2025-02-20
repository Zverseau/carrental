package moi.projet.carrental.Repositories;

import moi.projet.carrental.Models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}
