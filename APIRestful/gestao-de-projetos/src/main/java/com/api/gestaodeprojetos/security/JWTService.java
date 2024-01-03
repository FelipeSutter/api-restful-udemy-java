package com.api.gestaodeprojetos.security;

import java.util.Date;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.api.gestaodeprojetos.model.Usuario;

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

        return Jwts.builder()
                .setSubject(usuario.getId().toString())
                .setIssuedAt(new Date())
                .setExpiration(dataExpiracao)
                .signWith(SignatureAlgorithm.ES256, chaveJWT)
                .compact();
    }

}
