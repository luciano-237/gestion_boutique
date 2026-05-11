package com.boutique.boutique_api.controller;

import com.boutique.boutique_api.model.Commande;
import com.boutique.boutique_api.repository.CommandeRepository;
import com.boutique.boutique_api.service.CommandeService;
import com.boutique.boutique_api.service.PdfService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/commandes")
@CrossOrigin("*")
public class CommandeController {

    private final CommandeService commandeService;
    private final CommandeRepository commandeRepository;
    private final PdfService pdfService;

    public CommandeController(CommandeService commandeService, 
                             CommandeRepository commandeRepository, 
                             PdfService pdfService) {
        this.commandeService = commandeService;
        this.commandeRepository = commandeRepository;
        this.pdfService = pdfService;
    }

    @PostMapping
    public ResponseEntity<?> passerCommande(@RequestBody Map<String, Object> payload) {
        try {
            Long produitId = Long.valueOf(payload.get("produitId").toString());
            String nomClient = payload.get("nomClient").toString();
            String emailClient = payload.get("emailClient").toString();
            Integer quantite = Integer.valueOf(payload.get("quantite").toString());

            Commande commande = commandeService.passerCommande(produitId, nomClient, emailClient, quantite);
            return ResponseEntity.ok(commande);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Commande>> getAllCommandes() {
        return ResponseEntity.ok(commandeRepository.findAll());
    }

    // --- NOUVELLE ROUTE POUR LE PDF ---
    @GetMapping("/{id}/facture")
    public ResponseEntity<byte[]> telechargerFacture(@PathVariable Long id) {
        // 1. Chercher la commande en base
        Commande commande = commandeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Commande introuvable"));

        // 2. Générer le PDF en mémoire via le service
        byte[] pdfBytes = pdfService.genererFacturePdf(commande);

        // 3. Envoyer le fichier au navigateur
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=facture_boutique_" + id + ".pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfBytes);
    }
}