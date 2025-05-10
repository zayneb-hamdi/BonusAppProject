package com.bonusapp.backend.Repository;

import com.bonusapp.backend.Entity.BonusAttribution;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BonusAttributionRepository extends JpaRepository<BonusAttribution, Long> {
    List<BonusAttribution> findByEtudiantId(Long etudiantId);
    List<BonusAttribution>findByEtudiantEmail(String etudiantEmail);
}
