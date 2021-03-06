USE [master]
GO
/****** Object:  Database [Shop]    Script Date: 27/11/2019 8:41:32 ******/
CREATE DATABASE [Shop]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Shop', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Shop.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Shop_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL13.MSSQLSERVER\MSSQL\DATA\Shop_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [Shop] SET COMPATIBILITY_LEVEL = 130
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Shop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Shop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Shop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Shop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Shop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Shop] SET ARITHABORT OFF 
GO
ALTER DATABASE [Shop] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Shop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Shop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Shop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Shop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Shop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Shop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Shop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Shop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Shop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Shop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Shop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Shop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Shop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Shop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Shop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Shop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Shop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Shop] SET  MULTI_USER 
GO
ALTER DATABASE [Shop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Shop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Shop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Shop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Shop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Shop] SET QUERY_STORE = OFF
GO
USE [Shop]
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [Shop]
GO
/****** Object:  User [UserShop]    Script Date: 27/11/2019 8:41:32 ******/
CREATE USER [UserShop] FOR LOGIN [UserShop] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  User [k]    Script Date: 27/11/2019 8:41:32 ******/
CREATE USER [k] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [UserShop]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 27/11/2019 8:41:32 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Categories] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cities]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cities](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_Cities] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Customer]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[DocumentTypeId] [int] NULL,
	[DocumentNumber] [varchar](50) NULL,
	[FirstName] [varchar](50) NULL,
	[SecondName] [varchar](50) NULL,
	[Surname] [varchar](50) NULL,
	[SecondSurname] [varchar](50) NULL,
	[Telephone] [varchar](50) NULL,
	[Address] [varchar](100) NULL,
	[CityId] [int] NULL,
	[UserId] [int] NOT NULL,
 CONSTRAINT [PK_Customer] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DocumentTypes]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DocumentTypes](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_DocumentTypes] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MethodPayment]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MethodPayment](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_MethodPayment] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ProductPhotos]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductPhotos](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[ProductId] [int] NULL,
	[Guid] [varchar](max) NULL,
	[Ext] [varchar](5) NULL,
 CONSTRAINT [PK_ProductPhotos] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Products]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[CategoryId] [int] NULL,
	[Name] [varchar](50) NULL,
	[Price] [float] NULL,
	[ShippingCost] [float] NULL,
	[Warranty] [varchar](50) NULL,
	[Description] [varchar](max) NULL,
	[Quantity] [int] NULL,
	[StateId] [int] NULL,
	[CustomerId] [int] NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SaleDetails]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SaleDetails](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[SaleId] [int] NULL,
	[ProductId] [int] NULL,
	[Quantity] [int] NULL,
	[SubtotalValue] [float] NULL,
 CONSTRAINT [PK_SaleDetails] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Sales]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Sales](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[MethodPaymentId] [int] NULL,
	[TotalValue] [float] NULL,
	[Date] [datetime] NULL,
	[CustomerId] [int] NULL,
 CONSTRAINT [PK_Sales] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[States]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[States](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [varchar](50) NULL,
	[Active] [bit] NULL,
 CONSTRAINT [PK_States] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Password] [varchar](max) NULL,
	[LockoutEnabled] [bit] NULL,
	[LockoutEndDateUtc] [datetime] NULL,
	[UserName] [varchar](50) NULL,
	[Email] [varchar](100) NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Cities] FOREIGN KEY([CityId])
