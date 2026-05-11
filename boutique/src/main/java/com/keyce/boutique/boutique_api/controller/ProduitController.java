package com.boutique.boutique_api.controller;

import com.boutique.boutique_api.dto.ProduitDTO;
import com.boutique.boutique_api.dto.ProduitRequest;
import com.boutique.boutique_api.service.ProduitService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/produits")
@CrossOrigin("*")
public class ProduitController {

    private final ProduitService produitService;
    private final ObjectMapper objectMapper; // Pour convertir le JSON String en Objet

    public ProduitController(ProduitService produitService, ObjectMapper objectMapper) {
        this.produitService = produitService;
        this.objectMapper = objectMapper;
    }

    // LISTER TOUT
    @GetMapping
    public ResponseEntity<List<ProduitDTO>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }

    // RÉCUPÉRER UN PRODUIT
    @GetMapping("/{id}")
    public ResponseEntity<ProduitDTO> getProduitById(@PathVariable Long id) {
        return ResponseEntity.ok(produitService.getProduitById(id));
    }

    // AJOUTER AVEC IMAGE (Modification ici pour le Multipart)
    @PostMapping(consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ProduitDTO> ajouterProduit(
            @RequestPart("produit") String produitJson,
            @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {
        
        // Conversion manuelle du JSON String vers le DTO ProduitRequest
        ProduitRequest request = objectMapper.readValue(produitJson, ProduitRequest.class);
        
        return ResponseEntity.ok(produitService.ajouterProduitAvecImage(request, image));
    }

    // MODIFIER AVEC IMAGE
    @PutMapping(value = "/{id}", consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<ProduitDTO> modifierProduit(
            @PathVariable Long id,
            @RequestPart("produit") String produitJson,
            @RequestPart(value = "image", required = false) MultipartFile image) throws IOException {

        ProduitRequest request = objectMapper.readValue(produitJson, ProduitRequest.class);
        return ResponseEntity.ok(produitService.modifierProduitAvecImage(id, request, image));
    }

    // SUPPRIMER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable Long id) {
        produitService.supprimerProduit(id);
        return ResponseEntity.noContent().build();
    }

    // RECHERCHE
    @GetMapping("/recherche")
    public ResponseEntity<Page<ProduitDTO>> rechercherProduit(
            @RequestParam String nom,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(produitService.rechercherProduit(nom, page, size));
    }

    // PAGINATION SIMPLE
    @GetMapping("/pagination")
    public ResponseEntity<Page<ProduitDTO>> paginationProduits(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return ResponseEntity.ok(produitService.paginationProduits(page, size));
    }
}