package com.boutique.boutique_api.controller;

import com.boutique.boutique_api.service.FileStorageService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("*")
public class FileController {

    private final FileStorageService fileStorageService;

    public FileController(FileStorageService fileStorageService) {
        this.fileStorageService = fileStorageService;
    }

    // AFFICHER/TÉLÉCHARGER UNE IMAGE
    @GetMapping("/display/{filename:.+}")
    public ResponseEntity<Resource> displayFile(@PathVariable String filename, HttpServletRequest request) {
        // Charger le fichier en tant que ressource
        Resource resource = fileStorageService.loadFileAsResource(filename);

        // Déterminer le type de contenu (image/png, image/jpeg, etc.)
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            contentType = "application/octet-stream";
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    // SUPPRIMER UN FICHIER
    @DeleteMapping("/{filename:.+}")
    public ResponseEntity<String> deleteFile(@PathVariable String filename) {
        boolean deleted = fileStorageService.deleteFile(filename);
        if (deleted) {
            return ResponseEntity.ok("Fichier supprimé avec succès");
        } else {
            return ResponseEntity.status(404).body("Fichier non trouvé");
        }
    }
}