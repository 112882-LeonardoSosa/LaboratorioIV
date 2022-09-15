select Concepto, Denominacion, Importe 
from Servicios s join Habitaciones h 
on s.IdHabitacion = h.IdHabitacion

--Total Servicios contratados
select count(IdServicio) 'Total Servicios Contratados'
from Servicios

--Reporte 2
select h.IdHabitacion, sum(Importe) 'sumaServicios' 
from Servicios s join Habitaciones h 
on s.IdHabitacion = h.IdHabitacion
group by  h.IdHabitacion

select * from Servicios