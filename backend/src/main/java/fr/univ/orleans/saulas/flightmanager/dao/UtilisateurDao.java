package fr.univ.orleans.saulas.flightmanager.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>
{
    Optional<Utilisateur> findByNomUtilisateur(String nom);
    Optional<Utilisateur> findByAdresseMail(String adresseMail);
    
}
