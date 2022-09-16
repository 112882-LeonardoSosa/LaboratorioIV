CREATE DATABASE Inmobiliaria
GO

USE [Inmobiliaria]
GO
/** Object:  Table [dbo].[Transacciones]    Script Date: 16/9/2022 09:50:50 **/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Transacciones](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Fecha] [nchar](12) NULL,
	[idVendedor] [int] NULL,
	[tipoOperacion] [int] NULL,
	[tipoInmueble] [int] NULL,
 CONSTRAINT [PK_Transacciones] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/** Object:  Table [dbo].[Vendedores]    Script Date: 16/9/2022 09:50:50 **/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Vendedores](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[NombreCompleto] [nchar](100) NULL,
 CONSTRAINT [PK_Vendedores] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Vendedores] ON 

INSERT [dbo].[Vendedores] ([Id], [NombreCompleto]) VALUES (1, N'Valentin Hidalgo                                                                                    ')
INSERT [dbo].[Vendedores] ([Id], [NombreCompleto]) VALUES (2, N'Leo sosa                                                                                            ')
INSERT [dbo].[Vendedores] ([Id], [NombreCompleto]) VALUES (3, N'Reyna Isabel                                                                                        ')
INSERT [dbo].[Vendedores] ([Id], [NombreCompleto]) VALUES (4, N'Gigolo                                                                                              ')
SET IDENTITY_INSERT [dbo].[Vendedores] OFF
GO
ALTER TABLE [dbo].[Transacciones]  WITH CHECK ADD  CONSTRAINT [FK_Transacciones_Vendedores] FOREIGN KEY([idVendedor])
REFERENCES [dbo].[Vendedores] ([Id])
GO
ALTER TABLE [dbo].[Transacciones] CHECK CONSTRAINT [FK_Transacciones_Vendedores]
GO
USE [master]
GO
ALTER DATABASE [Inmobiliaria] SET  READ_WRITE 
GO

select * from Transacciones

--▪ Generar un reporte que informe todas las transacciones registradas. 
select * from Transacciones

--▪ Datos completo de la transacción (que sea Venta) de mayor valor (monto). 
select * 
from Transacciones
where tipoOperacion = 2 and monto = (select max(monto)
				from transacciones)

--▪ Porcentaje de transacciones de tipo Alquiler. 
select (CONVERT(FLOAT,COUNT(id)) / 100) as 'PorcentajeTransacciones'
from Transacciones
where tipoOperacion = 1


--▪ Informar las transacciones (todos sus datos) cuyo tipo de inmueble sea Oficina. 
select *
from transacciones
where tipoInmueble = 1
