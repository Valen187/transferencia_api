package com.practica.transferencia_api.controllers;

import com.practica.transferencia_api.entity.Cuenta;
import com.practica.transferencia_api.entity.Transferencia;
import com.practica.transferencia_api.repository.CuentaRepository;
import com.practica.transferencia_api.services.TransferenciaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transferencias")
public class TransferenciaController {

    private final TransferenciaService servicio;
    private final CuentaRepository cuentaRepo;

    public TransferenciaController(TransferenciaService servicio, CuentaRepository cuentaRepo) {
        this.servicio = servicio;
        this.cuentaRepo = cuentaRepo;
    }

    @PostMapping
    public Transferencia realizarTransferencia(
            @RequestParam Long idCuentaOrigen,
            @RequestParam Long idCuentaDestino,
            @RequestParam Double monto) {

        return servicio.realizarTransferencia(idCuentaOrigen, idCuentaDestino, monto);
    }
    @PostMapping("/cuentas")
    public Cuenta crearCuenta(@RequestBody Cuenta cuenta) {
        return cuentaRepo.save(cuenta);
    }

    @GetMapping("/cuentas")
    public List<Cuenta> listarCuentas() {
        return cuentaRepo.findAll();
    }
}
