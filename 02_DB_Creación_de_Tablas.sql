-- Creación de Tabla Usuario
CREATE TABLE Usuario (
    idUsuario INTEGER PRIMARY KEY NOT NULL,
    usuario VARCHAR(10) NOT NULL,
    contraseña VARCHAR(10) NOT NULL,
    nombre VARCHAR(25) NOT NULL,
    apellido VARCHAR(25) NOT NULL,
    telefono INTEGER,
    correo VARCHAR(50),
    puesto SMALLINT NOT NULL
);

-- Creación de Tabla Cliente
CREATE TABLE Cliente (
    idCliente INTEGER PRIMARY KEY NOT NULL,
    nombreFantasia VARCHAR(50),
    razonSocial VARCHAR(50) NOT NULL,
    TipoDoc BOOLEAN NOT NULL,  -- 0 CUIT / 1 CUIL
    NroDoc INTEGER NOT NULL,
    telefono INTEGER NOT NULL,
    situacionIVA SMALLINT NOT NULL,  -- 0 Excento / 1 Monotributo / 2 Responsable Inscripto / 3 Consumidor Final
    tipoPersona BOOLEAN NOT NULL     -- 0 fisica / 1 Jurídica
);

-- Creación de Tabla Liquidación
CREATE TABLE Liquidacion (
    idLiquidacion INTEGER PRIMARY KEY NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    tipoLiquidacion SMALLINT NOT NULL  -- 0 Mensual / 1 Bimestral / 2 Cuatrimestral / 3 Semestral / 4 Anual
);

-- Creación de Tabla GrupoVencimiento
CREATE TABLE GrupoVencimiento (
    idGrupoVencimiento INTEGER PRIMARY KEY NOT NULL,
    idCliente INTEGER NOT NULL,
    idLiquidacion INTEGER NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idLiquidacion) REFERENCES Liquidacion(idLiquidacion)
);

-- Creación de Tabla LiqVencimientos
CREATE TABLE LiqVencimientos (
    idVencimiento INTEGER PRIMARY KEY NOT NULL,
    idLiquidacion INTEGER NOT NULL,
    fechaVencimiento DATE NOT NULL,
    idGrupoVencimiento INTEGER NOT NULL,
    FOREIGN KEY (idLiquidacion) REFERENCES Liquidacion(idLiquidacion),
    FOREIGN KEY (idGrupoVencimiento) REFERENCES GrupoVencimiento(idGrupoVencimiento)
);

-- Creación de Tabla LiqVencCli
CREATE TABLE LiqVencCli (
    idCliente INTEGER NOT NULL,
    idVencimiento INTEGER NOT NULL,
    idLiquidacion INTEGER NOT NULL,
    importe NUMERIC(10, 2) NOT NULL,
    estado SMALLINT NOT NULL,  -- 0 Calculado / 1 En progreso / 2 Informado / 3 Pago / 4 Finalizado
    idUsuario INTEGER NOT NULL,
    PRIMARY KEY (idCliente, idVencimiento, idLiquidacion),
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idVencimiento) REFERENCES LiqVencimientos(idVencimiento),
    FOREIGN KEY (idLiquidacion) REFERENCES Liquidacion(idLiquidacion),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

-- Creación de Tabla Comprobante
CREATE TABLE Comprobante (
    idComprobante INTEGER PRIMARY KEY NOT NULL,
    entidad VARCHAR(25) NOT NULL,
    nroControl INTEGER NOT NULL,
    nroComp INTEGER NOT NULL,
    nroTrans INTEGER NOT NULL,
    idCliente INTEGER NOT NULL,
    idUsuario INTEGER NOT NULL,
    idTrans BOOLEAN NOT NULL,  -- 0 Transferencia / 1 Depósito
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

-- Creación de Tabla Transacción
CREATE TABLE Transaccion (
    idTransaccion INTEGER PRIMARY KEY NOT NULL,
    idCliente INTEGER NOT NULL,
    tipoTransaccion BOOLEAN NOT NULL,  -- 0 Ingreso / 1 Egreso
    monto NUMERIC(10, 2) NOT NULL,
    fechaHoraTrans DATETIME NOT NULL,
    fechaHoraComp DATETIME,
    idComprobante INTEGER,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idComprobante) REFERENCES Comprobante(idComprobante)
);