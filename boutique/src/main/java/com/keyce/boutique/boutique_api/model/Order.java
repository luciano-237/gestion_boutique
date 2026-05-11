package com.boutique.boutique_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private List<OrderLine> lignes;
    private Double total;

    @Builder.Default
    private Statut statut = Statut.EN_ATTENTE;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Statut {
        EN_ATTENTE, CONFIRMEE, EN_LIVRAISON, LIVREE, ANNULEE
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderLine {
        private Long productId;
        private Integer quantite;
        private Double prixUnitaire;
    }
}