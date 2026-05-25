package com.example.moneytrack.controller;

import com.example.moneytrack.dto.TransacaoRequestDTO;
import com.example.moneytrack.dto.TransacaoResponseDTO;
import com.example.moneytrack.service.transacaoservice;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
@CrossOrigin("*")
public class transacaocontroller {

    private final transacaoservice service;

    public transacaocontroller(transacaoservice service) {
        this.service = service;
    }

    // ======================
    // CRUD NORMAL
    // ======================

    @PostMapping
    public TransacaoResponseDTO criar(@RequestBody @Valid TransacaoRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping
    public List<TransacaoResponseDTO> listar() {
        return service.listar();
    }

    @PutMapping("/{id}")
    public TransacaoResponseDTO atualizar(@PathVariable Long id,
                                          @RequestBody @Valid TransacaoRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }

    // ======================
    // QUERIES NATIVAS
    // ======================

    @GetMapping("/receitas")
    public List<TransacaoResponseDTO> receitas() {
        return service.receitas();
    }

    @GetMapping("/despesas")
    public List<TransacaoResponseDTO> despesas() {
        return service.despesas();
    }

    @GetMapping("/saldo")
    public Double saldo() {
        return service.saldoTotal();
    }

    @GetMapping("/categoria/{categoria}")
    public List<TransacaoResponseDTO> porCategoria(@PathVariable String categoria) {
        return service.porCategoria(categoria);
    }

    @GetMapping("/ultimas")
    public List<TransacaoResponseDTO> ultimas() {
        return service.ultimas();
    }
}