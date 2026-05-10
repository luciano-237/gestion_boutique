package com.keyce.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyce.boutique.model.VarianteProduit;

@Repository
public interface VarianteProduitDepot extends JpaRepository<VarianteProduit, Long> {
}