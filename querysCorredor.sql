--Un entrenador de carreras de 100 metros llanos ha solicitado una aplicación web para registrar las velocidades que van marcando los corredores que él entrena y obtener algún tipo de información en base a dichos registros. De cada carrera se registra el nombre del corredor, el nombre del club donde entrenó, el clima del momento (un texto con los valores ‘Normal’, ‘Frio’, ‘Lluvia’ o ‘Viento’) y el tiempo cronometrado.
--El programa debe ofrecer las siguientes funcionalidades:
--• Alta de tiempos: Una pantalla debe permitir el registro de los datos de un registro del tiempo de una carrera.
--• Reportes: deben presentarse en una o más ventanas los siguientes reportes:
--- Cantidad de corredores con algún tiempo menor a 12 segundos.
select COUNT(c.id)'Cantidad Corredores'
from Corredores c join Tiempos t
on c.Id = t.IdCorredor
group by c.Id
having Tiempo < 12

insert into Tiempos (IdCorredor,Tiempo,Club,Clima)
values (234,350,'Frio','PSG')
insert into Tiempos (IdCorredor,Tiempo,Club,Clima)
values (184,220,'Lluvia','Talleres')
insert into Tiempos (IdCorredor,Tiempo,Club,Clima)
values (932,10,'Viento','Man City')
insert into Tiempos (IdCorredor,Tiempo,Club,Clima)
values (231,8,'Lluvia','Juventus')
--234
--- Promedio de tiempos de cada corredor.

--- Nombre del corredor, tiempo insumido y nombre del club de todas aquellas mediciones realizadas en un día con frío o viento y con un tiempo menor a un valor ingresado por el usuario.


create database Carreras
GO

use Carreras
GO

CREATE TABLE [dbo].[Corredores](
    [Id] [int] NOT NULL PRIMARY KEY,
    [Nombre] [varchar](100) NOT NULL
) ON [PRIMARY]

GO
CREATE TABLE [dbo].[Tiempos](
    [Id] [int] PRIMARY KEY IDENTITY(1,1) NOT NULL,
    [IdCorredor] [int] NOT NULL,
    [Tiempo] [float] NOT NULL,
    [Club] [varchar](50) NOT NULL,
    [Clima] [varchar](10) NOT NULL,
    CONSTRAINT [FK_Tiempos_Corredores] FOREIGN KEY([IdCorredor])
REFERENCES [Corredores] ([Id])
) ON [PRIMARY]

GO
INSERT INTO [Corredores] VALUES (234, 'Juan')
INSERT INTO [Corredores] VALUES (184, 'Maria')
INSERT INTO [Corredores] VALUES (932, 'Sergio')
INSERT INTO [Corredores] VALUES (231, 'Ana')
INSERT INTO [Corredores] VALUES (361, 'Mario')
INSERT INTO [Corredores] VALUES (92, 'Daniela')
INSERT INTO [Corredores] VALUES (100, 'Esteban')
GO

select * from Corredores