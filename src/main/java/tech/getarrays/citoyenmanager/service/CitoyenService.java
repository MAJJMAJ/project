package tech.getarrays.citoyenmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.citoyenmanager.exception.UserNotFoundException;

import tech.getarrays.citoyenmanager.model.Citoyen;
import tech.getarrays.citoyenmanager.repo.CitoyenRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CitoyenService {
    private final CitoyenRepo citoyenRepo;

    @Autowired
    public CitoyenService(CitoyenRepo citoyenRepo) {
        this.citoyenRepo = citoyenRepo;
    }

    public Citoyen addCitoyen(Citoyen citoyen) {
        return citoyenRepo.save(citoyen);
    }

    public List<Citoyen> findAllCitoyens() {
        return citoyenRepo.findAll();
    }

    public Citoyen updateCitoyen(Citoyen citoyen) {
        return citoyenRepo.save(citoyen);
    }

    public Citoyen findCitoyenById(Long id) {
        return citoyenRepo.findCitoyenById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteCitoyen(Long id){
        citoyenRepo.deleteCitoyenById(id);
    }
    public Citoyen login(String email, String password) {
        Optional<Citoyen> citoyenOptional = citoyenRepo.findByEmailAndPassword(email, password);
        return citoyenOptional.orElse(null);
    }
}
