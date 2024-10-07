-- Inserts en la tabla Usuario
INSERT INTO Usuario (idUsuario, usuario, contraseña, nombre, apellido, telefono, correo, puesto) 
VALUES (1, 'ffeal', '123456', 'Fernando', 'Feal', 11454545, 'fernandofeal@live.com', 1),
       (2, 'marzaguet', '123457', 'Micaela', 'Arzaguet', 11464646, 'micaarzaguet@hotmail.com', 1),
       (3, 'pblanchod', '123458', 'Patricia', 'Blanchod', 11474747, 'patriciablanchod@gmail.com', 1);

-- Inserts en la tabla Cliente
INSERT INTO Cliente (idCliente, nombreFantasia, razonSocial, TipoDoc, NroDoc, telefono, situacionIVA, tipoPersona) 
VALUES (1, 'Fantasía 1', 'Razon Social 1', 0, 28778457, 11414141, 2, 0),
       (2, 'Fantasía 2', 'Razon Social 2', 0, 45678901, 11424242, 2, 0),
       (3, 'Fantasía 3', 'Razon Social 3', 0, 33654321, 115434343, 3, 0);

-- Inserts en la tabla Liquidación
INSERT INTO Liquidacion (idLiquidacion, descripcion, tipoLiquidacion) 
VALUES (1, 'IIBB', 0), -- Mensual
       (2, 'IVA', 4), -- Mensual
       (3, 'Ganancias y Bienes Personales', 4), -- Anual
       (4, 'Recategorización Monotributo', 3); -- Semestral

-- Inserts en la tabla GrupoVencimiento
INSERT INTO GrupoVencimiento (idGrupoVencimiento, idCliente, idLiquidacion) 
VALUES (1, 1, 2),
       (2, 2, 2),
       (3, 3, 2);

-- Inserts en la tabla LiqVencimientos
INSERT INTO LiqVencimientos (idVencimiento, idLiquidacion, fechaVencimiento, idGrupoVencimiento) 
VALUES (1, 2, '2024-10-01', 1),
       (2, 2, '2024-10-02', 2),
       (3, 2, '2024-10-03', 3);

-- Inserts en la tabla LiqVencCli
INSERT INTO LiqVencCli (idCliente, idVencimiento, idLiquidacion, importe, estado, idUsuario) 
VALUES (1, 1, 2, 10000.50, 0, 1),
       (2, 2, 2, 20000.75, 1, 1),
       (3, 3, 2, 30000.00, 2, 2);

-- Inserts en la tabla Comprobante
INSERT INTO Comprobante (idComprobante, entidad, nroControl, nroComp, nroTrans, idCliente, idUsuario, idTrans) 
VALUES (1, 'Bco Chubut', 12345, 101, 1001, 1, 1, 1),
       (2, 'Bco Chubut', 67890, 223, 1011, 2, 1, 2),
       (3, 'Bco Chubut', 11223, 355, 1113, 3, 3, 3);

-- Inserts en la tabla Transacción
INSERT INTO Transaccion (idTransaccion, idCliente, tipoTransaccion, monto, fechaHoraTrans, fechaHoraComp, idComprobante) 
VALUES (1, 1, 0, 500.00, '2024-09-29 10:30:00', '2024-10-01 11:00:00', 1),
       (2, 2, 0, 1500.00, '2024-09-29 12:00:00', '2024-10-02 12:30:00', 2),
       (3, 3, 0, 2500.00, '2024-09-30 09:45:00', '2024-10-03 10:15:00', 3);