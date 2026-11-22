package fr.univ.orleans.saulas.flightmanager.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univ.orleans.saulas.flightmanager.model.Fiche;

public interface FicheDao extends JpaRepository<Fiche, Long> 
{
    List<Fiche> findByPubliqueTrue();
    
    List<Fiche> findByAuteurId(Long id);
}
