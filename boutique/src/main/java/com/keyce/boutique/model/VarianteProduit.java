package com.keyce.boutique.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
public class VarianteProduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomVariante; // ex: "Format" ou "Couleur"
    private String valeur;       // ex: "1.5L" ou "Bleu"
    private Double prix;
    private Integer quantiteEnStock;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produit_id")
    private Produit produit;

    public VarianteProduit() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomVariante() {
        return nomVariante;
    }

    public void setNomVariante(String nomVariante) {
        this.nomVariante = nomVariante;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public Integer getQuantiteEnStock() {
        return quantiteEnStock;
    }

    public void setQuantiteEnStock(Integer quantiteEnStock) {
        this.quantiteEnStock = quantiteEnStock;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    


}