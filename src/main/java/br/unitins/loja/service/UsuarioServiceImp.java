package br.unitins.loja.service;

import java.util.List;

import br.unitins.loja.DTO.UsuarioRequestDTO;
import br.unitins.loja.DTO.UsuarioResponseDTO;
import br.unitins.loja.repository.UsuarioRepository;
import br.unitins.loja.model.Usuario;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImp implements UsuarioService {

    @Inject
    public UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public UsuarioResponseDTO create(UsuarioRequestDTO dto) {

        Usuario usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());
        usuarioRepository.persist(usuario);

        return UsuarioResponseDTO.valueOf(usuario);

    }

    @Override
    @Transactional
    public void delete(Long id) {
        
        usuarioRepository.deleteById(id);

    }

    @Override
    public List<UsuarioResponseDTO> read() {

        return usuarioRepository.findAll().stream().map(usuario -> UsuarioResponseDTO.valueOf(usuario)).sorted( (atual, proximo) -> atual.id().compareTo(proximo.id())).toList();

    }

    @Override
    @Transactional
    public void update(Long id, UsuarioRequestDTO dto) {

        Usuario usuario = usuarioRepository.findById(id);
        usuario.setNome(dto.nome());
        usuario.setSenha(dto.senha());

    }

    

}
