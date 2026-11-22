package fr.univ.orleans.saulas.flightmanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import fr.univ.orleans.saulas.flightmanager.service.impl.UtilisateurService;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UtilisateurService service;

    public SecurityConfig(UtilisateurService service) {
        this.service = service;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(service);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity, AuthenticationProvider authenticationProvider) throws Exception {
        return httpSecurity
            .csrf(AbstractHttpConfigurer::disable)
            .authenticationProvider(authenticationProvider)
            .formLogin(httpForm -> {
                httpForm
                    .loginPage("/connexion")
                    .loginProcessingUrl("/req/connexion")
                    .usernameParameter("nomUtilisateur")
                    .passwordParameter("motDePasse")
                    .successHandler((request, response, authentication) -> {
                        response.setStatus(HttpStatus.OK.value());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.getWriter().write("{\"message\":\"Connexion réussie.\"}");
                    })
                    .failureHandler((request, response, exception) -> {
                        response.setStatus(HttpStatus.UNAUTHORIZED.value());
                        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                        response.getWriter().write("{\"message\":\"Nom d'utilisateur ou mot de passe invalide.\"}");
                    })
                    .permitAll();
            })
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
            .authorizeHttpRequests(registry -> {
                registry.requestMatchers(
                    "/connexion",
                    "/inscription",
                    "/req/connexion",
                    "/req/inscription",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll();
                registry.anyRequest().authenticated();
            })
            .build();
    }
}
