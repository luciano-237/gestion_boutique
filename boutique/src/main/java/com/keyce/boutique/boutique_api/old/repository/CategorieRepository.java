package com.keyce.boutique.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keyce.boutique.model.Categorie;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}