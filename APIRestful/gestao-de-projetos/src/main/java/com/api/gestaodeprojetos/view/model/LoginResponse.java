package com.api.gestaodeprojetos.view.model;

import com.api.gestaodeprojetos.model.Usuario;

public record LoginResponse(String token, Usuario usuario) {

}
