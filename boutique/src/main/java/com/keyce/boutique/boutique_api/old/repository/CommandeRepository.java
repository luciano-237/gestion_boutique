package com.keyce.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyce.boutique.model.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
}