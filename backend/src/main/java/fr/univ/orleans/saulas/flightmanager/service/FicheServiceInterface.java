package fr.univ.orleans.saulas.flightmanager.service;

import java.util.List;
import java.util.Optional;

import fr.univ.orleans.saulas.flightmanager.model.Fiche;

/**
 * Service pour les fiches
 */
public interface FicheServiceInterface 
{
    /**
     * @param id l'identifiant de l'utilisateur
     * @return Toutes les fiches appartenant à l'utilisateur
     */
    public Optional<List<Fiche>> getFichesUtilisateur(Long id);

    /**
     * @return la liste de toutes les fiches publiques
     */
    public List<Fiche> getFichesPubliques();
}
