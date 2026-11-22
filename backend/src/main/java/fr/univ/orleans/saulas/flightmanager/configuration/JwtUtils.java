package fr.univ.orleans.saulas.flightmanager.configuration;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component 
public class JwtUtils 
{
    @Value("${app.secret-key}")
    private String secretKey;

    @Value("${app.expiration-time}")
    private Long expirationTime;

    public String genereToken(String nomUtilisateur) 
    {
        Map<String, Object> claims = new HashMap<>();
        return creerToken(claims, nomUtilisateur);
    }

    private String creerToken(Map<String,Object> claims, String nomUtilisateur) 
    {
        return Jwts.builder()
            .setClaims(claims)
            .setSubject(nomUtilisateur)
            .setIssuedAt(new Date(System.currentTimeMillis()))
            .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
            .signWith(getCleSecrete(), SignatureAlgorithm.HS256)
            .compact();
    }

    private Key getCleSecrete() 
    {
        byte[] keyByte = secretKey.getBytes();
        return new SecretKeySpec(keyByte, SignatureAlgorithm.HS256.getJcaName());
    }

    public boolean validerToken(String token, UserDetails userDetails)
    {
        String nomUtilisateur = extraireNomUtilisateur(token);
        return (nomUtilisateur.equals(userDetails.getUsername()) && !estExpireToken(token));
    }

    

    private boolean estExpireToken(String token) 
    {
        return extraireDateExpiration(token).before(new Date());
    }

    private Date extraireDateExpiration(String token)
    {
        return extraireClaim(token, Claims::getExpiration);
    }

    private String extraireNomUtilisateur(String token) 
    {
        return extraireClaim(token, Claims::getSubject);
    }

    private <T> T extraireClaim(String token, Function<Claims, T> claimsResolver) 
    {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
            .setSigningKey(getCleSecrete())
            .parseClaimsJws(token)
            .getBody();
    }
    
}
