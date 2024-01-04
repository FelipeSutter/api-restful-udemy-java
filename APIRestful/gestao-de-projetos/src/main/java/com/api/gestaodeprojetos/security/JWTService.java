package com.api.gestaodeprojetos.security;

import java.util.Date;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.api.gestaodeprojetos.model.Usuario;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTService {

    private static final String chaveJWT = "secretKey";

    public String gerarToken(Authentication auth) {

        // definir um tempo de expiração, o tempo é em milissegundos
        int tempoExpiracao = 86400000;

        // Data de expiração com base no tempo de expiração. Pega a data atual e soma o
        // tempoExpiracao
        Date dataExpiracao = new Date(new Date().getTime() + tempoExpiracao);

        Usuario usuario = (Usuario) auth.getPrincipal();

        // Método depreciado por conta da versão do jwt
        return Jwts.builder()
                .setSubject(usuario.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.HS512, chaveJWT)
                .compact();
    }

    public Optional<Long> obterIdDoUsuario(String token) {

        try {
            // Esse método pega as permissões de dentro do token
            Claims claims = parse(token).getBody();

            // Retorna o id do usuario de dentro do token, caso contrario retorna null
            return Optional.ofNullable(Long.parseLong(claims.getSubject()));

        } catch (Exception e) {
            return Optional.empty();
        }

    }

    private Jws<Claims> parse(String token) {
        // também está depreciada.
        return Jwts.parser().setSigningKey(chaveJWT).parseClaimsJws(token);
    }

}
