package onet.grupa.isrentalapplication.controller.rentals;

import onet.grupa.isrentalapplication.domain.rentals.ComputerRental;
import onet.grupa.isrentalapplication.service.rentals.ComputerRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rentals/computers/")
public class ComputerRentalController {

    private ComputerRentalService computerRentalService;

    @Autowired
    public ComputerRentalController(ComputerRentalService computerRentalService){
        this.computerRentalService = computerRentalService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComputerRental>> getRentals(@RequestParam(required = false) String searchPhrase, @RequestParam(required = false) String orderBy){
        if(searchPhrase != null && !searchPhrase.isEmpty())
            return ResponseEntity.ok(computerRentalService.getSpecificComputerRentals(searchPhrase,orderBy));

        return ResponseEntity.ok(computerRentalService.getAllComputerRentals());
    }

    @GetMapping(path = "rentals/computers/status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ComputerRental>> getRentalsWithStatus(@PathVariable String status){
        return ResponseEntity.ok(computerRentalService.getAllComputerRentalsWithStatus(status));
    }

}
