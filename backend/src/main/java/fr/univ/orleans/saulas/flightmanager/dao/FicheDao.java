package fr.univ.orleans.saulas.flightmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.univ.orleans.saulas.flightmanager.model.Fiche;

public interface FicheDao extends JpaRepository<Fiche, Long>
{
}
