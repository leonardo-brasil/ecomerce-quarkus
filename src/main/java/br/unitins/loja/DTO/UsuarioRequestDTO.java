package br.unitins.loja.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UsuarioRequestDTO(@NotNull @NotBlank(message = "O nome não pode estar vazio") String nome, @NotNull @NotBlank(message = "A senha não pode estar vazia") String senha) {
}
