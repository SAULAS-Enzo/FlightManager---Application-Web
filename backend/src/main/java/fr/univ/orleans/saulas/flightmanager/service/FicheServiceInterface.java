package fr.univ.orleans.saulas.flightmanager.service;

import java.util.Optional;

import fr.univ.orleans.saulas.flightmanager.model.Fiche;
import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;

/**
 * Service pour les fiches
 */
public interface FicheServiceInterface 
{
    /**
     * @param utilisateur
     * @return Toutes les fiches appartenant à l'utilisateur
     */
    public Optional<Fiche> getFichesUtilisateur(Utilisateur utilisateur);

    /**
     * @return la liste de toutes les fiches publiques
     */
    public Optional<Fiche> getFichesPubliques();
}
