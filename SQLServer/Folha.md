## Folha's data
### 21-03-2022
```
create database folha;
```
```
use folha
```
```
create table fol_inss(
	ins_in_codigo int not null identity
		constraint fol_pk_inss primary key,
	ins_dt_inicio date not null,
	ins_re_inicial numeric(10,2) not null
		constraint fol_ck_inicial check(ins_re_inicial >= 0),
	ins_re_final numeric(10,2) not null
		constraint fol_ck_final check(ins_re_final >= 0)
		constraint fol_uk_final unique(ins_dt_inicio, ins_re_final),
	ins_re_aliquota numeric(4,2) not null
		constraint fol_ck_aliquota check(ins_re_aliquota >= 0),
	ins_re_teto numeric(10,2) not null
		constraint fol_df_teto default 0
		constraint fol_ck_teto check(ins_re_teto >= 0)
);
```
```
/* DADOS DO INSS 01/2022 */
insert into fol_inss values ('2022-01-01',0,1212,7.5,0);
insert into fol_inss values ('2022-01-01',1212.01,2427.35,9.0,0);
insert into fol_inss values ('2022-01-01',2427.36,3641.03,12.0,0);
insert into fol_inss values ('2022-01-01',3641.04,7087.22,14.0,992.21);

/* DADOS DO INSS 01/2021 */
insert into fol_inss values ('2021-01-01',0,1100,7.5,0);
insert into fol_inss values ('2021-01-01',1100.01,2203.48,9.0,0);
insert into fol_inss values ('2021-01-01',2203.49,3305.22,12.0,0);
insert into fol_inss values ('2021-01-01',3305.23,6433.57,14.0,900.70);
```
#### Creating a function called `valorInss`
```
create function valorInss(@salario numeric(10,2))
returns numeric(10,2)
as
begin
	-- DECLARANDO VARIÁVEIS
	declare @inss numeric(10,2)
	declare @aliquota numeric(4,2)
	declare @tetoimposto numeric(10,2)
	
	-- INICIANDO AS VARIÁVEIS
	set @inss = 0
	set @aliquota = 0
	select @tetoimposto = max(ins_re_teto) 
	from fol_inss
	where ins_dt_inicio <= getdate()

	select @aliquota = ins_re_aliquota
	from fol_inss
	where @salario between ins_re_inicial and ins_re_final and ins_dt_inicio = (
		select max(ins_dt_inicio)
		from fol_inss
		where ins_dt_inicio <= getdate()
	)

	set @inss = (@salario * (@aliquota / 100))
	if(@inss > @tetoimposto)
	begin
		set @inss = @tetoimposto
	end

return @inss
end
```
#### Using the function called `valorInss`
```
select dbo.valorInss(3641.18)
```
