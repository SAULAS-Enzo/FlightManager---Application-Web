package fr.univ.orleans.saulas.flightmanager.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/***
 * Représente un utilisateur de l'pplication dans la base de données
 */
@Entity
@Getter @Setter 
@Table(name = "utilisateur")
public class Utilisateur 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String nomUtilisateur;

    private String adresseMail;

    private String motDePasse;

    @OneToMany(mappedBy = "auteur")
    private List<Fiche> fiches;


    public void ajouterFiche(Fiche fiche)
    {
        this.fiches.add(fiche);
    }
 
    public void supprimerFicher(Fiche fiche)
    {
        this.fiches.remove(fiche);
    }
}
