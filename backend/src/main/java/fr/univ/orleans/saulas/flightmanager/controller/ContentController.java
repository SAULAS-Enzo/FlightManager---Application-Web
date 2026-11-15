package fr.univ.orleans.saulas.flightmanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller 
public class ContentController 
{
    @GetMapping("/connexion")
    public String connexion() {
        return "connexion";
    }

    @GetMapping("/req/inscription")
    public String inscription() {
        return "inscription";
    }

    @GetMapping("/profile")
    public String profileUtilisateur() {
        return "profile";
    }

}
