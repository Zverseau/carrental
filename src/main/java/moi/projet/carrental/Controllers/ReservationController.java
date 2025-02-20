package moi.projet.carrental.Controllers;


import lombok.AllArgsConstructor;
import moi.projet.carrental.DTO.ReservationDTO;
import moi.projet.carrental.DTO.VoitureDTO;
import moi.projet.carrental.Services.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/carrental/reservation")
public class ReservationController {

    private final ReservationService reservationService;



    // Ajouter une voiture
    @PostMapping("/reserver")
    public ResponseEntity<ReservationDTO> reserver(@RequestBody ReservationDTO reservationDTO){
        return ResponseEntity.ok(reservationService.reserver(reservationDTO));
    }

    //Update une Reservation
    @PutMapping("/updtReservation/{id}")
    public ResponseEntity<ReservationDTO> updateReservation(@RequestBody ReservationDTO reservationDTO, @PathVariable Long id){
        return ResponseEntity.ok(reservationService.updateReservation(id, reservationDTO));

    }

    // get une reservation by id
    @GetMapping("/getReservationById/{id}")
    public  ResponseEntity<ReservationDTO> getReservationById( @PathVariable Long id){
        return ResponseEntity.ok(reservationService.getReservationById(id));
    }

    // get toutes les reservations
    @GetMapping("/getAllReservation")
    public  ResponseEntity<List<ReservationDTO>> getAllReservation(){
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    //delete reservation by id
    @DeleteMapping("/delReservation/{id}")
    public  ResponseEntity<Void> deleteReservation(@PathVariable Long id){
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }


}
