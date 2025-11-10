package com.practica.transferencia_api.services;

import com.practica.transferencia_api.entity.Cuenta;
import com.practica.transferencia_api.entity.Transferencia;
import com.practica.transferencia_api.repository.CuentaRepository;
import com.practica.transferencia_api.repository.TransferenciaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferenciaService {

    private final CuentaRepository cuentaRepo;
    private final TransferenciaRepository transferenciaRepo;

    public TransferenciaService(CuentaRepository cuentaRepo, TransferenciaRepository transferenciaRepo) {
        this.cuentaRepo = cuentaRepo;
        this.transferenciaRepo = transferenciaRepo;
    }

    @Transactional
    public Transferencia realizarTransferencia(Long idCuentaOrigen, Long idCuentaDestino, Double monto) {
        Cuenta origen = cuentaRepo.findById(idCuentaOrigen)
                .orElseThrow(() -> new RuntimeException("Cuenta de origen no encontrada"));

        Cuenta destino = cuentaRepo.findById(idCuentaDestino)
                .orElseThrow(() -> new RuntimeException("Cuenta de destino no encontrada"));

        if (origen.getSaldo() < monto) {
            throw new RuntimeException("Saldo insuficiente en la cuenta de origen");
        }

        origen.setSaldo(origen.getSaldo() - monto);
        destino.setSaldo(destino.getSaldo() + monto);

        cuentaRepo.save(origen);
        cuentaRepo.save(destino);

        Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigen(origen);
        transferencia.setCuentaDestino(destino);
        transferencia.setMonto(monto);

        return transferenciaRepo.save(transferencia);
    }
}
