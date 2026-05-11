package com.keyce.tp2.modele;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "lignes_commande")
public class LigneDeCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantiteAchetee;
    private Double prixUnitaireAuMomentDeLachat;

    @ManyToOne
    @JoinColumn(name = "variante_id")
    private VarianteProduit laVariante;

    // Trouve l'attribut laCommande et ajoute l'annotation juste au-dessus
    @JsonIgnore // Importe : com.fasterxml.jackson.annotation.JsonIgnore
    @ManyToOne
    @JoinColumn(name = "commande_id")
    private Commande laCommande;

    public LigneDeCommande() {}

    // --- GETTERS ET SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getQuantiteAchetee() { return quantiteAchetee; }
    public void setQuantiteAchetee(Integer quantiteAchetee) { this.quantiteAchetee = quantiteAchetee; }

    public Double getPrixUnitaireAuMomentDeLachat() { return prixUnitaireAuMomentDeLachat; }
    public void setPrixUnitaireAuMomentDeLachat(Double prix) { this.prixUnitaireAuMomentDeLachat = prix; }

    public VarianteProduit getLaVariante() { return laVariante; }
    public void setLaVariante(VarianteProduit v) { this.laVariante = v; }

    public Commande getLaCommande() { return laCommande; }
    public void setLaCommande(Commande c) { this.laCommande = c; }
}