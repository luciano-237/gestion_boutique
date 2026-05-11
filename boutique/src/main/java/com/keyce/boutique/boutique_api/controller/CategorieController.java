package com.boutique.boutique_api.controller;

import com.boutique.boutique_api.model.Categorie;
import com.boutique.boutique_api.repository.CategorieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategorieController {

    private final CategorieRepository categorieRepository;

    public CategorieController(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    // --- CREATE ---
    @PostMapping
    public Categorie create(@RequestBody Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    // --- READ ALL ---
    @GetMapping
    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    // --- READ ONE ---
    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getById(@PathVariable Long id) {
        return categorieRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // --- UPDATE ---
    @PutMapping("/{id}")
    public ResponseEntity<Categorie> update(@PathVariable Long id, @RequestBody Categorie details) {
        return categorieRepository.findById(id).map(c -> {
            c.setNom(details.getNom());
            c.setDescription(details.getDescription());
            return ResponseEntity.ok(categorieRepository.save(c));
        }).orElse(ResponseEntity.notFound().build());
    }

    // --- DELETE ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!categorieRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categorieRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}