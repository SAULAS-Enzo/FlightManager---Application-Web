package fr.univ.orleans.saulas.flightmanager.service.impl;

import java.util.List;
import java.util.Optional;

import fr.univ.orleans.saulas.flightmanager.dao.FicheDao;
import fr.univ.orleans.saulas.flightmanager.dao.UtilisateurDao;
import fr.univ.orleans.saulas.flightmanager.model.Fiche;
import fr.univ.orleans.saulas.flightmanager.service.FicheServiceInterface;

public class FicheService implements FicheServiceInterface 
{
    private final FicheDao dao;
    private final UtilisateurDao daoUtilisateur;
    private static FicheService instance;

    public FicheService(FicheDao dao, UtilisateurDao daoUtilisateur)
    {
        this.dao = dao;
        this.daoUtilisateur = daoUtilisateur;
    }

    @Override
    public Optional<List<Fiche>> getFichesUtilisateur(Long id) {
        return daoUtilisateur.findById(id)
            .map(utilisateur -> dao.findByAuteurId(id));
    }

    @Override
    public List<Fiche> getFichesPubliques() {
        return dao.findByPubliqueTrue();
    }

    public static FicheService getInstance(FicheDao ficheDao, UtilisateurDao utilisateurDao) {
        if (instance == null) {
            instance = new FicheService(ficheDao, utilisateurDao);
        }
        return instance;
    } 
    
}
