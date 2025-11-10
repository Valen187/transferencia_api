package com.practica.transferencia_api.repository;

import com.practica.transferencia_api.entity.Cuenta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CuentaRepository extends JpaRepository<Cuenta, Long> {
}
