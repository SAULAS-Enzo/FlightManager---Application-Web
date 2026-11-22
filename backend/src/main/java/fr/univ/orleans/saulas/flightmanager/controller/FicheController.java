package fr.univ.orleans.saulas.flightmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.orleans.saulas.flightmanager.model.Fiche;
import fr.univ.orleans.saulas.flightmanager.service.impl.FicheService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/encyclopedie")
public class FicheController {

    @Autowired
    private FicheService service;

    @GetMapping("/utilisateurs/{id}/fiches")
    public ResponseEntity<List<Fiche>> getFichesUtilisateur(@PathVariable Long id) {
        return service.getFichesUtilisateur(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/fiches")
    public ResponseEntity<List<Fiche>> getFichesPubliques() {
        List<Fiche> fiches = service.getFichesPubliques();
        return ResponseEntity.ok(fiches);
    }
}
