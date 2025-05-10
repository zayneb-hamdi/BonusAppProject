package com.bonusapp.backend.Repository;

import com.bonusapp.backend.Entity.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByEmail(String email);
}
