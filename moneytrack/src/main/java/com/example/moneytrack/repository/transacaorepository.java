package com.example.moneytrack.repository;

import com.example.moneytrack.model.transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface transacaorepository extends JpaRepository<transacao, Long> {

    // 1. receitas
    @Query(value = "SELECT * FROM transacoes WHERE tipo = 'receita'", nativeQuery = true)
    List<transacao> receitas();

    // 2. despesas
    @Query(value = "SELECT * FROM transacoes WHERE tipo = 'despesa'", nativeQuery = true)
    List<transacao> despesas();

    // 3. saldo total
    @Query(value = "SELECT COALESCE(SUM(valor), 0) FROM transacoes", nativeQuery = true)
    Double saldoTotal();

    // 4. por categoria
    @Query(value = "SELECT * FROM transacoes WHERE categoria = :categoria", nativeQuery = true)
    List<transacao> porCategoria(String categoria);

    // 5. últimas transações
    @Query(value = "SELECT * FROM transacoes ORDER BY id DESC LIMIT 5", nativeQuery = true)
    List<transacao> ultimas();
}