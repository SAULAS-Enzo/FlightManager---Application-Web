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
import org.springframework.security.web.SecurityFilterChain;

import fr.univ.orleans.saulas.flightmanager.service.UtilisateurService;

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
                    .loginPage("/login")
                    .loginProcessingUrl("/req/login")
                    .permitAll();
                httpForm.defaultSuccessUrl("/index", true);
            })
            .authorizeHttpRequests(registry -> {
                registry.requestMatchers(
                    "/login",
                    "/req/login",
                    "/req/signup",
                    "/css/**",
                    "/js/**",
                    "/images/**"
                ).permitAll();

                registry.anyRequest().authenticated();
            })
            .build();
    }
}
