package moi.projet.carrental.Mappers;

import moi.projet.carrental.DTO.ClientDTO;
import moi.projet.carrental.Models.Client;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface ClientMapper {

    ClientDTO toDTO(Client client);
     Client toEntity(ClientDTO clientDTO);
}
