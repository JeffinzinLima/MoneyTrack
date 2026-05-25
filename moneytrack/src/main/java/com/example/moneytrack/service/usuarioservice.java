package com.example.moneytrack.service;

import com.example.moneytrack.dto.UsuarioRequestDTO;
import com.example.moneytrack.dto.UsuarioResponseDTO;
import com.example.moneytrack.model.usuario;
import com.example.moneytrack.repository.usuariorepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class usuarioservice {

    private final usuariorepository repository;

    public usuarioservice(usuariorepository repository) {
        this.repository = repository;
    }

    public List<UsuarioResponseDTO> listar() {
        return repository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public UsuarioResponseDTO salvar(UsuarioRequestDTO dto) {
        usuario u = new usuario();
        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());

        return toDTO(repository.save(u));
    }

    public UsuarioResponseDTO atualizar(Long id, UsuarioRequestDTO dto) {
        usuario u = repository.findById(id).orElseThrow();

        u.setNome(dto.getNome());
        u.setEmail(dto.getEmail());
        u.setSenha(dto.getSenha());

        return toDTO(repository.save(u));
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private UsuarioResponseDTO toDTO(usuario u) {
        UsuarioResponseDTO dto = new UsuarioResponseDTO();
        dto.setId(u.getId());
        dto.setNome(u.getNome());
        dto.setEmail(u.getEmail());
        return dto;
    }
}