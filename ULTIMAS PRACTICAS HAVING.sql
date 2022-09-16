-- 1. Se solicita un listado de artículos cuyo precio es inferior al promedio de
-- precios de todos los artículos. (está resuelto en el material teórico)
SELECT descripcion, pre_unitario
from articulos a
where pre_unitario < (select avg(pre_unitario)
                    from articulos ar
                    )
select avg(pre_unitario)
                    from articulos ar

-- 2. Emitir un listado de los artículos que no fueron vendidos este año. En
-- ese listado solo incluir aquellos cuyo precio unitario del artículo oscile
-- entre 50 y 100.
SELECT descripcion, pre_unitario
from articulos
where pre_unitario BETWEEN 50 and 100
and cod_articulo not in (select ar.cod_articulo
                       from articulos ar join detalle_facturas DE 
                       on ar.cod_articulo = de.cod_articulo
                       join facturas f on de.nro_factura = f.nro_factura
                       where YEAR(fecha) = YEAR(GETDATE()))

-- 3. Genere un reporte con los clientes que vinieron más de 2 veces el año
-- pasado.
SELECT c.cod_cliente,ape_cliente+' '+nom_cliente'Cliente'
,COUNT(nro_factura)'Cantidad de Veces que Compro el Año pasado'
from clientes c join facturas f on c.cod_cliente = f.cod_cliente
where YEAR(fecha) = YEAR(GETDATE())-1
group by c.cod_cliente,ape_cliente+' '+nom_cliente
HAVING COUNT(nro_factura) > 2


-- 4. Se quiere saber qué clientes no vinieron entre el 12/12/2010 y el 13/7/2015
select c.cod_cliente,ape_cliente+' '+nom_cliente'Cliente'
from clientes C join facturas f on c.cod_cliente = f.cod_cliente
where c.cod_cliente in (select fa.cod_cliente
                        from facturas fa
                        where fecha not between '12/12/2010' and '13/7/2015')

-- 5. Listar los datos de las facturas de los clientes que solo vienen a comprar
-- en febrero es decir que todas las veces que vinen a comprar haya sido
-- en el mes de febrero (y no otro mes).
SELECT c.cod_cliente,ape_cliente+' '+nom_cliente'Cliente',fecha
from clientes c join facturas fa on c.cod_cliente = fa.cod_cliente
where c.cod_cliente in(select f.cod_cliente
                    from facturas f
                    where month(fecha) = 2
                    and c.cod_cliente=f.cod_cliente)
and c.cod_cliente not in(select f.cod_cliente
                    from facturas f
                    where month(fecha) != 2
                    and c.cod_cliente=f.cod_cliente)

-- 6. Muestrar los datos de las facturas para los casos en que por año se
-- hayan hecho menos de 9 facturas.
SELECT nro_factura,fecha,COUNT(nro_factura)'Cantidad de Fact por Año'
from facturas f
group by YEAR(fecha),nro_factura,fecha
HAVING COUNT(nro_factura) < 9

select * FROM
facturas where year(fecha) in (select year(fecha)
                                from facturas f group by year(fecha)
                                having COUNT(*)<9)


-- 7. Emitir un reporte con las facturas cuyo importe total haya sido superior a
-- 1.500 (incluir en el reporte los datos de los artículos vendidos y los
-- importes).
SELECT f.nro_factura,sum(de.pre_unitario*cantidad)'Importe Total',
de.cod_articulo,descripcion'Articulo',cantidad,de.pre_unitario'Importe'
from facturas f join detalle_facturas de 
on f.nro_factura = de.nro_factura
join articulos a on de.cod_articulo = a.cod_articulo
group by f.nro_factura,de.cod_articulo,descripcion ,de.pre_unitario,cantidad
HAVING sum(de.pre_unitario*cantidad) > 1500


-- 8. Se quiere saber qué vendedores nunca atendieron a estos clientes: 1 y 6.
-- Muestre solamente el nombre del vendedor.
SELECT distinct ape_vendedor+' '+nom_vendedor 'Vendedor'
from vendedores v 
where v.cod_vendedor not in (select fa.cod_vendedor
                            from facturas fa
                            join clientes c on fa.cod_cliente = c.cod_cliente
                            where c.cod_cliente in (1,6))

-- 9. Listar los datos de los artículos que superaron el promedio del Importe
-- de ventas de $ 1.000.
SELECT a.cod_articulo,a.descripcion,avg(de.pre_unitario*cantidad)'Importe'
from articulos a join detalle_facturas DE
on a.cod_articulo = de.cod_articulo
group by a.cod_articulo,a.descripcion
having avg(de.pre_unitario*cantidad) > 1000

