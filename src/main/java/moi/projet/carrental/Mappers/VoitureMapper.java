package moi.projet.carrental.Mappers;


import moi.projet.carrental.DTO.VoitureDTO;
import moi.projet.carrental.Models.Voiture;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface VoitureMapper {

    VoitureDTO toDTO(Voiture voiture);
    Voiture toEntity(VoitureDTO voitureDTO);


}
