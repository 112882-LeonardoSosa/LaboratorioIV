--SUB CONSULTAS HAVING
--LISTAR LOS VENDEDORES CUYAS VENTAS TOTALES SEA SUPERIOR AL PROMEDIO
--GENERAL DE VENTAS
SELECT v.cod_vendedor,ape_vendedor+' '+nom_vendedor'Vendedor',
SUM(pre_unitario*cantidad)'Total'
FROM vendedores v join facturas f 
on v.cod_vendedor = f.cod_vendedor
join detalle_facturas de on f.nro_factura = de.nro_factura
group by v.cod_vendedor, ape_vendedor+' '+nom_vendedor
having sum(pre_unitario*cantidad) > (select AVG(pre_unitario*cantidad)
                                    from detalle_facturas d )

--LISTAR LOS VENDEDORES CUYOS PROMEDIO DE VENTAS DEL AÑO
--SEA MENOR AL MISMO DATO DEL AÑO PASADO
SELECT v.cod_vendedor,ape_vendedor+' '+nom_vendedor'Vendedor',
avg(pre_unitario*cantidad)'Promedio de Ventas'
FROM vendedores v join facturas f 
on v.cod_vendedor = f.cod_vendedor
join detalle_facturas de on f.nro_factura = de.nro_factura
where year(fecha)=YEAR(GETDATE())
group by v.cod_vendedor, ape_vendedor+' '+nom_vendedor
HAVING sum(pre_unitario*cantidad)/count(distinct month(fecha))<
        (select sum(pre_unitario*cantidad)/count(distinct month(fecha))
         FROM vendedores ve join facturas fa 
         on ve.cod_vendedor = fa.cod_vendedor
        join detalle_facturas d on fa.nro_factura = d.nro_factura
            where year(fecha)=YEAR(GETDATE())-1
            and v.cod_vendedor=ve.cod_vendedor)
                               
                                   

