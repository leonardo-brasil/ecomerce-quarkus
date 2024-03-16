package br.unitins.loja.service;

import java.util.List;

import br.unitins.loja.DTO.CompraRequestDTO;
import br.unitins.loja.DTO.CompraResponseDTO;

public interface CompraService {

    public List<CompraResponseDTO> read();
    public CompraResponseDTO create(CompraRequestDTO dto);
    public void update(Long id, CompraRequestDTO dto);
    public void delete(Long id);

}
