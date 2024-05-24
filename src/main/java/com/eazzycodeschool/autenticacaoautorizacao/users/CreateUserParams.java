package com.eazzycodeschool.autenticacaoautorizacao.users;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CreateUserParams(@NotBlank @Email String email, @NotBlank String password) {
}
