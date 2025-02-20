package moi.projet.carrental.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.ReservationDTO;
import moi.projet.carrental.Mappers.ReservationMapper;
import moi.projet.carrental.Models.Reservation;
import moi.projet.carrental.Models.Client;
import moi.projet.carrental.Models.Voiture;
import moi.projet.carrental.Repositories.ReservationRepository;
import moi.projet.carrental.Repositories.ClientRepository;
import moi.projet.carrental.Repositories.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class ReservationService {
    private final ReservationMapper reservationMapper;
    private final ReservationRepository reservationRepository;
    private final ClientRepository clientRepository;
    private final VoitureRepository voitureRepository;

    // Ajouter une nouvelle réservation
    public ReservationDTO reserver(ReservationDTO reservationDTO) {
        Reservation reservation = reservationMapper.toEntity(reservationDTO);

        // Vérifier et associer le client
        Client client = clientRepository.findById(reservationDTO.getClient().getId())
                .orElseThrow(() -> new IllegalArgumentException("Client non trouvé"));
        reservation.setClient(client);

        // Vérifier et associer la voiture
        Voiture voiture = voitureRepository.findById(reservationDTO.getVoitureReserve().getId())
                .orElseThrow(() -> new IllegalArgumentException("Voiture non trouvée"));
        reservation.setVoitureReserve(voiture);

        reservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(reservation);
    }

    // Mettre à jour une réservation
    public ReservationDTO updateReservation(Long id, ReservationDTO reservationDTO) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pas de réservation trouvée"));

        reservation.setDateReservation(reservationDTO.getDateReservation());
        reservation.setDateRetour(reservationDTO.getDateRetour());
        reservation.setPrixParJour(reservationDTO.getPrixParJour());
        reservation.setNombreVoitureReserve(reservationDTO.getNombreVoitureReserve());

        // Mettre à jour le client associé (si nécessaire)
        if (reservationDTO.getClient() != null) {
            Client client = clientRepository.findById(reservationDTO.getClient().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Client non trouvé"));
            reservation.setClient(client);
        }

        // Mettre à jour la voiture associée (si nécessaire)
        if (reservationDTO.getVoitureReserve() != null) {
            Voiture voiture = voitureRepository.findById(reservationDTO.getVoitureReserve().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Voiture non trouvée"));
            reservation.setVoitureReserve(voiture);
        }

        Reservation updatedReservation = reservationRepository.save(reservation);
        return reservationMapper.toDTO(updatedReservation);
    }

    // Récupérer une réservation par son ID
    public ReservationDTO getReservationById(Long id) {
        Reservation reservation = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("La réservation n'existe pas"));
        return reservationMapper.toDTO(reservation);
    }

    // Lister toutes les réservations
    public List<ReservationDTO> getAllReservation() {
        return reservationRepository.findAll().stream()
                .map(reservationMapper::toDTO)
                .collect(Collectors.toList());
    }

    // Supprimer une réservation
    public void deleteReservation(Long id) {
        if (!reservationRepository.existsById(id)) {
            throw new IllegalArgumentException("Cette réservation n'existe pas.");
        }
        reservationRepository.deleteById(id);
    }
}
