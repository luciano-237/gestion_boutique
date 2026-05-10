package com.keyce.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyce.boutique.model.LigneDeCommande;

@Repository
public interface LigneDeCommandeDepot extends JpaRepository<LigneDeCommande, Long> {
}