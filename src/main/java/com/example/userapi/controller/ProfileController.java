package com.example.userapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileController {

    @Value("${spring.profiles.active:default}")
    private String activeProfile;

    @GetMapping("/api/profile")
    public String getActiveProfile() {
        return "Perfil activo: " + activeProfile;
    }
}
