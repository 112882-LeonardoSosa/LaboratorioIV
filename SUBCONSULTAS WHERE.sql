--SUB CONSULTAS EN EL WHERE
--TEST DE COMPARACION
--LISTADO DE ARTICULOS CUYOS PRECIOS SON MENORES AL PROMEDIO

SELECT cod_articulo, descripcion, pre_unitario
FROM articulos
WHERE pre_unitario < (select avg(pre_unitario)--PRODUCE UNA UNICA FILA DE RESULTADOS
                    from articulos a )--CONSULTA SUMARIA

--TESTE DE PERTENENCIA AL CONJUNTO
--OPERADOR IN
--LISTAR LOS DATOS DE LOS CLIENTES QUE COMPRARON ESTE AÑO
SELECT C.cod_cliente, ape_cliente+' '+nom_cliente 'Cliente'
FROM facturas F JOIN clientes C 
ON F.cod_cliente = C.cod_cliente
where f.cod_cliente in(select cod_cliente
                    from facturas fa 
                    where YEAR(fecha)=year(GETDATE()))

 --LISTAR LOS DATOS DE LOS CLIENTES QUE NO COMPRARON EL AÑO PASADO                   
SELECT C.cod_cliente, ape_cliente+' '+nom_cliente 'Cliente'
FROM facturas F JOIN clientes C 
ON F.cod_cliente = C.cod_cliente
where f.cod_cliente NOT in(select cod_cliente
                    from facturas fa 
                    where YEAR(fecha)=year(GETDATE())-1 )

--OPERADOR EXISTS
--LISTAR LOS DATOS DE LOS CLIENTES QUE COMPRARON ESTE AÑO
SELECT C.cod_cliente, ape_cliente+' '+nom_cliente 'Cliente'
FROM clientes C 
where EXISTS (SELECT cod_cliente
                FROM facturas f 
                where year(fecha)= year(GETDATE())
                and c.cod_cliente = f.cod_cliente)

--LISTAR LOS DATOS DE LOS CLIENTES QUE NO COMPRARON EL AÑO PASADO
SELECT C.cod_cliente, ape_cliente+' '+nom_cliente 'Cliente'
FROM clientes C 
where NOT EXISTS (SELECT cod_cliente
                FROM facturas f 
                where year(fecha)= year(GETDATE())-1
                and c.cod_cliente = f.cod_cliente)

--TEST CUANTIFICADOS
--ANY
--LISTAR LOS CLIENTES QUE ALGUNA VEZ COMPRARON UN PRODUCTO MENOR A $10
SELECT C.cod_cliente, ape_cliente+' '+nom_cliente 'Cliente'
FROM clientes C 
WHERE 10 > ANY (SELECT pre_unitario
                FROM detalle_facturas DE JOIN facturas f
                ON DE.nro_factura=F.nro_factura
                )

--ALL
--LISTAR LOS CLIENTES QUE SIEMPRE FUERON ATENDIDOS POR EL VENDEDOR 3
SELECT C.cod_cliente, ape_cliente+' '+nom_cliente 'Cliente'
FROM clientes C 
WHERE 3 = ALL  (SELECT COD_VENDEDOR
                FROM facturas F
                WHERE C.cod_cliente = F.cod_cliente)
                
