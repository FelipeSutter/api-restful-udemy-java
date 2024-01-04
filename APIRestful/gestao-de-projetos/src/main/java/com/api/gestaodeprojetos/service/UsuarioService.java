package com.api.gestaodeprojetos.service;

import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.api.gestaodeprojetos.model.Usuario;
import com.api.gestaodeprojetos.repository.UsuarioRepository;
import com.api.gestaodeprojetos.security.JWTService;
import com.api.gestaodeprojetos.view.model.LoginResponse;

@Service
public class UsuarioService {

    private static final String headerPrefix = "Bearer ";

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JWTService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    public List<Usuario> obterTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> obterPorId(Long id) {
        return repository.findById(id);
    }

    public Optional<Usuario> obterPorEmail(String email) {
        return repository.findByEmail(email);
    }

    public Usuario adicionar(Usuario usuario) {
        usuario.setId(null);

        if (obterPorEmail(usuario.getEmail()).isPresent()) {
            throw new InputMismatchException("Já existe um usuário cadastrado com o email: " + usuario.getEmail());
        }

        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);

        return repository.save(usuario);

    }

    public LoginResponse logar(String email, String senha) {

        Authentication auth = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));

        SecurityContextHolder.getContext().setAuthentication(auth);

        String token = headerPrefix + jwtService.gerarToken(auth);

        Usuario usuario = repository.findByEmail(email).get();

        return new LoginResponse(token, usuario);

    }

}
