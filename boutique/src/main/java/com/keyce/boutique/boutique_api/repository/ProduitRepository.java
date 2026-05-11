package com.boutique.boutique_api.repository;

import com.boutique.boutique_api.model.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

    Page<Produit> findByNomContainingIgnoreCase(String nom, Pageable pageable);
}