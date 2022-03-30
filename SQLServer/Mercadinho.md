### mercadinho's data.
### 21-02-2022
##### Drop database.
```
drop database mercadinho
```
##### Creating and setting a database `mercadinho`.
```
create database mercadinho
```
```
use mercadinho
```
##### Creating a table `mer_cliente` in `mercadinho` database.
```
create table mer_cliente(
	cli_ch_cpf char(14) not null
    	constraint mer_pk_cliente primary key
    	constraint mer_ck_cli_cpf check (cli_ch_cpf like '[0-9][0-9][0-9][.][0-9][0-9][0-9][.][0-9][0-9][0-9][-][0-9][0-9]'),

	cli_st_nome varchar(100) not null,

	cli_st_email varchar(100) null
		constraint mer_uk_cli_email unique
);
```
##### Inserting data in `mercadinho` database.
```
insert into mer_cliente
values ('123.456.789-01','maria alves','maria.alves@uol.com.br');

insert into mer_cliente
values ('123.456.789-02','sim','porque.sim@uol.com.br');

insert into mer_cliente
values ('123.456.789-03','sim','porque.sim@uol.com.br');
```
##### Creating a table `mer_pedido` in `mercadinho` database.
```
create table mer_pedido(
	ped_in_numero int not null identity(1,1)
		constraint mer_pk_pedido primary key,

	ped_dt_emissao smalldatetime not null
		constraint mer_df_ped_emissao default getdate(),

	ped_re_valor numeric(10,2) not null
		constraint mer_df_ped_valor default 0
		constraint mer_ck_ped_valor check (ped_re_valor >= 0),

	cli_ch_cpf char(14) null
		constraint mer_fk_ped_cli
		foreign key references mer_cliente(cli_ch_cpf)
);
```
##### Inserting data in the `mer_pedido` database.
```
insert into mer_pedido (ped_re_valor, cli_ch_cpf) 
values (200.35,'123.456.789-01');

insert into mer_cliente
values ('987.654.321-09','MaRiA LiMa lopES   ','MARIA@uol.com.br');

insert into mer_pedido (ped_re_valor, cli_ch_cpf)
values (120.52,'987.654.321-09');

insert into mer_pedido (ped_re_valor, cli_ch_cpf)
values (930.52,'987.654.321-09');
```
```
select * from mer_pedido;
```
##### Creating a view `mer_vw_vendas` for `mercadinho`.
```
create view mer_vw_vendas

as

select
	cli.cli_ch_cpf as 'cpf',
	upper(cli.cli_st_nome as 'nome',
	lower(cli.cli_st_email) as 'email',
	ped.ped_in_numero as 'pedido',

	replace(str(datepart(dd,ped.ped_dt_emissao),2,0),' ','0')+'/'+
	replace(str(datepart(mm,ped.ped_dt_emissao),2,0),' ','0')+'/'+
	str(datepart(yyyy,ped.ped_dt_emissao),4,0)
	as 'data emissão',
	
	ped.ped_re_valor as 'valor'
from
	mer_cliente as cli,
	mer_pedido as ped
where
	cli.cli_ch_cpf = ped.cli_ch_cpf;
```
##### Asking for `mer_vw_vendas`.
```
select * from mer_vw_vendas;
```
##### Creating a view `cli_vw_resumovendas` for `mercadinho`.
```
create view cli_vw_resumovendas

as

select 
	trim(upper(cli.cli_st_nome)) as cliente,
	sum(ped.ped_re_valor) as vendas
from
	mer_cliente as cli,
	mer_pedido as ped
where
	cli.cli_ch_cpf = ped.cli_ch_cpf
group by
	cli.cli_st_nome;
```
##### Asking for `cli_vw_resumovendas`.
```
select * from cli_vw_resumovendas;
```
### 07-03-2022
##### Creating `MERCADINHO` database with `if`.
```
IF NOT EXISTS (
	SELECT * FROM SYS.databases WHERE NAME='MERCADINHO'
)
BEGIN
	CREATE DATABASE MERCADINHO;
END
```
##### Going to `MERCADINHO`
```
USE MERCADINHO;
```
##### Creating table `MER_PRODUTO`
```
CREATE TABLE MER_PRODUTO(
	PRO_IN_CODIGO INT NOT NULL IDENTITY
		CONSTRAINT MER_PK_PRODUTO PRIMARY KEY,
	
	PRO_CH_BARRAS CHAR(13) NOT NULL
		CONSTRAINT MER_CK_BARRAS CHECK(PRO_CH_BARRAS LIKE '[0-9][0-9][0-9][0-9][0-9][.][0-9][0-9][0-9][0-9][0-9][-][0-9]')
		CONSTRAINT MER_UK_BARRAS UNIQUE,
	
	PRO_ST_NOME VARCHAR(100) NOT NULL,
	
	PRO_RE_PRECO NUMERIC(10,2) NOT NULL
		CONSTRAINT MER_DF_PRECO DEFAULT 0
		CONSTRAINT MER_CK_PRECO CHECK(PRO_RE_PRECO >= 0),
	
	PRO_DT_INCLUSAO SMALLDATETIME NOT NULL
		CONSTRAINT MER_DF_INCLUSAO DEFAULT GETDATE(),
	
	PRO_CH_ATIVO CHAR(3) NOT NULL
		CONSTRAINT MER_DF_ATIVO DEFAULT 'SIM'
		CONSTRAINT MER_CH_ATIVO CHECK(PRO_CH_ATIVO IN ('SIM','NÃO'))
);
```
##### Inserting data in `MER_PRODUTO` database.
```
INSERT INTO MER_PRODUTO (
	PRO_CH_BARRAS, PRO_ST_NOME
) VALUES (
	'12345.67890-1','P O AMANHECIDO'
);

INSERT INTO MER_PRODUTO (
	PRO_CH_BARRAS, PRO_ST_NOME, PRO_RE_PRECO
) VALUES (
	'98765.43210-9','ALVEJANTE LíQUIDO',10
);

INSERT INTO MER_PRODUTO (
	PRO_CH_BARRAS, PRO_ST_NOME, PRO_RE_PRECO, PRO_CH_ATIVO
) VALUES (
	'98765.43210-8','PRESUNTO PARMA',100,'NÃO'
);
```
##### Select `MER_PRODUTO` data.
```
SELECT * FROM MER_PRODUTO;
```
##### Creating or changing the `procedure` `SP_S_MER_PRODUTO`.
```
-- CRIA A STORED PROCEDURE DE CONSULTA
CREATE OR ALTER PROCEDURE dbo.SP_S_MER_PRODUTO

-- PARAMETRO DE ENTRADA
@PRODUTO VARCHAR(100)

AS

-- COMANDO(S) T-SQL
SELECT
	LEFT(PRO.PRO_CH_BARRAS,5)+SUBSTRING(PRO.PRO_CH_BARRAS,7,5)+RIGHT(PRO.PRO_CH_BARRAS,1) AS 'CODBARRAS',
	PRO.PRO_ST_NOME AS 'NOME',
	PRO.PRO_RE_PRECO AS 'PREÇO',
	PRO.PRO_DT_INCLUSAO AS 'INCLUSÃO',
	PRO.PRO_CH_ATIVO AS 'ATIVO'
FROM
	MER_PRODUTO AS PRO
WHERE
	PRO.PRO_ST_NOME LIKE '%' + @PRODUTO + '%'
ORDER BY
	PRO.PRO_ST_NOME ASC
```
##### Asking for the `procedure` `SP_S_MER_PRODUTO` data.
```
EXEC SP_S_MER_PRODUTO 'PRESUNTO PARMA' -- EXEC É OPCIONAL
```
##### Creating or changing the `procedure` `SP_I_MER_PRODUTO`.
```
CREATE OR ALTER PROCEDURE DBO.SP_I_MER_PRODUTO

@BARRAS CHAR(13),
@NOME VARCHAR(100),
@PRECO NUMERIC(10,2),
@ATIVO CHAR(3)

AS

-- CRIAMDO AS VARIÁVEIS
DECLARE @QTDEBARRAS INT

SELECT @QTDEBARRAS = COUNT(*)
FROM MER_PRODUTO
WHERE PRO_CH_BARRAS = @BARRAS;

IF @QTDEBARRAS > 0
	BEGIN
		RAISERROR('O CÓDIGO DE BARRAS INFORMADO JÁ EXISTE',15,1)
		RETURN
	END

SET NOCOUNT ON -- DESLIGA A MSG DE LINHAS AFETEDAS

--VERIFICANDO SE O NOME FOI PASSADO
IF LEN(@NOME) = 0
	BEGIN
		RAISERROR('O NOME É OBRIGATÓRIO!',15,1);
	END
IF @PRECO < 0 -- VERIFICANDO SE O PREÇO É NEGATIVO
	BEGIN
		RAISERROR('O PREÇO NÃO PODE SER NEGATIVO',15,1);
	END
IF @ATIVO NOT IN ('SIM','NÃO') -- VERIFICANDO SE O ATIVO É VÁLIDO
	BEGIN
		RAISERROR('O CAMPO ATIVO DEVE SER "SIM" OU "NÃO"',15,1);
	END

-- IREMOS INSERIR OS DADOS
INSERT INTO MER_PRODUTO(PRO_CH_BARRAS, PRO_ST_NOME, PRO_RE_PRECO, PRO_CH_ATIVO)
VALUES (@BARRAS, @NOME, @PRECO, @ATIVO);

RETURN
```
##### Inserting data in the `SP_I_MER_PRODUTO`.
```
SP_I_MER_PRODUTO '12345.67890-4','SIM',1.00,'NÃO'
```
##### How to get a table data in the SQLServer.
```
SP_HELP 'MER_PRODUTO'
```
##### Creating or changing the `procedure` `SP_U_MER_PRODUTO`.
```
CREATE OR ALTER PROCEDURE DBO.SP_U_MER_PRODUTO
@CODIGO INT,
@BARRAS CHAR(13),
@NOME VARCHAR(100),
@PRECO NUMERIC(10,2),
@ATIVO CHAR(3)

AS

SET NOCOUNT ON -- DESLIGA A MSG DE LINHAS AFETEDAS

--VERIFICANDO SE O NOME FOI PASSADO
IF LEN(@NOME) = 0
	BEGIN
		RAISERROR('O NOME É OBRIGATÓRIO!',15,1);
	END
IF @PRECO < 0 -- VERIFICANDO SE O PREÇO É NEGATIVO
	BEGIN
		RAISERROR('O PREÇO NÃO PODE SER NEGATIVO',15,1);
	END
IF @ATIVO NOT IN ('SIM','NÃO') -- VERIFICANDO SE O ATIVO É VÁLIDO
	BEGIN
		RAISERROR('O CAMPO ATIVO DEVE SER "SIM" OU "NÃO"',15,1);
	END

-- IREMOS ALTERAR OS DADOS
UPDATE
	MER_PRODUTO
SET
	PRO_CH_BARRAS = @BARRAS,
	PRO_ST_NOME = @NOME,
	PRO_RE_PRECO = @PRECO,
	PRO_CH_ATIVO = @ATIVO
WHERE
	PRO_IN_CODIGO = @CODIGO;

RETURN
```
##### Using the `SP_U_MER_PRODUTO` to update an data.
```
SP_U_MER_PRODUTO 7,'12345.67890-4','sim',1,'NÃO'
```
### 14-03-2022
```
CREATE TABLE MER_USUARIO(
	USU_IN_CODIGO INT NOT NULL IDENTITY
		CONSTRAINT MER_PK_USUARIO PRIMARY KEY,
	USU_ST_NOME VARCHAR(100) NOT NULL,
	USU_ST_LOGIN VARCHAR(50) NOT NULL
		CONSTRAINT MER_UK_USU_LOGIN UNIQUE,
	USU_BI_SENHA VARBINARY(512) NOT NULL,
	USU_DT_CRIACAO SMALLDATETIME NOT NULL
		CONSTRAINT MER_DF_USU_CRIACAO DEFAULT GETDATE(),
	USU_DT_ULTIMAALTERACAO SMALLDATETIME NULL
)
```
##### About `cryptography`
```
-- SHA1, MD5, SHA2_512
-- SELECT HASHBYTES('SHA2_512',CONVERT(VARBINARY,'123MUDAR'))
```
##### Creating a `procedure` with a `cryptography` example
```
CREATE OR ALTER PROCEDURE SP_I_MER_USUARIO(
	@NOME VARCHAR(100), @LOGIN VARCHAR(50), @SENHA VARCHAR(100)
)

AS

SET NOCOUNT ON
DECLARE @NR_LOGIN INT

SELECT @NR_LOGIN = COUNT(*)
FROM MER_USUARIO
WHERE USU_ST_LOGIN = @LOGIN

IF @NR_LOGIN > 0
BEGIN
	RAISERROR('O login informado já existe!',15,1)
	RETURN
END

IF LEN(TRIM(@NOME)) = 0 OR LEN(TRIM(@LOGIN)) = 0 OR LEN(TRIM(@SENHA)) = 0
BEGIN
	RAISERROR('É obrigatório informar o nome, login e senha!',15,1)
	RETURN
END

-- Inserindo usando a função de criptografia
INSERT INTO MER_USUARIO (USU_ST_NOME, USU_ST_LOGIN, USU_BI_SENHA)
VALUES (@NOME, @LOGIN, HASHBYTES('SHA2_512', CONVERT(VARBINARY,@SENHA)))
RETURN
```
```
SP_I_MER_USUARIO 'Maria Lima','mlima','secreta123';
SELECT * FROM MER_USUARIO
```
```
CREATE OR ALTER PROCEDURE SP_S_MER_USUARIO_LOGIN
(@LOGIN VARCHAR(50), @SENHA VARCHAR(100))

AS

DECLARE @RETORNO INT

SELECT @RETORNO = COUNT(USU_IN_CODIGO)
FROM MER_USUARIO 
WHERE USU_ST_LOGIN = @LOGIN AND USU_BI_SENHA = HASHBYTES('SHA2_512',CONVERT(VARBINARY,@SENHA))

IF @RETORNO < 1
BEGIN
	RAISERROR('O usuário ou senha informados são inválidos!',15,1)
	RETURN
END

PRINT @RETORNO
RETURN
```
```
SP_S_MER_USUARIO_LOGIN 'mlima','secreta123 OR 1=1';
```
```
CREATE OR ALTER PROCEDURE SP_D_MER_USUARIO
(@CODIGO INT)

AS

SET NOCOUNT ON

IF LEN(@CODIGO) < 1
BEGIN
	RAISERROR('É obrigatório informar o código do usuário!',15,1)
	RETURN
END

DELETE FROM MER_USUARIO WHERE USU_IN_CODIGO = @CODIGO;

IF @@ROWCOUNT = 0 -- retornao nr de linhas 'afetadas'
begin
	RAISERROR('Não havia nenhum usuário para excluir com o código informado',15,1)
END

RETURN
```
```
SP_D_MER_USUARIO 152; -- vai dar erro, não existe o 152
SP_D_MER_USUARIO 1; -- é para excluir com sucesso
```
