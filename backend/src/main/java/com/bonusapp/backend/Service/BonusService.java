package com.bonusapp.backend.Service;

import com.bonusapp.backend.Entity.BonusAttribution;
import com.bonusapp.backend.Entity.Etudiant;
import com.bonusapp.backend.Entity.Professeur;
import com.bonusapp.backend.Repository.EtudiantRepository;
import com.bonusapp.backend.Repository.ProfesseurRepository;
import com.bonusapp.backend.Repository.BonusAttributionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BonusService {
    @Autowired
    private EtudiantRepository etudiantRepo;
    @Autowired
    private BonusAttributionRepository attributionRepo;
    @Autowired
    private ProfesseurRepository profRepo;

    public Etudiant ajouterBonus(Long idEtudiant, int points, Long professeurId) {
        Etudiant e = etudiantRepo.findById(idEtudiant).orElseThrow();
        e.setBonus(e.getBonus() + points);
        Professeur p = profRepo.findById(professeurId).orElseThrow();
        BonusAttribution attribution = new BonusAttribution(e, p, points, LocalDateTime.now());
        attributionRepo.save(attribution);
        etudiantRepo.save(e);
        return e;
    }

    public void appliquerReductionFrais() {
        List<Etudiant> etudiants = etudiantRepo.findAll();
        for (Etudiant e : etudiants) {
            int reduction = calculerReduction(e.getBonus());
            e.setFraisInscription(e.getFraisInscription() - reduction);
        }
        etudiantRepo.saveAll(etudiants);
    }

    private int calculerReduction(int bonus) {
        return bonus * 2; // Exemple : chaque point bonus = 10 dt de réduction
    }
}
