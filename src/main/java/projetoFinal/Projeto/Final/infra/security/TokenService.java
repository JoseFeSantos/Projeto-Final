package projetoFinal.Projeto.Final.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import projetoFinal.Projeto.Final.model.User;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm augorithmn= Algorithm.HMAC256(secret);

            String token = JWT.create()
                    .withIssuer("login-app")
                    .withSubject(user.getEmail())
                    .withExpiresAt(this.generateExpirationDate())
                    .sign(augorithmn);

            return token;

        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while authenticating");

        }

    }

    public String validateToken(String token) {
        try {
            Algorithm augorithmn= Algorithm.HMAC256(secret);
            return JWT.require(augorithmn)
                    .withIssuer("login-app")
                    .build()
                    .verify(token)
                    .getSubject();


        } catch (JWTVerificationException exception) {
            return null;

        }
    }

    private Instant generateExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}
