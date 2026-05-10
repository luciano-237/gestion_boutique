package com.keyce.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyce.boutique.model.Produit;

import java.util.List;

@Repository
public interface ProduitDepot extends JpaRepository<Produit, Long> {
    List<Produit> findByNomContainingIgnoreCase(String texte);
}