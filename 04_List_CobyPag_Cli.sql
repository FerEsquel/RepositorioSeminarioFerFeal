-- Listado de pagos y cobros recibidos para un cliente en particular
SELECT 
    Transaccion.idTransaccion,
    Cliente.nombreFantasia AS Cliente,
    Transaccion.tipoTransaccion AS TipoTransaccion,
    CASE 
        WHEN Transaccion.tipoTransaccion = 0 THEN 'Cobro'
        WHEN Transaccion.tipoTransaccion = 1 THEN 'Pago'
        ELSE 'Otro'
    END AS Tipo,
    Transaccion.monto AS Monto,
    Transaccion.fechaHoraTrans AS FechaTransaccion,
    Comprobante.entidad AS Entidad,
    Comprobante.nroComp AS NumeroComprobante
FROM 
    Transaccion
INNER JOIN 
    Cliente ON Transaccion.idCliente = Cliente.idCliente
INNER JOIN 
    Comprobante ON Transaccion.idComprobante = Comprobante.idComprobante
WHERE 
    Cliente.idCliente = 1  -- ID según el cliente
ORDER BY 
    Transaccion.fechaHoraTrans;
