package br.com.api.authlogin.dto.v1;

import br.com.api.authlogin.model.UserRole;

public record RegisterDTO(String nome, String email, String cpfcnpj, String login, String password, UserRole role) {
}
