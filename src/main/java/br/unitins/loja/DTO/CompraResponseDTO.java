package br.unitins.loja.DTO;

import java.util.Date;

import br.unitins.loja.model.Compra;

public record CompraResponseDTO(Long id, Double valor, Date data, UsuarioResponseDTO usuario) {
    
    public static CompraResponseDTO valueOf(Compra compra) {

        return new CompraResponseDTO(compra.getId(), compra.getValor(), compra.getData(), UsuarioResponseDTO.valueOf(compra.getUsuario()));

    }

}
