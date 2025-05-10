package com.bonusapp.backend.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Etudiant {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String email;
    private int bonus;
    private int fraisInscription; // Initial
    private String password;

    public Etudiant() {
    }

    public Etudiant(Long id, String nom, String email, int bonus, int fraisInscription,String password) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.bonus = bonus;
        this.fraisInscription = fraisInscription;
        this.password=password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getFraisInscription() {
        return fraisInscription;
    }

    public void setFraisInscription(int fraisInscription) {
        this.fraisInscription = fraisInscription;
    }
}
