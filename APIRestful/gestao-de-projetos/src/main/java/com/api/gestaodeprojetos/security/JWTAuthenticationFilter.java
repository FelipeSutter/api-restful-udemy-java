package com.api.gestaodeprojetos.security;

import java.io.IOException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JWTAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    private CustomUserDetailsService userDetails;

    // Método principal onde qualquer requisição feita vai entrar aqui antes de
    // entrar no controller
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        // Pega o token de dentro do request
        String token = getToken(request);

        // Pega o id do usuário dentro do token
        Optional<Long> id = jwtService.obterIdDoUsuario(token);

        if (!id.isPresent()) {
            throw new InputMismatchException("Token inválido.");
        }

        // Pega o usuario dono do id.
        UserDetails usuario = userDetails.obterUsuarioPorId(id.get());

        // Verificando se o user tá autenticado ou não
        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(usuario, null,
                Collections.emptyList());

        // Passa a autenticação pro request e setta a autenticação pro security,
        // retirando a autenticação padrão e colocando a nossa autenticação
        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

        SecurityContextHolder.getContext().setAuthentication(auth);

    }

    private String getToken(HttpServletRequest request) {
        String token = request.getHeader("Authorization");

        // Valida se o token realmente só tem o texto dentro dele
        if (!StringUtils.hasText(token)) {
            return null;
        }

        return token.substring(7);
        // return token.substring(7).split("\\.");

    }

}
