package fr.univ.orleans.saulas.flightmanager.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import fr.univ.orleans.saulas.flightmanager.dao.FicheDao;
import fr.univ.orleans.saulas.flightmanager.dao.UtilisateurDao;
import fr.univ.orleans.saulas.flightmanager.service.impl.FicheService;

@Configuration
public class FicheConfig {

    @Bean
    public FicheService ficheService(FicheDao ficheDao, UtilisateurDao utilisateurDao) {
        return FicheService.getInstance(ficheDao, utilisateurDao);
    }
}