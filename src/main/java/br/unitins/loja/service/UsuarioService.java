package br.unitins.loja.service;

import br.unitins.loja.DTO.UsuarioRequestDTO;
import br.unitins.loja.DTO.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioService {

    public List<UsuarioResponseDTO> read();
    public UsuarioResponseDTO create(UsuarioRequestDTO usuario);
    public void update(Long id, UsuarioRequestDTO usuario);
    public void delete(Long id);

}
