package fr.univ.orleans.saulas.flightmanager.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;
import fr.univ.orleans.saulas.flightmanager.repository.UtilisateurRepository;
import lombok.AllArgsConstructor;

@Service 
@AllArgsConstructor 
public class UtilisateurService implements UserDetailsService
{
    @Autowired 
    private UtilisateurRepository repository;

    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {

        System.out.println("LOAD USER : " + nom);


        Optional<Utilisateur> utilisateur = repository.findByNomUtilisateur(nom);

        if (utilisateur.isPresent()) {
            var utilisateurObjet = utilisateur.get();
            System.out.println("AUTENTIFICATION VALIDE");
            return User.builder().username(utilisateurObjet.getNomUtilisateur()).password(utilisateurObjet.getMotDePasse()).build();
        } else {
            System.out.println("AUTENTIFICATION INVALIDE");
            throw new UsernameNotFoundException(nom);
        }
    }
    
}
