--OPERADORES COMPARACION =,<>,>,<, <=, >=
--COMPARA EL VALOR DE UNA EXPRESION CON LA SUBCONSULTA
--TEST DE COMPARACION
--LISTADO DE ARTICULOS CUYOS PRECIOS SON MENORES AL PROMEDIO
SELECT *
FROM articulos WHERE pre_unitario <
(SELECT AVG(pre_unitario)
FROM articulos)

--TESTE DE PERTENENCIA AL CONJUNTO
--OPERADOR IN

--LISTAR LOS DATOS DE LOS CLIENTES QUE COMPRARON ESTE AÑO
SELECT C.cod_cliente,nom_cliente
FROM clientes C 
WHERE C.cod_cliente IN (SELECT cod_cliente
                FROM facturas 
                WHERE YEAR(fecha)=YEAR(GETDATE()))

--LISTAR LOS DATOS DE LOS CLIENTES QUE NO COMPRARON EL AÑO PASADO
SELECT C.cod_cliente,nom_cliente
FROM clientes C 
WHERE C.cod_cliente NOT IN (SELECT cod_cliente
                FROM facturas 
                WHERE YEAR(fecha)=YEAR(GETDATE())-1)

--TEST DE EXISTENCIA
--OPERADOR EXISTS SOLAMENTE SE UTILIZA CON SUBCONSULTAS
--LISTAR LOS DATOS DE LOS CLIENTES QUE COMPRARON ESTE AÑO
SELECT cod_cliente,ape_cliente+' '+nom_cliente'Cliente'
FROM clientes C
where exists(select cod_cliente
            from facturas F
            where year(fecha)=year(getdate())
            and c.cod_cliente = f.cod_cliente)

--listar los datos de los clientes que no compraron el año pasado
SELECT cod_cliente,ape_cliente+' '+nom_cliente'Cliente'
FROM clientes C
where not exists(select cod_cliente
            from facturas F
            where year(fecha)=year(getdate())-1
            and c.cod_cliente = f.cod_cliente)

--TEST CUANTIFICADOS
--OPERADORES ANY, ALL JUNTO CON OPERADORES DE COMPARACION(=,<>,>,<, <=, >=)
--EL TEST ANY COMPRUEBA QUE ALGUNA DE LAS COMPARACIONES SEA VERDADERAS
--EL TEST ALL COMPRUEBA QUE TODAS LAS COMPARACIONES SEAN VERDADERAS

--LISTAR LOS CLIENTES QUE ALGUNA VEZ COMPRARON UN PRODUCTO MENOR A $10
SELECT c.cod_cliente,ape_cliente+' '+nom_cliente'Cliente'
from clientes c 
where 10 > any (SELECT pre_unitario
                        from facturas f join detalle_facturas de 
                        on f.nro_factura = de.nro_factura
                        where c.cod_cliente = f.cod_cliente
                        )

--SE QUIERE LISTAR LOS CLIENTES QUE SIEMPRE FUERON ATENDIDOS POR EL VENDEDOR 3
SELECT c.cod_cliente,ape_cliente+' '+nom_cliente'Cliente'
from clientes c 
where 3 = ALL(SELECT V.cod_vendedor
            FROM vendedores V JOIN facturas F
            ON V.cod_vendedor = F.cod_vendedor
            WHERE C.cod_cliente =F.cod_cliente)

-- 1. Se solicita un listado de artículos cuyo precio es inferior al promedio de
-- precios de todos los artículos. (está resuelto en el material teórico)
SELECT *
from articulos a

-- 2. Emitir un listado de los artículos que no fueron vendidos este año. En
-- ese listado solo incluir aquellos cuyo precio unitario del artículo oscile
-- entre 50 y 100.
SELECT cod_articulo,descripcion
from articulos a 
where cod_articulo not in(select cod_articulo
                    from facturas f join detalle_facturas de 
                    on f.nro_factura = de.nro_factura
                    where year(fecha) = year(GETDATE())
                    and pre_unitario BETWEEN 50 and 100
) 

-- 3. Genere un reporte con los clientes que vinieron más de 2 veces el año
-- pasado.
SELECT c.cod_cliente, ape_cliente+' '+nom_cliente'Cliente'
from clientes c
where 2 < any(select cod_cliente
            from facturas f join detalle_facturas de
            on f.nro_factura = de.nro_factura
            where year(fecha) = year(GETDATE())-1
            and c.cod_cliente = f.cod_cliente
)

-- 4. Se quiere saber qué clientes no vinieron entre el 12/12/2010 y el 13/7/2015
SELECT cod_cliente,ape_cliente+' '+nom_cliente'Cliente'
from clientes c
where cod_cliente not in(select cod_cliente
                        from facturas F 
                        where fecha  between '12/12/2010' and '13/7/2015'
                        and c.cod_cliente=f.cod_cliente
)

