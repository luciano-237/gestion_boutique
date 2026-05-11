package com.boutique.boutique_api.repository;

import com.boutique.boutique_api.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}