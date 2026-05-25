package com.example.moneytrack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "transacoes")
public class transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;
    private Double valor;
    private String tipo;
    private String categoria;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private usuario usuario;

    public transacao() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }

    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Double getValor() { return valor; }

    public void setValor(Double valor) { this.valor = valor; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public usuario getUsuario() { return usuario; }

    public void setUsuario(usuario usuario) { this.usuario = usuario; }
}