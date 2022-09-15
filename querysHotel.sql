select Concepto, Denominacion, Importe 
from Servicios s join Habitaciones h 
on s.IdHabitacion = h.IdHabitacion

--Total Servicios contratados
select count(IdServicio) 'Total Servicios Contratados'
from Servicios

--Id y denominaci�n de habitaci�n y suma de servicios 
--contratados por todas aquellas habitaciones que registren m�s de 3 servicios.
select h.IdHabitacion, sum(Importe) 'sumaServicios' 
from Servicios s join Habitaciones h 
on s.IdHabitacion = h.IdHabitacion
group by  h.IdHabitacion
having count(IdServicio) > 3

select * from Servicios

--Concepto e importe de todos aquellos servicios contratados 
--por una habitaci�n en particular seleccionada por el usuario
select Concepto, Importe, h.Denominacion
from Servicios s join Habitaciones h 
on s.IdHabitacion = h.IdHabitacion
where h.Denominacion like '%%'

