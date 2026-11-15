package fr.univ.orleans.saulas.flightmanager.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;
import fr.univ.orleans.saulas.flightmanager.repository.UtilisateurRepository;

@Service 
public class UtilisateurService implements UserDetailsService {
    private final UtilisateurRepository repository;

    public UtilisateurService(UtilisateurRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String nom) throws UsernameNotFoundException {
        Utilisateur utilisateur = repository.findByNomUtilisateur(nom)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur introuvable."));

        return User.builder()
                .username(utilisateur.getNomUtilisateur())
                .password(utilisateur.getMotDePasse())
                .build();
    }
    
}
