package com.keyce.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyce.boutique.model.Commande;

@Repository
public interface CommandeDepot extends JpaRepository<Commande, Long> {
}