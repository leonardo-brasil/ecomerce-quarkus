package br.unitins.loja.DTO;

import br.unitins.loja.model.Usuario;

public record UsuarioResponseDTO(Long id, String nome, String senha) {

    public static UsuarioResponseDTO valueOf(Usuario usuario) {

        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getSenha());

    }

}
