package moi.projet.carrental.Mappers;

import moi.projet.carrental.DTO.ReservationDTO;
import moi.projet.carrental.Models.Reservation;
import moi.projet.carrental.Models.Voiture;
import moi.projet.carrental.Models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ReservationMapper {

    @Mapping(source = "client", target = "client") // Mapper directement l'objet Client
    @Mapping(source = "voitureReserve", target = "voitureReserve") // Mapper directement l'objet Voiture
    ReservationDTO toDTO(Reservation reservation);

    @Mapping(source = "client", target = "client") // Mapper directement l'objet Client
    @Mapping(source = "voitureReserve", target = "voitureReserve") // Mapper directement l'objet Voiture
    Reservation toEntity(ReservationDTO reservationDTO);
}
