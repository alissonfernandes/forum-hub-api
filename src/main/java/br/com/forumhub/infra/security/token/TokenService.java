package br.com.forumhub.infra.security.token;

import br.com.forumhub.domain.user.User;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private static final String  ISSUER = "API topic";

    @Value("${api.security.token.secret}")
    private String secret;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret); //Seleciona algoritmo a ser utilizado
            return JWT.create()
                    .withIssuer(ISSUER) // Identificação do gerador desse token
                    .withSubject(user.getEmail())// Usuario relacionado com esse token
                    .withClaim("id", user.getId())// Guardar mais informações(id) do usuário do token
                    .withExpiresAt(getExpires())// tempo de duração expiração do token
                    .sign(algorithm); // Assinatura do algoritmo
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Erro ao gerar token jwt", ex);
        }
    }

    private Instant getExpires() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
