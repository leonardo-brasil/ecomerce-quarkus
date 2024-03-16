package br.unitins.loja.service;

import java.util.List;

import br.unitins.loja.DTO.CompraRequestDTO;
import br.unitins.loja.DTO.CompraResponseDTO;
import br.unitins.loja.model.Compra;
import br.unitins.loja.repository.CompraRepository;
import br.unitins.loja.repository.UsuarioRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class CompraServiceImp implements CompraService {

    @Inject
    public CompraRepository compraRepository;

    @Inject
    public UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public CompraResponseDTO create(CompraRequestDTO dto) {

        Compra compra = new Compra();
        compra.setData(dto.data());
        compra.setValor(dto.valor());
        compra.setUsuario(usuarioRepository.findById(dto.idUsuario()));

        compraRepository.persist(compra);

        return CompraResponseDTO.valueOf(compra);

    }

    @Override
    @Transactional
    public void delete(Long id) {

        compraRepository.deleteById(id);

    }

    @Override
    public List<CompraResponseDTO> read() {
        return compraRepository.listAll().stream().map( c -> CompraResponseDTO.valueOf(c)).sorted( (atual, proximo) -> atual.id().compareTo(proximo.id())).toList();
    }

    @Override
    @Transactional
    public void update(Long id, CompraRequestDTO dto) {

        Compra compra = compraRepository.findById(id);
        compra.setData(dto.data());
        compra.setValor(dto.valor());
        compra.setUsuario(usuarioRepository.findById(dto.idUsuario()));

    }

}
