package moi.projet.carrental.Controllers;

import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.FactureDTO;
import moi.projet.carrental.DTO.VoitureDTO;
import moi.projet.carrental.Services.FactureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/carrental/facture")
public class FactureController {

    private final FactureService factureService;

    // Ajouter une facture
    @PostMapping("/ajouterFacture")
    public ResponseEntity<FactureDTO> facturer(@RequestBody FactureDTO factureDTO) {
        return ResponseEntity.ok(factureService.facturer(factureDTO));
    }

    // Modifier une facture
    @PutMapping("/updtFacture/{id}")
    public ResponseEntity<FactureDTO> updtFacture(@PathVariable Long id, @RequestBody FactureDTO factureDTO) {
        return ResponseEntity.ok(factureService.updtFacture(id, factureDTO));
    }

    // Lister toutes les factures
    @GetMapping("/listeFacture")
    public ResponseEntity<List<FactureDTO>> getAllFacture() {
        return ResponseEntity.ok(factureService.getAllFacture());
    }

    // get une voiture by id
    @GetMapping("/getFactureById/{id}")
    public  ResponseEntity<FactureDTO> getFactureById(@PathVariable Long id){
        return ResponseEntity.ok(factureService.getFactureById(id));
    }

    // Supprimer une facture
    @DeleteMapping("/delFacture/{id}")
    public ResponseEntity<Void> deleteFacture(@PathVariable Long id) {
        factureService.deleteFacture(id);
        return ResponseEntity.noContent().build();
    }
}
