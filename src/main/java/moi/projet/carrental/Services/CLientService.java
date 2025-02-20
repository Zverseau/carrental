package moi.projet.carrental.Services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.ClientDTO;
import moi.projet.carrental.DTO.VoitureDTO;
import moi.projet.carrental.Mappers.ClientMapper;
import moi.projet.carrental.Models.Client;
import moi.projet.carrental.Models.Voiture;
import moi.projet.carrental.Repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CLientService {
    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;


    //Ajouter un client
    public ClientDTO ajouterClient(ClientDTO clientDTO){
        Client client = clientMapper.toEntity(clientDTO);
        client = clientRepository.save(client);
        return clientMapper.toDTO(client);
    }

    //Modifier un client
    public ClientDTO updtClient(Long id, ClientDTO clientDTO){
        Client client = clientRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ce client n'existe pas"));
        client.setNomClient(clientDTO.getNomClient());
        client.setPrenomClient(clientDTO.getPrenomClient());
        client.setTelephoneClient(clientDTO.getTelephoneClient());
        client.setAdresse(clientDTO.getAdresse());
        client.setNumeroCni(clientDTO.getNumeroCni());
        Client updtClient = clientRepository.save(client);
        return clientMapper.toDTO(updtClient);
    }


    //Recuperer un client par id
    public ClientDTO getClientById(Long id){
        Client client = clientRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("Ce client n'exite pas."));
        return clientMapper.toDTO(client);
    }

    //Recuperer toute la liste des clients

    public List<ClientDTO> getAllClient(){
        return clientRepository.findAll().stream().map(clientMapper::toDTO).collect(Collectors.toList());
    }


    //Delete un client
    public void deleteClient(Long id){
        if(!clientRepository.existsById(id)){
            throw new IllegalArgumentException("ce client n'existe pas");
        }
         clientRepository.deleteById(id);
    }
}
