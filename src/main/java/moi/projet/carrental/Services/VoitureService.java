package moi.projet.carrental.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.VoitureDTO;
import moi.projet.carrental.Mappers.VoitureMapper;
import moi.projet.carrental.Models.Voiture;
import moi.projet.carrental.Repositories.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class VoitureService {

    private final VoitureRepository voitureRepository;
    private final VoitureMapper voitureMapper;

    // Ajouter une nouvelle voiture
    public VoitureDTO ajouterVoiture(VoitureDTO voitureDTO) {
        Voiture voiture = voitureMapper.toEntity(voitureDTO);
        voiture = voitureRepository.save(voiture);
        return voitureMapper.toDTO(voiture);
    }

    //Update une voiture

    public VoitureDTO updateVoiture(Long id, VoitureDTO voitureDTO){
        Voiture voiture = voitureRepository.findById(id).orElseThrow(()->new IllegalArgumentException("Cette voiture n'exite pas. "));
        voiture.setNomVoiture(voitureDTO.getNomVoiture());
        voiture.setMarque(voitureDTO.getMarque());
        voiture.setTypeVoiture(voitureDTO.getTypeVoiture());
        voiture.setTypeMoteur(voitureDTO.getTypeMoteur());
        voiture.setAnneeFabrication(voitureDTO.getAnneeFabrication());
        voiture.setKilometrage(voitureDTO.getKilometrage());
        voiture.setNombreDisponible(voitureDTO.getNombreDisponible());
        Voiture updateVoiture = voitureRepository.save(voiture);
        return  voitureMapper.toDTO(updateVoiture);
    }

    //Recuperer une voiture par id
    public VoitureDTO getVoitureById(Long id){
        Voiture voiture = voitureRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Cette voiture n'exite pas."));
        return voitureMapper.toDTO(voiture);
    }

    //Delete une voiture
    public void deleteVoiture(Long id){
        if (!voitureRepository.existsById(id)){
            throw  new IllegalArgumentException("Cette voiture n'exite pas.");
        }
        voitureRepository.deleteById(id);
    }

    //Lister toutes les voitures

    public List<VoitureDTO> getAllVoiture(){
        return  voitureRepository.findAll().stream().map(voitureMapper::toDTO).collect(Collectors.toList());
    }

}
