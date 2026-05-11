# 🛍️ Boutique API - Backend Spring Boot

Ce projet est une API REST robuste développée avec **Spring Boot**, conçue pour gérer le catalogue, les stocks et les ventes d'une boutique en ligne. Elle intègre des fonctionnalités avancées comme l'upload d'images, la pagination et la génération de factures PDF.

---

## 🚀 Fonctionnalités Clés

* **Gestion des Produits & Catégories** : CRUD complet pour organiser l'inventaire.
* **Système de Commande** : Traitement des achats avec mise à jour automatique des données et calcul du total.
* **Génération de Factures PDF** : Création dynamique de documents PDF pour chaque commande via un service dédié (`PdfService`).
* **Gestion de Fichiers Multimédia** : Upload, stockage et affichage d'images produits (support du `MultipartFile`).
* **Recherche & Pagination** : Optimisation de l'affichage des produits pour de grandes bases de données.
* **Sécurité & DTO** : Utilisation de `Data Transfer Objects` (DTO) pour sécuriser les échanges de données entre le client et le serveur.
* **Gestion Globale des Erreurs** : Réponses HTTP standardisées pour une meilleure intégration frontend.

---

## 🛠️ Stack Technique

* **Framework** : Spring Boot 3+
* **Persistance** : Spring Data JPA / Hibernate
* **Utilitaire** : Lombok (pour la clarté du code)
* **Traitement JSON** : Jackson `ObjectMapper`
* **Document** : Service PDF pour la facturation

---

## 📂 Points d'Entrée Principaux (Endpoints)

### 📦 Produits (`/api/produits`)
* `GET /api/produits` : Liste tous les produits.
* `POST /api/produits` : Ajout d'un produit avec image (Multipart).
* `GET /api/produits/recherche` : Recherche filtrée avec pagination.

### 🛒 Commandes (`/api/commandes`)
* `POST /api/commandes` : Enregistrement d'une nouvelle vente.
* `GET /api/commandes/{id}/facture` : Téléchargement de la facture PDF.

### 📁 Fichiers (`/api/files`)
* `GET /api/files/display/{filename}` : Visualisation des images uploadées.
* `DELETE /api/files/{filename}` : Suppression de fichiers sur le serveur.

---

## ⚙️ Configuration & Lancement

1. **Clonage du dépôt** :
   git clone github.com/luciano-237/gestion_boutique

2. **Configuration DB** :
    Ajustez les paramètres de connexion dans src/main/resources/application.properties.

3. **Exécution** :
    mvn spring-boot:run
L'API sera disponible par défaut sur http://localhost:8080.
