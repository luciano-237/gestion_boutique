package com.keyce.boutique.model;

import jakarta.persistence.Entity;

@Entity
public class Client extends Utilisateur {
    private String adresseLivraison;
    private String telephone;
    private Integer pointsFidelite = 0;

    public Client() {}

    public Client(String nom, String email, String motDePasse, String adresseLivraison, String telephone) {
        super(nom, email, motDePasse);
        this.adresseLivraison = adresseLivraison;
        this.telephone = telephone;
    }

    // Getters et Setters spécifiques
    public String getAdresseLivraison() { return adresseLivraison; }
    public void setAdresseLivraison(String adresseLivraison) { this.adresseLivraison = adresseLivraison; }

    public String getTelephone() { return telephone; }
    public void setTelephone(String telephone) { this.telephone = telephone; }

    public Integer getPointsFidelite() { return pointsFidelite; }
    public void setPointsFidelite(Integer pointsFidelite) { this.pointsFidelite = pointsFidelite; }
}