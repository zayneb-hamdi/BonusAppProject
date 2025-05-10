package com.bonusapp.backend.Controller;

import com.bonusapp.backend.Entity.Etudiant;
import com.bonusapp.backend.Repository.EtudiantRepository;
import com.bonusapp.backend.Service.NotificationService;
import com.bonusapp.backend.Repository.BonusAttributionRepository;
import com.bonusapp.backend.Service.BonusService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {

    @Autowired
    private BonusService bonusService;
    @Autowired private EtudiantRepository etudiantRepo;
    @Autowired private BonusAttributionRepository attributionRepo;
    @Autowired private NotificationService notifService;

    @GetMapping
    public List<Etudiant> getAll(HttpSession session) {
        if (session.getAttribute("professeurId") == null) {
            throw new RuntimeException("Non autorisé");
        }

        return etudiantRepo.findAll();
    }

    @PostMapping
    public String ajouterEtudiant(@RequestBody Etudiant etudiant,HttpSession session) {
        if (session.getAttribute("professeurId") == null) {
            throw new RuntimeException("Non autorisé");
        }
         etudiantRepo.save(etudiant);
         return "ajouté avec succees";
    }

    @DeleteMapping("/{id}")
    public String supprimerEtudiant(@PathVariable Long id,HttpSession session) {
        if (session.getAttribute("professeurId") == null) {
            throw new RuntimeException("Non autorisé");
        }
        if (etudiantRepo.existsById(id)) {
            etudiantRepo.deleteById(id);
            return "Étudiant supprimé avec succès.";
        } else {
            return "Étudiant non trouvé.";
        }
    }

    @PostMapping("/{id}/bonus")
    public Etudiant ajouterBonus(@PathVariable Long id, @RequestBody Map<String, Integer> body,HttpSession session) {
        if (session.getAttribute("professeurId") == null) {
            throw new RuntimeException("Non autorisé");
        }
        int bonus = body.get("bonus");
        Long professeurId = (Long) session.getAttribute("professeurId");
        Etudiant updated = bonusService.ajouterBonus(id, bonus, professeurId);
        notifService.notifierBonus(updated.getEmail(), bonus);
        return updated;
    }

    @PostMapping("/reduction")
    public String appliquerReduction(HttpSession session) {
        if (session.getAttribute("professeurId") == null) {
            throw new RuntimeException("Non autorisé");
        }
        bonusService.appliquerReductionFrais();
        return "Réductions appliquées avec succès.";
    }


}
