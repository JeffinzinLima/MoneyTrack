package com.example.moneytrack.repository;

import com.example.moneytrack.model.usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuariorepository extends JpaRepository<usuario, Long> {
}