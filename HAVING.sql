-- 3. Se quiere saber la fecha de la primera venta, la cantidad total vendida y
-- el importe total vendido por vendedor para los casos en que el promedio
-- de la cantidad vendida sea inferior o igual a 56.
SELECT v.cod_vendedor,nom_vendedor,min(fecha)'Primera Venta',sum(cantidad*pre_unitario)'Monto Vendido',
sum(cantidad)'Cantidad Vendida'
from facturas f join detalle_facturas de
on f.nro_factura = de.nro_factura
join vendedores v on f.cod_vendedor = v.cod_vendedor
group by v.cod_vendedor,nom_vendedor
having avg(cantidad) < 57
order by 2



-- 4. Se necesita un listado que informe sobre el monto máximo, mínimo y
-- total que gastó en esta librería cada cliente el año pasado, pero solo
-- donde el importe total gastado por esos clientes esté entre 300 y 800.
SELECT cod_cliente,max(cantidad*pre_unitario)'Monto Maximo',
min(cantidad*pre_unitario)'Monto Minimo',
sum(cantidad*pre_unitario)'Importe Total'
from facturas f join detalle_facturas de
on f.nro_factura = de.nro_factura
where year(fecha)=YEAR(GETDATE())-1
group by cod_cliente
having sum(cantidad*pre_unitario) between 3000 and 80000

-- 5. Muestre la cantidad facturas diarias por vendedor; para los casos en que
-- esa cantidad sea 2 o más.
SELECT v.cod_vendedor,nom_vendedor,day(fecha)'dia',month(fecha)'mes',year(fecha)'año'
,count(f.nro_factura)'Cantidad de Facturas Diaras'
from facturas f join detalle_facturas de
on f.nro_factura = de.nro_factura
join vendedores v on v.cod_vendedor=f.cod_vendedor
group by v.cod_vendedor,nom_vendedor, day(fecha),month(fecha),year(fecha)
having count(f.nro_factura) > 1
ORDER by nom_vendedor


-- 6. Desde la administración se solicita un reporte que muestre el precio
-- promedio, el importe total y el promedio del importe vendido por artículo
-- que no comiencen con “c”, que su cantidad total vendida sea 100 o más
-- o que ese importe total vendido sea superior a 700.
SELECT a.descripcion,a.cod_articulo,avg(a.pre_unitario)'Precio Promedio',
AVG(de.pre_unitario)'Promedio del Importe Vendido',
sum(cantidad) 'Cantidad Vendida',
sum(de.pre_unitario*cantidad)'Importe Total Vendido'
from facturas f join detalle_facturas de
on f.nro_factura = de.nro_factura
join articulos a on de.cod_articulo = a.cod_articulo
where descripcion not like 'C%'
group by a.cod_articulo,a.descripcion
having sum(cantidad) > 99 or sum(de.pre_unitario*cantidad) >700

-- 7. Muestre en un listado la cantidad total de artículos vendidos, el importe
-- total y la fecha de la primer y última venta por cada cliente, para lo
-- números de factura que no sean los siguientes: 2, 12, 20, 17, 30 y que el
-- promedio de la cantidad vendida oscile entre 2 y 6. 
SELECT cod_cliente,sum(cantidad)'Cantidad Total Art Vendidos',
AVG(cantidad)'Promedio Cantidad Vendida',
sum(pre_unitario*cantidad)'Importe Total',
min(fecha)'Primera Venta',
MAX(fecha)'Ultima Venta'
FROM facturas f JOIN detalle_facturas DE
ON f.nro_factura = de.nro_factura
where f.nro_factura not in(2, 12, 20, 17, 30)
group by cod_cliente
--having AVG(cantidad) between 2 and 6

--8. Emitir un listado que muestre la cantidad total de artículos vendidos, el
-- importe total vendido y el promedio del importe vendido por vendedor y 
-- por cliente; para los casos en que el importe total vendido esté entre 200
-- y 600 y para códigos de cliente que oscilen entre 1 y 5.
SELECT cod_vendedor,cod_cliente,sum(cantidad)'Cantidad Total Art Vendidos',
sum(pre_unitario*cantidad)'Importe Total Vendido',
avg(pre_unitario*cantidad)'Promedio Importe Vendido'
from facturas f JOIN detalle_facturas de
on f.nro_factura = de.nro_factura
where cod_cliente between 1 and 5
group by cod_vendedor,cod_cliente
HAVING sum(pre_unitario*cantidad) between 2000 and 6000
-- and cod_cliente BETWEEN 1 and 5

-- 9. ¿Cuáles son los vendedores cuyo promedio de facturación el mes
-- pasado supera los $ 800?
SELECT cod_vendedor,sum(pre_unitario*cantidad)/count(f.nro_factura)'Promedio por Factura Mensual',
month(fecha)'Mes'
from facturas f join detalle_facturas de
on f.nro_factura = de.nro_factura
where month(fecha) = MONTH(GETDATE())-5
and year(fecha) = year(GETDATE())
group by cod_vendedor, month(fecha)
having sum(pre_unitario*cantidad)/count(f.nro_factura) > 800

-- 10.¿Cuánto le vendió cada vendedor a cada cliente el año pasado siempre
-- que la cantidad de facturas emitidas (por cada vendedor a cada cliente)
-- sea menor a 5?
SELECT v.cod_vendedor,nom_vendedor 'Vendedor',
c.cod_cliente, nom_cliente 'Cliente',
SUM(cantidad*pre_unitario)'Importe Vendido',
COUNT(distinct f.nro_factura)'Cant Fact Emitidas'
from facturas f join detalle_facturas de
on f.nro_factura = de.nro_factura
join clientes c on c.cod_cliente=f.cod_cliente
join vendedores v on v.cod_vendedor = f.cod_vendedor
where year(fecha)=year(GETDATE())-1
group by v.cod_vendedor,nom_vendedor,
c.cod_cliente, nom_cliente
having COUNT(distinct f.nro_factura) < 5

select nom_vendedor+' '+ape_vendedor as 'Vendedor',
nom_cliente+' '+ape_cliente as 'Cliente',
SUM(pre_unitario*cantidad) as 'Total',
count(distinct f.nro_factura) as 'Facturas emitidas'
from facturas f join vendedores v on v.cod_vendedor=f.cod_vendedor
join clientes c on c.cod_cliente=f.cod_cliente
join detalle_facturas df on df.nro_factura=f.nro_factura
where YEAR(fecha)=YEAR(DATEADD(YEAR, -1, GETDATE()))
group by nom_vendedor+' '+ape_vendedor,nom_cliente+' '+ape_cliente
having count(distinct f.nro_factura)<5
order by 4 desc




