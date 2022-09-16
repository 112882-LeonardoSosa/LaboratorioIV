-- 1. Se quiere saber ¿cuándo realizó su primer venta cada vendedor? y
-- ¿cuánto fue el importe total de las ventas que ha realizado? Mostrar
-- estos datos en un listado solo para los casos en que su importe
-- promedio de vendido sea superior al importe promedio general (importe
-- promedio de todas las facturas).
SELECT distinct v.cod_vendedor, min(fecha)'Primera Venta',
sum(cantidad*pre_unitario) 'Importe Total de Ventas'
FROM facturas F JOIN detalle_facturas DE 
ON F.nro_factura = DE.nro_factura
JOIN vendedores V ON V.cod_vendedor = F.cod_vendedor
group by v.cod_vendedor, cantidad*pre_unitario, fecha
having 3 > AVG(cantidad*pre_unitario)


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
SELECT f.nro_factura, sum(cantidad)'Cantidad Total Vendida',

from facturas f join detalle_facturas d 
on f.nro_factura = d.nro_factura


-- 5. Se quiere saber el promedio del importe vendido y la fecha de la primer
-- venta por fecha y artículo para los casos en que las cantidades vendidas
-- oscilen entre 5 y 20 y que ese importe sea superior al importe promedio
-- de ese artículo.
SELECT avg(de.pre_unitario)'Promedio Importe Vendido',
min(fecha)'Primera Venta',descripcion 'Articulo',
sum(cantidad)'Cantidades Vendidas'
from facturas f join detalle_facturas DE
on f.nro_factura = de.nro_factura
join articulos a on de.cod_articulo = a.cod_articulo
group by cantidad,descripcion
HAVING sum(cantidad) between 5 and 20
and avg(de.pre_unitario) > (select AVG(ar.pre_unitario)
                            from articulos ar)


-- 6. Emita un listado con los montos diarios facturados que sean inferior al
-- importe promedio general.
SELECT f.nro_factura,format(fecha,'dd/MM/yyyy') 'Dia', sum(pre_unitario*cantidad)'Monto facturado'
from facturas f join detalle_facturas d 
on f.nro_factura = d.nro_factura
group by f.nro_factura,fecha
having sum(cantidad*pre_unitario) <(select sum(cantidad*d1.pre_unitario)/count(distinct d.nro_factura)
                                    from detalle_facturas d1)

-- 7. Se quiere saber la fecha de la primera y última venta, el importe total
-- facturado por cliente para los años que oscilen entre el 2007 y 2010 y que
-- el importe promedio facturado sea menor que el importe promedio total
-- para ese cliente. 
SELECT distinct c.cod_cliente'Codigo',ape_cliente 'Cliente'
,min(fecha)'Primera Compra',
max(fecha)'Ultima Compra',
sum(cantidad*pre_unitario)'Importe Total'
from facturas f join clientes c
on f.cod_cliente = c.cod_cliente
join detalle_facturas de on de.nro_factura = f.nro_factura
where year(fecha) between 2007 and 2010
group by c.cod_cliente, ape_cliente
having avg(cantidad*pre_unitario)<(select avg(cantidad*pre_unitario)
from facturas f1 join detalle_facturas d1
on f1.nro_factura = d1.nro_factura)

-- 8. Realice un informe que muestre cuánto fue el total anual facturado por
-- cada vendedor, para los casos en que el nombre de vendedor no
-- comience con „B‟ ni con „M‟, que los nros. de facturas oscilen entre 5 y
-- 25 y que el promedio del monto facturado sea inferior al promedio de ese
-- año. 

SELECT year(fecha)'Año',sum(cantidad*pre_unitario)'Total Facturado',
v.cod_vendedor, nom_vendedor 'Vendedor'
from facturas f join detalle_facturas D
on f.nro_factura = d.nro_factura
join vendedores v on f.cod_vendedor = v.cod_vendedor
where nom_vendedor not like '[B,M]%'
and f.nro_factura between 5 and 25
group by year(fecha),v.cod_vendedor,nom_vendedor
having avg(cantidad*pre_unitario) < (select avg(cantidad*pre_unitario)
                                    from facturas f1 join detalle_facturas d1
                                    on f1.nro_factura = d1.nro_factura
                                    where year(fecha) = year(f.fecha)
                                    )
select * from clientes
where calle not like '%[San,Luis]%'
