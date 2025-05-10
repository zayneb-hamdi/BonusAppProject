package com.bonusapp.backend.Controller;

import com.bonusapp.backend.Entity.BonusAttribution;
import com.bonusapp.backend.Entity.Etudiant;
import com.bonusapp.backend.Repository.EtudiantRepository;
import com.bonusapp.backend.Repository.BonusAttributionRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/etudiant")
public class EtudiantAuthController {

    @Autowired
    private EtudiantRepository etudiantRepo;

    @Autowired
    private BonusAttributionRepository bonusRepo;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body, HttpSession session) {
        String email = body.get("email");
        String password = body.get("password");
        Etudiant etudiant = etudiantRepo.findByEmail(email).orElse(null);
        if (etudiant != null && etudiant.getPassword().equals(password)) {
            session.setAttribute("etudiantEmail", email);
            return "Connecté" ;
        }
        else {
            return "Identifiants invalides";
        }


    }
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Déconnecté avec succès";
    }
    @GetMapping("/bonus")
    public List<BonusAttribution> consulterBonus(HttpSession session) {
        String email = (String) session.getAttribute("etudiantEmail");
        if (email == null) throw new RuntimeException("Non connecté");
        return bonusRepo.findByEtudiantEmail(email);
    }
}
