package moi.projet.carrental.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.FactureDTO;
import moi.projet.carrental.DTO.VoitureDTO;
import moi.projet.carrental.Mappers.FactureMapper;
import moi.projet.carrental.Models.Client;
import moi.projet.carrental.Models.Facture;
import moi.projet.carrental.Models.SatutResevation;
import moi.projet.carrental.Models.Voiture;
import moi.projet.carrental.Repositories.ClientRepository;
import moi.projet.carrental.Repositories.FactureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class FactureService {
    private final FactureRepository factureRepository;
    private final ClientRepository clientRepository;
    private final FactureMapper factureMapper;


    //Facturer
    public FactureDTO facturer(FactureDTO factureDTO){
        Facture facture = factureMapper.toEntity(factureDTO);
        facture = factureRepository.save(facture);
        return factureMapper.toDTO(facture);
    }

    //Modifier une facture
    public FactureDTO updtFacture(long id, FactureDTO factureDTO) {
        Facture facture = factureRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cette facture n'existe pas"));

        Client client = clientRepository.findById(factureDTO.getClient().getId())
                .orElseThrow(() -> new IllegalArgumentException("Client non trouvé"));
        facture.setClient(client);
        facture.setDateFacture(factureDTO.getDateFacture());
        facture.setMontantTotal(factureDTO.getMontantTotal());
        facture.setStatutReglement(SatutResevation.valueOf(factureDTO.getStatutReglement()));

        Facture updatedFacture = factureRepository.save(facture);
        return factureMapper.toDTO(updatedFacture);
    }

    //Lister toutes les factures
    public List<FactureDTO>getAllFacture(){
        return factureRepository.findAll().stream().map(factureMapper::toDTO).collect(Collectors.toList());
    }

    //Recuperer une facture par id
    public FactureDTO getFactureById(Long id){
        Facture facture = factureRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cette facture n'exite pas."));
        return factureMapper.toDTO(facture);
    }

    //Supprimer une facture
    public void deleteFacture(Long id){
        if(!factureRepository.existsById(id)){
            throw new IllegalArgumentException("Cette facture n'existe pas.");
        }
        factureRepository.deleteById(id);
    }
}
