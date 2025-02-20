package moi.projet.carrental.Controllers;


import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.VoitureDTO;
import moi.projet.carrental.Services.VoitureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/carrental/voiture")
public class VoitureController {

    private final VoitureService voitureService;

    // Ajouter une voiture
    @PostMapping("/ajouterVoiture")
    public ResponseEntity<VoitureDTO> ajouterVoiture(@RequestBody VoitureDTO voitureDTO){
        return ResponseEntity.ok(voitureService.ajouterVoiture(voitureDTO));
    }

    //Update une Voiture
    @PutMapping("/updtVoiture/{id}")
    public ResponseEntity<VoitureDTO> updateVoiture(@RequestBody VoitureDTO voitureDTO, @PathVariable Long id){
        return ResponseEntity.ok(voitureService.updateVoiture(id, voitureDTO));

    }

    // get une voiture by id
    @GetMapping("/getVoitureById/{id}")
    public  ResponseEntity<VoitureDTO> getVoitureById( @PathVariable Long id){
        return ResponseEntity.ok(voitureService.getVoitureById(id));
    }

    // get toutes les voitures
    @GetMapping("/getAllVoiture")
    public  ResponseEntity<List<VoitureDTO>> getAllVoiture(){
        return ResponseEntity.ok(voitureService.getAllVoiture());
    }

    //delete voiture by id
    @DeleteMapping("/delVoiture/{id}")
    public  ResponseEntity<Void> deleteVoiture(@PathVariable Long id){
        voitureService.deleteVoiture(id);
        return ResponseEntity.noContent().build();
    }


}
