package fr.univ.orleans.saulas.flightmanager.service.impl;

import java.util.Optional;

import fr.univ.orleans.saulas.flightmanager.dao.FicheDao;
import fr.univ.orleans.saulas.flightmanager.model.Fiche;
import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;
import fr.univ.orleans.saulas.flightmanager.service.FicheServiceInterface;

public class FicheService implements FicheServiceInterface 
{
    private FicheDao dao;

    public FicheService(FicheDao dao)
    {
        this.dao = dao;
    }

    @Override
    public Optional<Fiche> getFichesUtilisateur(Utilisateur utilisateur) 
    {
        return dao.findById(utilisateur.getId());
    }

    @Override
    public Optional<Fiche> getFichesPubliques() 
    {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFichesPubliques'");
    }
    
}
