package com.example.moneytrack.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class TransacaoRequestDTO {

    @NotBlank(message = "Descrição obrigatória")
    private String descricao;

    @NotNull(message = "Valor obrigatório")
    @Positive(message = "Valor deve ser maior que zero")
    private Double valor;

    @NotBlank(message = "Tipo obrigatório")
    private String tipo;

    @NotBlank(message = "Categoria obrigatória")
    private String categoria;

    @NotNull(message = "Usuário obrigatório")
    private Long usuarioId;

    // getters e setters...


    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}