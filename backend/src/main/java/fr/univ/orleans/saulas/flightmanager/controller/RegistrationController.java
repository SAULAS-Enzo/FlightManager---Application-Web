package fr.univ.orleans.saulas.flightmanager.controller;

import org.springframework.web.bind.annotation.RestController;

import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;
import fr.univ.orleans.saulas.flightmanager.repository.UtilisateurRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController 
public class RegistrationController 
{

    @Autowired 
    private UtilisateurRepository repository;

    @Autowired 
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/req/signup", consumes = "application/json" )
    public Utilisateur creerUtilisateur(@RequestBody Utilisateur utilisateur) 
    {
        utilisateur.setMotDePasse(passwordEncoder.encode(utilisateur.getMotDePasse()));
        return repository.save(utilisateur);
    }
    
}
