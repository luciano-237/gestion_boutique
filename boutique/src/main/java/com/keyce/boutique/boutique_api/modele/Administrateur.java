package com.keyce.tp2.modele;

import jakarta.persistence.Entity;

@Entity
public class Administrateur extends Utilisateur {
    private String matriculeEmploye;
    private String poste;

    public Administrateur() {}

    public Administrateur(String nom, String email, String motDePasse, String matriculeEmploye, String poste) {
        super(nom, email, motDePasse);
        this.matriculeEmploye = matriculeEmploye;
        this.poste = poste;
    }

    // Getters et Setters spécifiques
    public String getMatriculeEmploye() { return matriculeEmploye; }
    public void setMatriculeEmploye(String matriculeEmploye) { this.matriculeEmploye = matriculeEmploye; }

    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
}