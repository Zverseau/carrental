package moi.projet.carrental.Mappers;


import moi.projet.carrental.DTO.FactureDTO;
import moi.projet.carrental.Models.Facture;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface FactureMapper {
    FactureDTO toDTO(Facture facture);
    Facture toEntity(FactureDTO factureDTO);
}
