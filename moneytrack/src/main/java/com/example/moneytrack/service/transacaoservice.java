package com.example.moneytrack.service;

import com.example.moneytrack.dto.TransacaoRequestDTO;
import com.example.moneytrack.dto.TransacaoResponseDTO;
import com.example.moneytrack.model.transacao;
import com.example.moneytrack.model.usuario;
import com.example.moneytrack.repository.transacaorepository;
import com.example.moneytrack.repository.usuariorepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class transacaoservice {

    private final transacaorepository transacaoRepository;
    private final usuariorepository usuarioRepository;

    public transacaoservice(transacaorepository transacaoRepository,
                            usuariorepository usuarioRepository) {
        this.transacaoRepository = transacaoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // =========================
    // CRUD NORMAL
    // =========================

    public TransacaoResponseDTO salvar(TransacaoRequestDTO dto) {

        usuario u = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        transacao t = new transacao();
        t.setDescricao(dto.getDescricao());
        t.setValor(dto.getValor());
        t.setTipo(dto.getTipo());
        t.setCategoria(dto.getCategoria());
        t.setUsuario(u);

        transacao salvo = transacaoRepository.save(t);

        return toDTO(salvo);
    }

    public List<TransacaoResponseDTO> listar() {
        return transacaoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public TransacaoResponseDTO atualizar(Long id, TransacaoRequestDTO dto) {

        transacao t = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada"));

        usuario u = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        t.setDescricao(dto.getDescricao());
        t.setValor(dto.getValor());
        t.setTipo(dto.getTipo());
        t.setCategoria(dto.getCategoria());
        t.setUsuario(u);

        transacao atualizado = transacaoRepository.save(t);

        return toDTO(atualizado);
    }

    public void deletar(Long id) {
        if (!transacaoRepository.existsById(id)) {
            throw new RuntimeException("Transação não encontrada");
        }
        transacaoRepository.deleteById(id);
    }

    // =========================
    // QUERIES NATIVAS (5 REQUISITOS)
    // =========================

    public List<TransacaoResponseDTO> receitas() {
        return transacaoRepository.receitas()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<TransacaoResponseDTO> despesas() {
        return transacaoRepository.despesas()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Double saldoTotal() {
        return transacaoRepository.saldoTotal();
    }

    public List<TransacaoResponseDTO> porCategoria(String categoria) {
        return transacaoRepository.porCategoria(categoria)
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    public List<TransacaoResponseDTO> ultimas() {
        return transacaoRepository.ultimas()
                .stream().map(this::toDTO).collect(Collectors.toList());
    }

    // =========================
    // MAPPER
    // =========================

    private TransacaoResponseDTO toDTO(transacao t) {
        TransacaoResponseDTO dto = new TransacaoResponseDTO();
        dto.setId(t.getId());
        dto.setDescricao(t.getDescricao());
        dto.setValor(t.getValor());
        dto.setTipo(t.getTipo());
        dto.setCategoria(t.getCategoria());
        dto.setUsuarioId(t.getUsuario().getId());
        return dto;
    }
}