package tech.getarrays.citoyenmanager.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.getarrays.citoyenmanager.model.Citoyen;
import tech.getarrays.citoyenmanager.service.CitoyenService;

import java.util.List;

@RestController
@RequestMapping("/citoyen")
public class CitoyenController {
    private final CitoyenService citoyenService;

    public CitoyenController(CitoyenService citoyenService) {
        this.citoyenService = citoyenService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Citoyen>> getAllCitoyens () {
        List<Citoyen> citoyens = citoyenService.findAllCitoyens();
        return new ResponseEntity<>(citoyens, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Citoyen> getCitoyenById (@PathVariable("id") Long id) {
        Citoyen citoyen = citoyenService.findCitoyenById(id);
        return new ResponseEntity<>(citoyen, HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Citoyen> addCitoyen(@RequestBody Citoyen citoyen) {
        Citoyen newCitoyen = citoyenService.addCitoyen(citoyen);
        return new ResponseEntity<>(newCitoyen, HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<Citoyen> login(@RequestBody Citoyen citoyen) {
        Citoyen authenticatedCitoyen = citoyenService.login(citoyen.getEmail(), citoyen.getPassword());
        return new ResponseEntity<>(authenticatedCitoyen, HttpStatus.OK);
    }



    @PutMapping("/update")
    public ResponseEntity<Citoyen> updateCitoyen(@RequestBody Citoyen citoyen) {
        Citoyen updateCitoyen = citoyenService.updateCitoyen(citoyen);
        return new ResponseEntity<>(updateCitoyen, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCitoyen(@PathVariable("id") Long id) {
        citoyenService.deleteCitoyen(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
