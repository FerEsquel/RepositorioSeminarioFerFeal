SELECT 
    Cliente.nombreFantasia AS Cliente,
    Liquidacion.descripcion AS Impuesto,
    LiqVencimientos.fechaVencimiento AS FechaVencimiento,
    LiqVencCli.importe AS Importe,
    Usuario.nombre AS Gestor
FROM 
    LiqVencCli
INNER JOIN 
    Cliente ON LiqVencCli.idCliente = Cliente.idCliente
INNER JOIN 
    Liquidacion ON LiqVencCli.idLiquidacion = Liquidacion.idLiquidacion
INNER JOIN 
    LiqVencimientos ON LiqVencCli.idVencimiento = LiqVencimientos.idVencimiento
INNER JOIN 
    Usuario ON LiqVencCli.idUsuario = Usuario.idUsuario
WHERE 
    LiqVencCli.estado <> 4  -- Vencimientos pendientes
    AND Cliente.idCliente = 1  -- ID del cliente según corresponda
ORDER BY 
    LiqVencimientos.fechaVencimiento;
