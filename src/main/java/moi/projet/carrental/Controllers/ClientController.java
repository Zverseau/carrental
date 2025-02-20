package moi.projet.carrental.Controllers;

import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.ClientDTO;
import moi.projet.carrental.Services.CLientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/carrental/client")
public class ClientController {

    private final CLientService clientService;

    // Ajouter un client
    @PostMapping("/ajouterClient")
    public ResponseEntity<ClientDTO> ajouterClient(@RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.ajouterClient(clientDTO));
    }

    // Modifier un client
    @PutMapping("/updtClient/{id}")
    public ResponseEntity<ClientDTO> updtClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        return ResponseEntity.ok(clientService.updtClient(id, clientDTO));
    }

    // get un client by id
    @GetMapping("/getClientById/{id}")
    public  ResponseEntity<ClientDTO> getClientById(@PathVariable Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    // Récupérer tous les clients
    @GetMapping("/getAllClient")
    public ResponseEntity<List<ClientDTO>> getAllClient() {
        return ResponseEntity.ok(clientService.getAllClient());
    }

    // Supprimer un client
    @DeleteMapping("/delClient/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        clientService.deleteClient(id);
        return ResponseEntity.noContent().build();
    }
}