select cod_cliente,ape_cliente
from clientes c
where cod_cliente not in (select f.cod_cliente
from facturas f
where (f.fecha between '12-12-2010' and '13-07-2015'))

-- 5. Listar los datos de las facturas de los clientes que solo vienen a comprar
-- en febrero es decir que todas las veces que vinen a comprar haya sido
-- en el mes de febrero (y no otro mes).
select cod_cliente,ape_cliente
from clientes c
where 2 = ALL (select MONTH(fecha)
                from facturas F
                where c.cod_cliente = f.cod_cliente)


-- 6. Muestrar los datos de las facturas para los casos en que por año se
-- hayan hecho menos de 9 facturas.
SELECT nro_factura 
from facturas
where YEAR(fecha) in (select YEAR(fecha) 
                      from facturas f  
                      group by YEAR(fecha) 
                     having COUNT(nro_factura)<9)

-- 7. Emitir un reporte con las facturas cuyo importe total haya sido superior a
-- 1.500 (incluir en el reporte los datos de los artículos vendidos y los
-- importes).

SELECT df.nro_factura,descripcion,a.pre_unitario,cantidad
from detalle_facturas df join articulos a
on a.cod_articulo = df.cod_articulo
WHERE df.nro_factura in  (SELECT f.nro_factura  FROM  facturas f join detalle_facturas de
         on de.nro_factura = f.nro_factura
                         GROUP by f.nro_factura having sum(cantidad*pre_unitario)>1500)


-- 8. Se quiere saber qué vendedores nunca atendieron a estos clientes: 1 y 6.
-- Muestre solamente el nombre del vendedor.
SELECT nom_vendedor+' '+ape_vendedor 'Vendedor'
from vendedores v
where cod_vendedor not in(select cod_vendedor
                        from facturas f 
                        where cod_cliente in (1,6)
                        and f.cod_vendedor = v.cod_vendedor
)

-- 9. Listar los datos de los artículos que superaron el promedio del Importe
-- de ventas de $ 1.000.
SELECT cod_articulo,descripcion,pre_unitario
from articulos a
where 1000 < (select avg(pre_unitario*cantidad)
            from detalle_facturas de 
            where a.cod_articulo = de.cod_articulo
            )
            
-- 10. ¿Qué artículos nunca se vendieron? Tenga además en cuenta que su
-- nombre comience con letras que van de la “d” a la “p”. Muestre
-- solamente la descripción del artículo.
SELECT descripcion
from articulos A
where cod_articulo not in(select cod_articulo
                    from detalle_facturas de                    
                    where a.cod_articulo=de.cod_articulo) and descripcion like '[D-P]%'

-- 11. Listar número de factura, fecha y cliente para los casos en que ese
-- cliente haya sido atendido alguna vez por el vendedor de código 3.
SELECT distinct nro_factura,fecha,ape_cliente+' '+nom_cliente 'Cliente',cod_vendedor
from facturas F join clientes C
on f.cod_cliente = c.cod_cliente
where cod_vendedor in (select cod_vendedor
                        from facturas f 
                        where cod_vendedor = 3
)

-- 12. Listar número de factura, fecha, artículo, cantidad e importe para los
-- casos en que todas las cantidades (de unidades vendidas de cada
-- artículo) de esa factura sean superiores a 40.
SELECT f.nro_factura,fecha,descripcion,cantidad,de.pre_unitario
from facturas f join detalle_facturas de 
on f.nro_factura = de.nro_factura
join articulos a on a.cod_articulo = de.cod_articulo
where f.nro_factura in (select fa.nro_factura
                    from facturas fa join detalle_facturas d
                    on fa.nro_factura = d.nro_factura
                    where de.cantidad > 40)


-- 13. Emitir un listado que muestre número de factura, fecha, artículo,
-- cantidad e importe; para los casos en que la cantidad total de unidades
-- vendidas sean superior a 80.
SELECT f.nro_factura,fecha,descripcion,cantidad,de.pre_unitario
from facturas f join detalle_facturas de 
on f.nro_factura = de.nro_factura
join articulos a on a.cod_articulo = de.cod_articulo
where f.nro_factura in (select fa.nro_factura
                    from facturas fa join detalle_facturas d
                    on fa.nro_factura = d.nro_factura
                    where de.cantidad > 80)

-- 14. Realizar un listado de número de factura, fecha, cliente, artículo e
-- importe para los casos en que al menos uno de los importes de esa
-- factura sean menores a 3.000.
SELECT f.nro_factura,fecha,descripcion,de.pre_unitario,cod_cliente
from facturas f join detalle_facturas de 
on f.nro_factura = de.nro_factura
join articulos a on a.cod_articulo = de.cod_articulo
where 3000 < any(select sum(pre_unitario*cantidad)
                from facturas fa join detalle_facturas DE
                on fa.nro_factura = de.nro_factura
                where fa.nro_factura = f.nro_factura
                )

  