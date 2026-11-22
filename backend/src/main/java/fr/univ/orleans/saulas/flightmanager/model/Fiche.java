package fr.univ.orleans.saulas.flightmanager.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

/**
 * Représente une fiche 
 */
@Entity 
@Getter @Setter 
public class Fiche {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long idFiche;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String description;

    @Column
    private String logoUrl;

    @Column(nullable = false)
    private String cheminPDF;

    @Column(nullable = false)
    private LocalDate dateAjout = LocalDate.now(); // Par défault, date à aujourd'hui

    @Column(nullable = false)
    private boolean publique;

    @ManyToOne 
    @JoinColumn( name = "utilisateur_id")
    private Utilisateur auteur;

    public Fiche(Utilisateur auteur, String titre, String description, String logoUrl, String cheminPDF, LocalDate dateAjout,
            boolean publique) 
    {
        this.auteur = auteur;
        this.titre = titre;
        this.description = description;
        this.logoUrl = logoUrl;
        this.cheminPDF = cheminPDF;
        this.dateAjout = dateAjout;
        this.publique = publique;
    }

    public void changerVisibilite(boolean visibilite) 
    {
        this.publique = visibilite;
    }

}
