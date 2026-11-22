package fr.univ.orleans.saulas.flightmanager.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.univ.orleans.saulas.flightmanager.configuration.security.JwtUtils;
import fr.univ.orleans.saulas.flightmanager.dao.UtilisateurDao;
import fr.univ.orleans.saulas.flightmanager.model.Utilisateur;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 
public class RegistrationController {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[^\\s@]+@[^\\s@]+\\.[^\\s@]+$");

    private final UtilisateurDao dao;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    public RegistrationController(UtilisateurDao dao,
                                  PasswordEncoder passwordEncoder,
                                  AuthenticationManager authenticationManager,
                                  JwtUtils jwtUtils) {
        this.dao = dao;
        this.passwordEncoder = passwordEncoder;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping(value = "/req/connexion", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> connecter(@RequestBody LoginRequest request,
                                       HttpServletRequest httpRequest) {
        return authentifier(request.nomUtilisateur(), request.motDePasse(), httpRequest);
    }

    @PostMapping("/req/connexion")
    public ResponseEntity<?> connecterParFormulaire(@RequestParam String nomUtilisateur,
                                                     @RequestParam String motDePasse,
                                                     HttpServletRequest httpRequest) {
        return authentifier(nomUtilisateur, motDePasse, httpRequest);
    }

    private ResponseEntity<?> authentifier(String nomUtilisateur,
                                           String motDePasse,
                                           HttpServletRequest httpRequest) {
        if (!StringUtils.hasText(nomUtilisateur) || !StringUtils.hasText(motDePasse)) {
            return erreurConnexion();
        }

        String usernameClean = nomUtilisateur.trim();

        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(usernameClean, motDePasse));

            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authentication);
            SecurityContextHolder.setContext(context);
            httpRequest.getSession(true).setAttribute(
                    HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,
                    context);

            Map<String, Object> result = new HashMap<>();
            result.put("token", jwtUtils.genereToken(usernameClean));
            result.put("type", "Bearer");
            result.put("message", "Connexion réussie.");
            return ResponseEntity.ok(result);
        } catch (AuthenticationException exception) {
            log.error(exception.getMessage());
            return erreurConnexion();
        }
    }

    private ResponseEntity<Map<String, String>> erreurConnexion() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                Map.of("message", "Nom d'utilisateur ou mot de passe invalide."));
    }

    @PostMapping(value = "/req/inscription", consumes = "application/json",
            produces = "application/json")
    public ResponseEntity<Map<String, String>> creerUtilisateur(
            @RequestBody RegistrationRequest request) {
        if (request == null
                || !StringUtils.hasText(request.nomUtilisateur())
                || !StringUtils.hasText(request.adresseMail())
                || !StringUtils.hasText(request.motDePasse())) {
            return error(HttpStatus.BAD_REQUEST, "Tous les champs sont obligatoires.");
        }

        String nomUtilisateur = request.nomUtilisateur().trim();
        String adresseMail = request.adresseMail().trim();
        if (!EMAIL_PATTERN.matcher(adresseMail).matches()) {
            return error(HttpStatus.BAD_REQUEST, "L'adresse email n'est pas valide.");
        }
        if (dao.findByNomUtilisateur(nomUtilisateur).isPresent()) {
            return error(HttpStatus.CONFLICT,
                    "Ce nom d'utilisateur est déjà utilisé.");
        }
        if (dao.findByAdresseMail(adresseMail).isPresent()) {
            return error(HttpStatus.CONFLICT,
                    "Cette adresse email est déjà utilisée.");
        }

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNomUtilisateur(nomUtilisateur);
        utilisateur.setAdresseMail(adresseMail);
        utilisateur.setMotDePasse(passwordEncoder.encode(request.motDePasse()));
        dao.save(utilisateur);

        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "nomUtilisateur", nomUtilisateur,
                "adresseMail", adresseMail,
                "message", "Compte créé avec succès."));
    }

    private ResponseEntity<Map<String, String>> error(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(Map.of("message", message));
    }

    public record RegistrationRequest(String nomUtilisateur,
                                      String adresseMail,
                                      String motDePasse) {}

    public record LoginRequest(String nomUtilisateur, String motDePasse) {}
}
