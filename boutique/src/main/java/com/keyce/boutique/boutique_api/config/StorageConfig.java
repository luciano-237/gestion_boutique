package com.boutique.boutique_api.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class StorageConfig {

    private static final Logger logger = LoggerFactory.getLogger(StorageConfig.class);

    @Value("${file.upload-dir:uploads}")
    private String uploadDir;

    @PostConstruct
    public void init() {
        try {
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();

            if (Files.notExists(uploadPath)) {
                Files.createDirectories(uploadPath);
                logger.info("✅ Dossier uploads créé avec succès : {}", uploadPath);
            } else {
                logger.info("📁 Dossier uploads existe déjà : {}", uploadPath);
            }
        } catch (IOException ex) {
            logger.error("❌ Erreur lors de la création du dossier uploads", ex);
        }
    }

    public Path getUploadPath() {
        return Paths.get(uploadDir).toAbsolutePath().normalize();
    }
}