INSERT INTO usuarios (id, nombre, password) VALUES
    (1, 'gcm.origen', '1234'),
    (2, 'gcm.destino', '1234');

INSERT INTO roles (nombre, descripcion) VALUES
    ('GCM', 'Gestor de Comision Medica'),
    ('ADMIN', 'Administrador');

INSERT INTO comisiones_medicas (codigo, direccion, email, nombre, telefono) VALUES
    (101, 'Av. Colon 100', 'origen@example.com', 'Comision Medica Origen', '3511000001'),
    (202, 'Av. General Paz 200', 'destino@example.com', 'Comision Medica Destino', '3511000002');

INSERT INTO empleados (nombre, apellido, email, id_usuario, id_rol, codigoCM) VALUES
    ('Juan', 'Perez', 'juan.perez@example.com', 1, 'GCM', 101),
    ('Ana', 'Gomez', 'ana.gomez@example.com', 2, 'GCM', 202);

INSERT INTO estados (ambito, nombre, descripcion) VALUES
    ('Bolsin', 'Creado', 'Bolsin creado'),
    ('Bolsin', 'Cerrado', 'Bolsin cerrado'),
    ('Bolsin', 'Enviado', 'Bolsin enviado'),
    ('Bolsin', 'Recibido', 'Bolsin recibido'),
    ('Bolsin', 'DeBaja', 'Bolsin dado de baja'),
    ('Remito', 'Creado', 'Remito creado'),
    ('Remito', 'EnBolsinSaliente', 'Remito en un bolsin a punto de salir'),
    ('Remito', 'RecibidoYAceptado', 'Remito recibido y aceptado en la cm de destino'),
    ('Remito', 'RecibidoYAceptadoParcialmente', 'Remito recibido y aceptado de forma parcial'),
    ('Remito', 'Cancelado', 'Remito cancelado');

INSERT INTO bolsines (numero_bolsin, cm_origen, cm_destino, numero_precinto, fecha_creacion, peso) VALUES
    (1001, 101, 202, 5001, TIMESTAMP '2026-07-09 09:00:00', 12.50);

INSERT INTO cambios_estados_bolsin (
    numero_bolsin,
    nombre_estado,
    ambito_estado,
    fecha_hora_inicio,
    fecha_hora_fin,
    nombre_responsable,
    apellido_responsable
) VALUES
    (1001, 'Creado', 'Bolsin', TIMESTAMP '2026-07-09 09:00:00', TIMESTAMP '2026-07-09 10:00:00', 'Juan', 'Perez'),
    (1001, 'Enviado', 'Bolsin', TIMESTAMP '2026-07-09 10:00:00', NULL, 'Juan', 'Perez');

INSERT INTO remitos (id_remito, fecha_creacion, nombre_estado, ambito_estado, numero_bolsin) VALUES
    (9001, DATE '2026-07-09', 'Creado', 'Remito', 1001);

INSERT INTO sesiones (id_sesion, id_usuario, fecha_hora_inicio, fecha_hora_fin) VALUES
    (1, 1, TIMESTAMP '2026-07-09 08:30:00', NULL);
