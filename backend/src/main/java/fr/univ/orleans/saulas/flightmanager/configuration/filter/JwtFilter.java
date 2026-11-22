package fr.univ.orleans.saulas.flightmanager.configuration.filter;

import java.io.IOException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import fr.univ.orleans.saulas.flightmanager.configuration.security.JwtUtils;
import fr.univ.orleans.saulas.flightmanager.service.impl.UtilisateurService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component 
@RequiredArgsConstructor 
public class JwtFilter extends OncePerRequestFilter
{
    private final UtilisateurService utilisateurService;
    private final JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException 
    {
        final String autHeader = request.getHeader("Authorization");

        String nomUtilisateur = null;
        String jwt = null;

        if (autHeader != null && autHeader.startsWith("Bearer ")) {
            jwt = autHeader.substring(7);
            nomUtilisateur = jwtUtils.extraireNomUtilisateur(jwt);
        }

        if (nomUtilisateur != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = utilisateurService.loadUserByUsername(nomUtilisateur);

            if (jwtUtils.validerToken(jwt, userDetails)) {
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userDetails, 
                    null, 
                    userDetails.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }

        filterChain.doFilter(request, response); // Passer au filtre suivant
    }
    
}
