INSERT INTO usuarios (id, nombre, password) VALUES
    (1, 'gcm.origen', '1234'),
    (2, 'gcm.destino', '1234');

INSERT INTO roles (nombre, descripcion) VALUES
    ('GCM', 'Gestor de Comision Medica'),
    ('ADMIN', 'Administrador');

INSERT INTO comisiones_medicas (codigo, direccion, email, nombre, telefono) VALUES
    ('CM-CBA-01', 'Av. Colon 100', 'cba01@example.com', 'Comision Medica Cordoba', '3511000001'),
    ('CM-CBA-02', 'Av. Velez Sarsfield 450', 'cba02@example.com', 'Comision Medica Cordoba II', '3511000002'),
    ('CM-ROS-02', 'Bv. Oroño 900', 'ros02@example.com', 'Comision Medica Rosario', '3411000002'),
    ('CM-MDZ-03', 'Av. San Martin 1200', 'mdz03@example.com', 'Comision Medica Mendoza', '2611000003'),
    ('CM-BA-01', 'Av. Corrientes 1500', 'ba01@example.com', 'Comision Medica Central', '1110000001'),
    ('CM-TUC-01', 'San Martin 650', 'tuc01@example.com', 'Comision Medica San Miguel de Tucuman', '3811000001'),
    ('CM-SLA-01', 'Belgrano 700', 'sla01@example.com', 'Comision Medica Salta', '3871000001'),
    ('CM-JUJ-01', 'Lavalle 300', 'juj01@example.com', 'Comision Medica San Salvador de Jujuy', '3881000001'),
    ('CM-NQN-01', 'Av. Argentina 200', 'nqn01@example.com', 'Comision Medica Neuquen', '2991000001'),
    ('CM-MDQ-01', 'Av. Independencia 1800', 'mdq01@example.com', 'Comision Medica Mar del Plata', '2231000001'),
    ('CM-LPL-01', 'Calle 7 850', 'lpl01@example.com', 'Comision Medica La Plata', '2211000001');

INSERT INTO empleados (nombre, apellido, email, id_usuario, id_rol, codigoCM) VALUES
    ('Juan', 'Perez', 'juan.perez@example.com', 1, 'GCM', 'CM-CBA-01'),
    ('Ana', 'Gomez', 'ana.gomez@example.com', 2, 'GCM', 'CM-ROS-02');

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
    (101, 'CM-CBA-01', 'CM-ROS-02', 5001, TIMESTAMP '2026-03-07 12:30:00', 12.50),
    (102, 'CM-ROS-02', 'CM-MDZ-03', 5002, TIMESTAMP '2026-03-07 12:32:15', 10.75),
    (103, 'CM-MDZ-03', 'CM-BA-01', 5003, TIMESTAMP '2026-03-07 12:35:04', 14.20),
    (104, 'CM-BA-01', 'CM-CBA-01', 5004, TIMESTAMP '2026-03-07 12:36:20', 9.80),
    (105, 'CM-TUC-01', 'CM-SLA-01', 5005, TIMESTAMP '2026-03-07 12:40:31', 11.30),
    (106, 'CM-SLA-01', 'CM-JUJ-01', 5006, TIMESTAMP '2026-03-07 12:43:18', 13.10),
    (107, 'CM-NQN-01', 'CM-MDQ-01', 5007, TIMESTAMP '2026-03-07 12:45:46', 15.40),
    (108, 'CM-MDQ-01', 'CM-BA-01', 5008, TIMESTAMP '2026-03-07 12:47:02', 8.90),
    (109, 'CM-LPL-01', 'CM-CBA-01', 5009, TIMESTAMP '2026-03-07 12:49:27', 12.00),
    (110, 'CM-CBA-02', 'CM-ROS-02', 5010, TIMESTAMP '2026-03-07 12:52:09', 10.10);

INSERT INTO cambios_estados_bolsin (
    numero_bolsin,
    nombre_estado,
    ambito_estado,
    fecha_hora_inicio,
    fecha_hora_fin,
    nombre_responsable,
    apellido_responsable
) VALUES
    (101, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:30:00', TIMESTAMP '2026-03-07 12:30:01', 'Juan', 'Perez'),
    (101, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:30:01', NULL, 'Juan', 'Perez'),
    (102, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:32:15', TIMESTAMP '2026-03-07 12:32:16', 'Juan', 'Perez'),
    (102, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:32:16', NULL, 'Juan', 'Perez'),
    (103, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:35:04', TIMESTAMP '2026-03-07 12:35:05', 'Juan', 'Perez'),
    (103, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:35:05', NULL, 'Juan', 'Perez'),
    (104, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:36:20', TIMESTAMP '2026-03-07 12:36:21', 'Juan', 'Perez'),
    (104, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:36:21', NULL, 'Juan', 'Perez'),
    (105, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:40:31', TIMESTAMP '2026-03-07 12:40:32', 'Juan', 'Perez'),
    (105, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:40:32', NULL, 'Juan', 'Perez'),
    (106, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:43:18', TIMESTAMP '2026-03-07 12:43:19', 'Juan', 'Perez'),
    (106, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:43:19', NULL, 'Juan', 'Perez'),
    (107, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:45:46', TIMESTAMP '2026-03-07 12:45:47', 'Juan', 'Perez'),
    (107, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:45:47', NULL, 'Juan', 'Perez'),
    (108, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:47:02', TIMESTAMP '2026-03-07 12:47:03', 'Juan', 'Perez'),
    (108, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:47:03', NULL, 'Juan', 'Perez'),
    (109, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:49:27', TIMESTAMP '2026-03-07 12:49:28', 'Juan', 'Perez'),
    (109, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:49:28', NULL, 'Juan', 'Perez'),
    (110, 'Creado', 'Bolsin', TIMESTAMP '2026-03-07 12:52:09', TIMESTAMP '2026-03-07 12:52:10', 'Juan', 'Perez'),
    (110, 'Enviado', 'Bolsin', TIMESTAMP '2026-03-07 12:52:10', NULL, 'Juan', 'Perez');

INSERT INTO remitos (id_remito, fecha_creacion, nombre_estado, ambito_estado, numero_bolsin) VALUES
    (9001, DATE '2026-03-07', 'Creado', 'Remito', 101);

INSERT INTO sesiones (id_sesion, id_usuario, fecha_hora_inicio, fecha_hora_fin) VALUES
    (1, 1, TIMESTAMP '2026-07-09 08:30:00', NULL);
