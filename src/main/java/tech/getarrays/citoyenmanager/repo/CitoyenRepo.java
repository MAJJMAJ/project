package tech.getarrays.citoyenmanager.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.getarrays.citoyenmanager.model.Citoyen;


import java.util.Optional;

public interface CitoyenRepo extends JpaRepository<Citoyen, Long> {
    void deleteCitoyenById(Long id);

    Optional<Citoyen> findCitoyenById(Long id);


    <T> Optional<T> findByEmailAndPassword(String email, String password);
}
