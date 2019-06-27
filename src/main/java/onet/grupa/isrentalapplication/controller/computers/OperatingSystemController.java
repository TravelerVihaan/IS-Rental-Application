package onet.grupa.isrentalapplication.controller.computers;

import onet.grupa.isrentalapplication.domain.computers.OperatingSystem;
import onet.grupa.isrentalapplication.service.computers.OperatingSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/computers/os")
public class OperatingSystemController {

    private OperatingSystemService operatingSystemService;

    @Autowired
    public OperatingSystemController(onet.grupa.isrentalapplication.service.computers.OperatingSystemService operatingSystemService){
        this.operatingSystemService = operatingSystemService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<OperatingSystem>> getAllOperatingSystems(){
        return operatingSystemService.getResponseWithAllOperatingSystems();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperatingSystem> getOperatingSystem(@PathVariable long id){
        return operatingSystemService.getResponseWithOperatingSystem(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addOperatingSystem(@RequestBody @Valid OperatingSystem operatingSystem, BindingResult result){
        return operatingSystemService.addNewOperatingSystem(operatingSystem, result);
    }
}
