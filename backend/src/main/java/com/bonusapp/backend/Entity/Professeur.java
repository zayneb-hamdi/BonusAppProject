package com.bonusapp.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Professeur {
    @Id
    @GeneratedValue
    private Long id;
    private String email;
    private String motDePasse; // Stocké en clair pour l’instant (simple)

    public Professeur() {}

    public Professeur(Long id, String email, String motDePasse) {
        this.id = id;
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
}
