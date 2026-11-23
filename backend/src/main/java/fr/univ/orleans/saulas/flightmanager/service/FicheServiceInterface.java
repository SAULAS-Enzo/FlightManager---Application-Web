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

    /**
     * @param fiche Les détails de la fiche à créer
     */
    public void createFiche(Fiche fiche);

    /**
     * @param id l'identifiant de la fiche à supprimer
     */
    public void deleteFiche(Long id);

    /**
     * @param id l'identifiant de la fiche à modifier
     * @param param les paramètres de la fiche à changer
     */
    public void updateFiche(Long id, String nouveauTitre, String nouvelleDescription, String nouveauLogoUrl, String nouveauCheminPDF, boolean changerVisibilite);
}
