package com.practica.transferencia_api.repository;

import com.practica.transferencia_api.entity.Transferencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferenciaRepository extends JpaRepository<Transferencia, Long> {
}
