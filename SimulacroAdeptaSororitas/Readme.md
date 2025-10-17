## Enunciado
Dispoñemos dun ficheiro de códigos chamado codigosUnidades, os códigos fan referencia á columna cod da táboa adeptaSororitas,
resultado de executar a sentencia almaceada no arquivo adeptaSororitas.sql, nesta táboa almacéanse os nomes e puntos correspondentes
ás unidades do exercito das Adepta Soróritas do xogo de mesa Warhammer 40.000.

Crea e implementa a lóxica precisa para ler o ficheiro de códigos, consultar os nomes e valores de cada unidade, imprimir un listado do nome-valor
de cada unidade do ficheiro en orde descendente segundo os seus valores.

exemplo de saída:

unidade1 - 300
unidade2 - 150
unidade3 - 100
unidade4 - 20


e escribilos nun ficheiro cAdephamado puntosOrdeados.

## codigoUnidades.txt
4
1
3
0
5


### sql:

drop table if exists adeptaSororitas cascade ;


create table adeptaSororitas (cod integer, nome varchar(15), puntos integer);
insert into adeptaSororitas values ('0','squad',105);
insert into adeptaSororitas values ('1','dominion',125);
insert into adeptaSororitas values ('2','seraphim',90);
insert into adeptaSororitas values ('3','zephyrim',85);
insert into adeptaSororitas values ('4','exorcist',190);
insert into adeptaSororitas values ('5','celestine',160);
insert into adeptaSororitas values ('6','imagifier',65);


select * from adeptaSororitas;