-- 10. ¿Qué artículos nunca se vendieron? Tenga además en cuenta que su
-- nombre comience con letras que van de la “d” a la “p”. Muestre
-- solamente la descripción del artículo.
SELECT descripcion'Articulo'
from articulos a 
where descripcion like '[D-P]%'
and a.cod_articulo not in(select de.cod_articulo
                    from detalle_facturas de)


-- 11. Listar número de factura, fecha y cliente para los casos en que ese
-- cliente haya sido atendido alguna vez por el vendedor de código 3.
SELECT nro_factura, fecha, ape_cliente+' '+nom_cliente'Cliente'
from facturas f join clientes c 
on f.cod_cliente = c.cod_cliente
where f.cod_cliente = ANY (select fa.cod_cliente
                            from facturas Fa 
                            where cod_vendedor = 3)                         

-- 12. Listar número de factura, fecha, artículo, cantidad e importe para los
-- casos en que todas las cantidades (de unidades vendidas de cada
-- artículo) de esa factura sean superiores a 40.
SELECT f.nro_factura, fecha, descripcion, cantidad, de.pre_unitario,
sum(cantidad)'Cantidad de Articulos por Factura'
from facturas f join detalle_facturas de 
on f.nro_factura = de.nro_factura
join articulos a on a.cod_articulo = de.cod_articulo
group by f.nro_factura, fecha, descripcion, cantidad, de.pre_unitario
having sum(cantidad) > 40


-- 13. Emitir un listado que muestre número de factura, fecha, artículo,
-- cantidad e importe; para los casos en que la cantidad total de unidades
-- vendidas sean superior a 80.
SELECT f.nro_factura, fecha, descripcion, cantidad, de.pre_unitario,
sum(cantidad)'Cantidad de Articulos por Factura'
from facturas f join detalle_facturas de 
on f.nro_factura = de.nro_factura
join articulos a on a.cod_articulo = de.cod_articulo
group by f.nro_factura, fecha, descripcion, cantidad, de.pre_unitario
having sum(cantidad) > 80

-- 14. Realizar un listado de número de factura, fecha, cliente, artículo e
-- importe para los casos en que al menos uno de los importes de esa
-- factura sean menores a 3.000.
SELECT f.nro_factura, fecha, descripcion, cantidad, de.pre_unitario,
ape_cliente+' '+nom_cliente'Cliente',sum(de.pre_unitario*cantidad)'Importe'
from facturas f join detalle_facturas de 
on f.nro_factura = de.nro_factura
join articulos a on a.cod_articulo = de.cod_articulo
join clientes c on f.cod_cliente = c.cod_cliente
group by f.nro_factura, fecha, descripcion, cantidad, de.pre_unitario,
ape_cliente+' '+nom_cliente
having sum(de.pre_unitario*cantidad) < 3000

-- 1. Se quiere saber ¿cuándo realizó su primer venta cada vendedor? y
-- ¿cuánto fue el importe total de las ventas que ha realizado? Mostrar
-- estos datos en un listado solo para los casos en que su importe
-- promedio de vendido sea superior al importe promedio general (importe
-- promedio de todas las facturas).
SELECT min(fecha)'Primera Venta',ape_vendedor+' '+nom_vendedor'Vendedor',
AVG(pre_unitario*cantidad)'Promedio Importe'
from facturas f join vendedores v 
on f.cod_vendedor = v.cod_vendedor
join detalle_facturas de on f.nro_factura = de.nro_factura
group by ape_vendedor+' '+nom_vendedor
HAVING AVG(pre_unitario*cantidad) > (select AVG(de1.pre_unitario*de1.cantidad)
                                    from facturas fa join detalle_facturas de1
                                    on fa.nro_factura = de1.nro_factura)


-- 3. Emitir un listado con los datos de los clientes y sus vendedores
--(por ejemplo: nombre, dirección, teléfono, 
--fecha de compra, etc.) que nunca vinieron el año pasado.
SELECT ape_cliente'Cliente',ape_vendedor'Vendedor',
f.fecha'Fecha de Compra'
from FACTURAS f join vendedores V
on f.cod_vendedor = v.cod_vendedor
join clientes c on f.cod_cliente = f.cod_cliente
where c.cod_cliente not in (select cod_cliente
                            from facturas fa
                            where year(fa.fecha)=year(GETDATE())-1)

SELECT ape_cliente'Cliente',ape_vendedor'Vendedor',
f.fecha'Fecha de Compra'
from FACTURAS f join vendedores V
on f.cod_vendedor = v.cod_vendedor
join clientes c on f.cod_cliente = f.cod_cliente
where not EXISTS (select fa.fecha
                            from facturas fa
                            where year(fa.fecha)=year(GETDATE())-1
                            and c.cod_cliente = fa.cod_cliente)


