package com.bonusapp.backend.Controller;

import com.bonusapp.backend.Entity.Professeur;
import com.bonusapp.backend.Repository.ProfesseurRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class ProfAuthController {

    @Autowired
    private ProfesseurRepository profRepo;

    @PostMapping("/login")
    public String login(@RequestBody Map<String, String> body, HttpSession session) {
        String email = body.get("email");
        String motDePasse = body.get("motDePasse");

        Professeur prof = profRepo.findByEmail(email).orElse(null);
        if (prof != null && prof.getMotDePasse().equals(motDePasse)) {
            session.setAttribute("professeurId", prof.getId());
            return "Connexion réussie";
        } else {
            return "Identifiants invalides";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "Déconnecté avec succès";
    }
}