REFERENCES [dbo].[Cities] ([Id])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Cities]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_DocumentTypes] FOREIGN KEY([DocumentTypeId])
REFERENCES [dbo].[DocumentTypes] ([Id])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_DocumentTypes]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FK_Customer_Users] FOREIGN KEY([UserId])
REFERENCES [dbo].[Users] ([Id])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FK_Customer_Users]
GO
ALTER TABLE [dbo].[ProductPhotos]  WITH CHECK ADD  CONSTRAINT [FK_ProductPhotos_Products] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[ProductPhotos] CHECK CONSTRAINT [FK_ProductPhotos_Products]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Categories] FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Categories]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_Customer] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_Customer]
GO
ALTER TABLE [dbo].[Products]  WITH CHECK ADD  CONSTRAINT [FK_Products_States] FOREIGN KEY([StateId])
REFERENCES [dbo].[States] ([Id])
GO
ALTER TABLE [dbo].[Products] CHECK CONSTRAINT [FK_Products_States]
GO
ALTER TABLE [dbo].[SaleDetails]  WITH CHECK ADD  CONSTRAINT [FK_SaleDetails_Products] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[SaleDetails] CHECK CONSTRAINT [FK_SaleDetails_Products]
GO
ALTER TABLE [dbo].[SaleDetails]  WITH CHECK ADD  CONSTRAINT [FK_SaleDetails_Sales] FOREIGN KEY([SaleId])
REFERENCES [dbo].[Sales] ([Id])
GO
ALTER TABLE [dbo].[SaleDetails] CHECK CONSTRAINT [FK_SaleDetails_Sales]
GO
ALTER TABLE [dbo].[Sales]  WITH CHECK ADD  CONSTRAINT [FK_Sales_Customer] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([Id])
GO
ALTER TABLE [dbo].[Sales] CHECK CONSTRAINT [FK_Sales_Customer]
GO
ALTER TABLE [dbo].[Sales]  WITH CHECK ADD  CONSTRAINT [FK_Sales_MethodPayment] FOREIGN KEY([MethodPaymentId])
REFERENCES [dbo].[MethodPayment] ([Id])
GO
ALTER TABLE [dbo].[Sales] CHECK CONSTRAINT [FK_Sales_MethodPayment]
GO
/****** Object:  StoredProcedure [dbo].[CheckState]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 26/09/2019
-- Description:	CheckState
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[CheckState]
AS
SELECT [Id]
	,[Name]
	,[Active]
FROM [dbo].[States]
WHERE 
[Active] = 1--QUE ESTEN ACTIVAS
GO
/****** Object:  StoredProcedure [dbo].[LoginUser]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 10/09/2019
-- Description:	LoginUser
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[LoginUser]
@Email VARCHAR (50),
@Password VARCHAR (MAX)
AS
--REALIZAR CONSULTA--
SELECT 1
FROM [dbo].[Users]
WHERE [UserName] = @Email AND
[Password] = @Password
GO
/****** Object:  StoredProcedure [dbo].[ProductCreate]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 02/09/2019
-- Description:	ProductCreate
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[ProductCreate]
@Name VARCHAR (50),
@Price FLOAT,
@ShippingCost FLOAT,
@Warranty VARCHAR (50),
@Description VARCHAR(MAX),
@Quantity INT,
@CustomerId INT,
@StateId INT,
@CategoryId INT
AS
--INSERTAR DATOS EN LA TABLA DE USUARIOS--
INSERT INTO [dbo].[Products]([Name],
						[Price],
						[ShippingCost],
						[Warranty],
						[Description],
						[Quantity],
						[CustomerId],
						[StateId],
						[CategoryId]
						)

--ENVIAR VALORES--
VALUES(@Name,
@Price,
@ShippingCost,
@Warranty,
@Description,
@Quantity,
@CustomerId,
@StateId,
@CategoryId);

--SELECCIONAR EL ULTIMO ID DE PRODUCTO CREADO--

(SELECT MAX(Id) productId FROM [dbo].[Products]);


GO
/****** Object:  StoredProcedure [dbo].[ProductCreatePhoto]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 25/11/2019
-- Description:	ProductCreatePhoto
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[ProductCreatePhoto]
@ProductId INT,
@Guid VARCHAR(MAX),
@Ext VARCHAR (5)
AS
--INSERTAR DATOS EN LA TABLA DE [ProductPhotos] --
INSERT INTO [dbo].[ProductPhotos]
						([ProductId],
						[Guid],
						[Ext]
						)

--ENVIAR VALORES--
VALUES(@ProductId,
@Guid,
@Ext);




GO
/****** Object:  StoredProcedure [dbo].[RegisterUser]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 2019-08-31
-- Description:	Register User
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[RegisterUser]
@Email VARCHAR (50),
@Password VARCHAR (MAX)
AS
--INSERTAR DATOS EN LA TABLA DE USUARIOS--
INSERT INTO [dbo].[Users]([Password],
							[LockoutEnabled],
							[UserName],
							[Email])

--ENVIAR VALORES--
VALUES(@Password,
	  1,
	  @Email,
	  @Email);
GO
/****** Object:  StoredProcedure [dbo].[Sale]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 19/11/2019
-- Description:	Sale
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[Sale]
@MethodPaymentId INT,
@TotalValue FLOAT,
@CustomerId INT,
@ProductId INT,
@Quantity INT,
@SubtotalValue FLOAT
AS
INSERT INTO [dbo].[Sales]
([MethodPaymentId],
 [TotalValue],
 [Date],
 [CustomerId])
VALUES
(@MethodPaymentId,
 @TotalValue,
 GETDATE(),
 @CustomerId);

DECLARE @SaleId INT = (SELECT COALESCE (MAX(Id),0)FROM [dbo].[Sales]);

INSERT INTO [dbo].[SaleDetails]
(SaleId,
ProductId,
Quantity,
SubtotalValue
)
VALUES
(@SaleId,
 @ProductId,
 @Quantity,
 @SubtotalValue);

 UPDATE [dbo].[Products]
 SET[Quantity]=[Quantity]-@Quantity
 WHERE [Id] = @ProductId;

 SELECT @SaleId AS SaleId;
GO
/****** Object:  StoredProcedure [dbo].[SearchCategories]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 26/09/2019
-- Description:	LoginUser
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[SearchCategories]
AS
SELECT [Id]
	,[Name]
	,[Active]
FROM [dbo].[Categories]
WHERE 
[Active] = 1--QUE ESTEN ACTIVAS
GO
/****** Object:  StoredProcedure [dbo].[SearchCustomer]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 12/11/2019
-- Description:	SearchCustomer
-- =============================================
CREATE PROC [dbo].[SearchCustomer]
@UserName VARCHAR (50)
AS
SELECT cus.[Id]
      ,[DocumentTypeId]
	  ,doctype.Name DocumentTypeName
      ,[DocumentNumber]
      ,[FirstName]
      ,[SecondName]
      ,[Surname]
      ,[SecondSurname]
      ,[Telephone]
      ,[Address]
      ,[CityId]
	  ,city.Name CityName
      ,[UserId]
  FROM [dbo].[Customer] cus
JOIN [dbo].[Users]  users ON users.Id=cus.UserId

JOIN [dbo].[Cities] city ON city.Id=cus.CityId
JOIN [dbo].[DocumentTypes] docType ON docType.Id=cus.[DocumentTypeId]
WHERE users.UserName=@UserName;
GO
/****** Object:  StoredProcedure [dbo].[SearchMethodsPayment]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 19/11/2019
-- Description:	SEARCH METHODS PAYMENT
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[SearchMethodsPayment]
AS
SELECT [Id]
	,[Name]
	,[Active]
FROM [dbo].[MethodPayment]
WHERE 
[Active] = 1--QUE ESTEN ACTIVAS
GO
/****** Object:  StoredProcedure [dbo].[SearchProducts]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 01/10/2019
-- Description:	Search Products
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
CREATE PROC [dbo].[SearchProducts]
@CategoryId INT,
@ProductName VARCHAR(max)
AS
SELECT prod.[Id]
      ,[CategoryId]
	  ,cate.[Name] AS CategoryName
      ,prod.[Name]
      ,[Price]
      ,[ShippingCost]
      ,[Warranty]
      ,[Description]
      ,[Quantity]
      ,[StateId]
	  ,stat.[Name] AS StateName
      ,[CustomerId]
	  ,ProductPhotos.Guid
  FROM [dbo].[Products] AS prod --Alias prod
  --HACEMOS UN JOIN ENTRE [dbo].[Categories] Y [dbo].[Products] (SIEMPRE DE LA FK A LA PK)
  JOIN [dbo].[Categories] AS cate ON cate.Id = prod.CategoryId
  --HACEMOS UN JOIN ENTRE [dbo].[States] Y [dbo].[Products] (SIEMPRE DE LA FK A LA PK)
  JOIN [dbo].[States] AS stat ON stat.Id = prod.StateId

  CROSS APPLY 
  (SELECT TOP 1 ([Guid] + Ext) AS Guid
  FROM [dbo].[ProductPhotos]
  WHERE [ProductId]=prod.Id) ProductPhotos

  WHERE prod.CategoryId = @CategoryId AND
  --DONDE CONTENGA LO QUE INGRESA EL USUARIO YA SEA EN prod.[Name] O prod.[Description]
  (prod.[Name] like '%' + @ProductName +'%' OR prod.[Description] like '%' + @ProductName +'%') AND
  prod.Quantity>0;
GO
/****** Object:  StoredProcedure [dbo].[SearchProductsById]    Script Date: 27/11/2019 8:41:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

-- =============================================
-- Author:		Ronaldo Jimenez
-- Create date: 12/11/2019
-- Description:	Search Products by Id
-- =============================================
--CREAR PROCEDIMIENTO DE ALMACENADO--
Create PROC [dbo].[SearchProductsById]
@ProductId INT
AS
SELECT prod.[Id]
      ,[CategoryId]
	  ,cate.[Name] AS CategoryName
      ,prod.[Name]
      ,[Price]
      ,[ShippingCost]
      ,[Warranty]
      ,[Description]
      ,[Quantity]
      ,[StateId]
	  ,stat.[Name] AS StateName
      ,[CustomerId]
	  ,ProductPhotos.Guid
  FROM [dbo].[Products] AS prod --Alias prod
  --HACEMOS UN JOIN ENTRE [dbo].[Categories] Y [dbo].[Products] (SIEMPRE DE LA FK A LA PK)
  JOIN [dbo].[Categories] AS cate ON cate.Id = prod.CategoryId
  --HACEMOS UN JOIN ENTRE [dbo].[States] Y [dbo].[Products] (SIEMPRE DE LA FK A LA PK)
  JOIN [dbo].[States] AS stat ON stat.Id = prod.StateId

  CROSS APPLY 
  (SELECT TOP 1 ([Guid] + Ext) AS Guid
  FROM [dbo].[ProductPhotos]
  WHERE [ProductId]=prod.Id) ProductPhotos

  WHERE prod.[Id] = @ProductId;
GO
USE [master]
GO
ALTER DATABASE [Shop] SET  READ_WRITE 
GO
