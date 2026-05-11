package com.boutique.boutique_api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private String adresse;

    @Builder.Default
    private Role role = Role.CLIENT;

    @Builder.Default
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum Role {
        ADMIN, CLIENT
    }
}