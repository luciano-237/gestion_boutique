package com.keyce.tp2.modele;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "commandes")
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateDeCreation;
    private Double totalAPayer;
    private String statutDuPaiement; // ex: "EN ATTENTE", "PAYÉ"
    private String emailDuClient;

    @OneToMany(mappedBy = "laCommande", cascade = CascadeType.ALL)
    private List<LigneDeCommande> lesArticles;

    // Constructeur obligatoire [cite: 2111]
    public Commande() {
        this.dateDeCreation = LocalDateTime.now();
    }

    // --- GETTERS ET SETTERS (Encapsulation [cite: 24, 25]) ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateDeCreation() { return dateDeCreation; }
    public void setDateDeCreation(LocalDateTime dateDeCreation) { this.dateDeCreation = dateDeCreation; }

    public Double getTotalAPayer() { return totalAPayer; }
    public void setTotalAPayer(Double totalAPayer) { this.totalAPayer = totalAPayer; }

    public String getStatutDuPaiement() { return statutDuPaiement; }
    public void setStatutDuPaiement(String statutDuPaiement) { this.statutDuPaiement = statutDuPaiement; }

    public String getEmailDuClient() { return emailDuClient; }
    public void setEmailDuClient(String emailDuClient) { this.emailDuClient = emailDuClient; }

    public List<LigneDeCommande> getLesArticles() { return lesArticles; }
    public void setLesArticles(List<LigneDeCommande> lesArticles) { this.lesArticles = lesArticles; }
}