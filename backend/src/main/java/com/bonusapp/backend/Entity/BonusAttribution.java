package com.bonusapp.backend.Entity;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class BonusAttribution {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Etudiant etudiant;

    @ManyToOne
    private Professeur professeur;

    private int montant;

    private LocalDateTime dateAttribution;

    public BonusAttribution() {}

    public BonusAttribution(Etudiant etudiant, Professeur professeur, int montant, LocalDateTime dateAttribution) {
        this.etudiant = etudiant;
        this.professeur = professeur;
        this.montant = montant;
        this.dateAttribution = dateAttribution;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public LocalDateTime getDateAttribution() {
        return dateAttribution;
    }

    public void setDateAttribution(LocalDateTime dateAttribution) {
        this.dateAttribution = dateAttribution;
    }
}
