package fr.univ.orleans.saulas.flightmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity
@Table(name = "UTILISATEUR")
public class Utilisateur 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomUtilisateur;

    private String adresseMail;

    private String motDePasse;
}