--4. Muestre por cada médico que atiende en esta veterinaria, 
--cuantas consultas atendió, cual fue la fecha de la primera 
--y última consulta, el total del importe cobrado este mes, 
--donde esa cantidad de consultas sea menor que la cantidad de consultas 
--atendidas por ese médico el mes pasado.

SELECT MONTH(FEC_CONSULTA)'MES' ,COUNT(*)'CANTIDAD DE CONSULTAS', NOM_MEDICO'MEDICO',
MIN(FEC_CONSULTA)'PRIMERA CONSULTA', MAX(FEC_CONSULTA)'ULTIMA CONSULTA',
SUM(C.IMPORTE)'TOTAL COBRADO ESTE MES'
FROM CONSULTAS C JOIN MEDICOS M
ON C.COD_MEDICO = M.COD_MEDICO
where MONTH(c.fec_consulta) = MONTH(GETDATE())
and YEAR(c.fec_consulta) = YEAR(GETDATE()
GROUP BY m.COD_MEDICO ,NOM_MEDICO, MONTH(FEC_CONSULTA)
HAVING COUNT(*) < (SELECT COUNT(*)
		FROM CONSULTAS CO
		WHERE MONTH(FEC_CONSULTA) = MONTH(GETDATE())-1
		AND YEAR(FEC_CONSULTA) = YEAR(GETDATE())
		AND C.COD_MEDICO = CO.COD_MEDICO)

select m.nom_medico as Medico,count(*) as 'Cantidad de Consultas',min(c.fec_consulta) as 'Primera Consulta',max(c.fec_consulta) as 'Ultima Consulta',sum(importe)
from consultas c
join medicos m on m.cod_medico = c.cod_medico
where MONTH(c.fec_consulta) = MONTH(GETDATE())
and YEAR(c.fec_consulta) = YEAR(GETDATE()
group by c.cod_medico,m.nom_medico
having count(*) < (select count(*) from
consultas con
where MONTH(DATEADD(MONTH,-1,GETDATE())) = MONTH(con.fec_consulta)
AND YEAR(DATEADD(MONTH,-1,GETDATE())) = YEAR(con.fec_consulta)
AND c.cod_medico = con.cod_medico)


--OTRAS SUBCONSULTAS
--LISTAR EL PRECIO DE LOS ARTICULOS Y LA DIFERENCIA DE ESTE
--CON EL PRECIO DEL ARTICULO MAS CARO
SELECT descripcion'Articulo',pre_unitario'precio',
(select MAX(ar.pre_unitario) from articulos ar) - pre_unitario'Diferencia con el Art Mas caro'
FROM articulos A

--LISTAR EL PRECIO ACTUAL DE LOS ARTICULOS Y EL PRECIO HISTORICO 
--VENDIDO MAS BAJO
SELECT descripcion'Articulo',pre_unitario'Precio Actual',
(select min(de.pre_unitario) from detalle_facturas de
where a.cod_articulo = de.cod_articulo)'Precio Historico mas Bajo'
FROM articulos a
 
--LISTAR DE DE LAS FACTURAS DEL AÑO EN CURSO DETALLANDO SUS DATOS
--Y TOTAL



-- 5. Se quiere saber el promedio del importe vendido y la fecha de la primer
-- venta por fecha y artículo para los casos en que las cantidades vendidas
-- oscilen entre 5 y 20 y que ese importe sea superior al importe promedio
-- de ese artículo.


-- 6. Emita un listado con los montos diarios facturados que sean inferior al
-- importe promedio general.


-- 7. Se quiere saber la fecha de la primera y última venta, el importe total
-- facturado por cliente para los años que oscilen entre el 2007 y 2010 y que
-- el importe promedio facturado sea menor que el importe promedio total
-- para ese cliente. 

-- 2. Liste los montos totales mensuales facturados por cliente y además del
-- promedio de ese monto y el promedio de precio de artículos Todos esto
-- datos correspondientes a período que va desde el 1° de febrero al 30 de
-- agosto del 2014. Sólo muestre los datos si esos montos totales son
-- superiores o iguales al promedio global.


-- 3. Por cada artículo que se tiene a la venta, se quiere saber el importe
-- promedio vendido, la cantidad total vendida por artículo, para los casos
-- en que los números de factura no sean uno de los siguientes: 2, 10, 7, 13,
-- 22 y que ese importe promedio sea inferior al importe promedio de ese
-- artículo.


-- 4. Listar la cantidad total vendida, el importe y promedio vendido por fecha,
-- siempre que esa cantidad sea superior al promedio de la cantidad global.
-- Rotule y ordene.
            


