package fr.univ.orleans.saulas.flightmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univ.orleans.saulas.flightmanager.model.Fiche;

public interface FicheDao extends JpaRepository<Fiche, Long> 
{
    /**
     * Rechercher toutes les fiches publique dans la base de données
     * @return la liste de fiches
     */
    List<Fiche> findByPubliqueTrue();
    
    /**
     * Rechercher la liste des fiches appartenant à un utilisateur
     * @param id l'identifiant de l'utilisateur
     * @return la liste des fiches lui appartenant
     */
    List<Fiche> findByAuteurId(Long id);
}
