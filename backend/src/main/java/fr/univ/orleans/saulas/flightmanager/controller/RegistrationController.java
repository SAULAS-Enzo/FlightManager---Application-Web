package fr.univ.orleans.saulas.flightmanager.controller;

import org.springframework.web.bind.annotation.RestController;

import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;
import fr.univ.orleans.saulas.flightmanager.repository.UtilisateurRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.Map;
import java.util.regex.Pattern;


@RestController 
public class RegistrationController {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    private final UtilisateurRepository repository;
    private final PasswordEncoder passwordEncoder;

    public RegistrationController(UtilisateurRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping(value = "/req/inscription", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, String>> creerUtilisateur(@RequestBody RegistrationRequest request) {
        if (request == null || !StringUtils.hasText(request.nomUtilisateur())
                || !StringUtils.hasText(request.adresseMail()) || !StringUtils.hasText(request.motDePasse())) {
            return error(HttpStatus.BAD_REQUEST, "Tous les champs sont obligatoires.");
        }

        String nomUtilisateur = request.nomUtilisateur().trim();
        String adresseMail = request.adresseMail().trim();
        if (!EMAIL_PATTERN.matcher(adresseMail).matches()) {
            return error(HttpStatus.BAD_REQUEST, "L'adresse email n'est pas valide.");
        }
        if (repository.findByNomUtilisateur(nomUtilisateur).isPresent()) {
            return error(HttpStatus.CONFLICT, "Ce nom d'utilisateur est déjà utilisé.");
        }
        if (repository.findByAdresseMail(adresseMail).isPresent()) {
            return error(HttpStatus.CONFLICT, "Cette adresse email est déjà utilisée.");
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNomUtilisateur(nomUtilisateur);
        utilisateur.setAdresseMail(adresseMail);
        utilisateur.setMotDePasse(passwordEncoder.encode(request.motDePasse()));
        repository.save(utilisateur);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "nomUtilisateur", nomUtilisateur,
                "adresseMail", adresseMail,
                "message", "Compte créé avec succès."));
    }

    private ResponseEntity<Map<String, String>> error(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(Map.of("message", message));
    }

    public record RegistrationRequest(String nomUtilisateur, String adresseMail, String motDePasse) {}
}
