-- Tabla cuentas
CREATE TABLE cuentas (
    id SERIAL PRIMARY KEY,
    titular VARCHAR(100) NOT NULL,
    saldo NUMERIC(12,2) NOT NULL
);

-- Tabla transferencias
CREATE TABLE transferencias (
    id SERIAL PRIMARY KEY,
    cuenta_origen_id BIGINT NOT NULL,
    cuenta_destino_id BIGINT NOT NULL,
    monto NUMERIC(12,2) NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_origen FOREIGN KEY (cuenta_origen_id) REFERENCES cuentas(id),
    CONSTRAINT fk_destino FOREIGN KEY (cuenta_destino_id) REFERENCES cuentas(id)
);


INSERT INTO cuentas (titular, saldo) VALUES ('Valentina', 1000.00);
INSERT INTO cuentas (titular, saldo) VALUES ('Camila', 500.00);
INSERT INTO cuentas (titular, saldo) VALUES ('Juan', 800.00);
INSERT INTO cuentas (titular, saldo) VALUES ('Dayana', 600.00);
INSERT INTO cuentas (titular, saldo) VALUES ('Manuel', 2000.00);

SELECT * FROM cuentas;
