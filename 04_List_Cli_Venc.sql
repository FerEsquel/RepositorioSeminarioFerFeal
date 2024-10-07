-- Listado de vencimientos por cliente (corregido)
SELECT 
    Cliente.nombreFantasia AS Cliente,
    Cliente.razonSocial AS RazonSocial,
    Liquidacion.descripcion AS Impuesto,
    LiqVencimientos.fechaVencimiento AS FechaVencimiento,
    LiqVencCli.importe AS Importe,
    CASE 
        WHEN LiqVencCli.estado = 0 THEN 'Pendiente'
        WHEN LiqVencCli.estado = 1 THEN 'Pagado'
        ELSE 'En Revisión'
    END AS Estado,
    Usuario.usuario
FROM 
    Cliente
INNER JOIN 
    GrupoVencimiento ON Cliente.idCliente = GrupoVencimiento.idCliente
INNER JOIN 
    Liquidacion ON GrupoVencimiento.idLiquidacion = Liquidacion.idLiquidacion
LEFT JOIN 
    LiqVencimientos ON GrupoVencimiento.idGrupoVencimiento = LiqVencimientos.idGrupoVencimiento
LEFT JOIN 
    LiqVencCli ON Cliente.idCliente = LiqVencCli.idCliente 
    AND LiqVencimientos.idVencimiento = LiqVencCli.idVencimiento
LEFT JOIN 
    Usuario ON LiqVencCli.idUsuario = Usuario.idUsuario
ORDER BY 
    Cliente.nombreFantasia, LiqVencimientos.fechaVencimiento;
