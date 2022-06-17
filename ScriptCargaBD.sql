drop database db;
create schema db;
use db;

insert into usuario (credencial,password) values('usuario','usuario'),
												('usuario@mail.com','usuario');

insert into tipoavion (carga,capacidad,categoriaAvion) values (5000,250,'COMERCIAL'),
															  (25000,20,'CARGA');

insert into avion (nombre,tipoAvion_Id) values ('avionA',1),
											   ('avionB',2);
                                               
insert into locacion (ciudad,coordenadas,pais) values ('Buenos Aires','999','Argentina'),
													  ('Tokio','222','Japon'),
													  ('Londres','777','Inglaterra');
                                                      
												
insert into vuelo (llegada,salida,nombre,avion_Id,destino_Id,origen_Id) values
				  ('2021-11-26 09:05:00','2021-11-26 09:00:00','Buenos Aires - Londres', 1 , 2 , 1),
                   ('2021-11-26 10:09:50','2021-11-26 09:00:00','Tokio - Buenos Aires', 1 , 1 , 3),
                  ('2021-11-26 09:09:00','2021-11-26 09:00:00','Londres - Buenos Aires', 2 , 1 , 2);
                  
insert into Tripulante  (apellido,estado,titulo) values
						("Brando",false,"Copiloto"),
                        ("Joestar",false,"Ingeniero de Vuelo"),
                        ("Kujo",true,"Piloto");
                        
 insert into vuelotripulante (tripulante_Id,vuelo_Id) values
							 (1,1),
                             (2,1);
                             
drop procedure if exists obtenerFechasDeTripulante;
DELIMITER //
create procedure obtenerFechasDeTripulante(in idTripulante long)
begin
    
    select * from vuelo as v
    inner join vuelotripulante as vt on v.Id = vt.vuelo_Id
    inner join tripulante as t on vt.tripulante_Id = t.Id
    where t.Id = idTripulante;
    
end//
DELIMITER ; 

drop procedure if exists obtenerFechasDeTripulanteA;
DELIMITER //
create procedure obtenerFechasDeTripulanteA()
begin
    
    select * from vuelo as v
    inner join vuelotripulante as vt on v.Id = vt.vuelo_Id
    inner join tripulante as t on vt.tripulante_Id = t.Id
    ;
    
end//
DELIMITER ; 
         
   
         
         
select * from vuelo order by llegada;

select * from vuelotripulante;

select * from locacion;


SELECT v1.id,v1.estimado,v1.llegada,v1.nombre,v1.salida,v1.avion_id,v1.destino_Id,v1.origen_Id  from
        (select distinct v.id,v.estimado,v.llegada,v.nombre,v.salida,v.avion_id,v.destino_Id,v.origen_Id
        from vuelo as v
        inner join locacion as l on v.origen_Id=l.id
        where l.ciudad = "Buenos Aires") as v1
        inner join
        (select distinct v.id,v.estimado,v.llegada,v.nombre,v.salida,v.avion_id,v.destino_Id,v.origen_Id
        from vuelo as v
        inner join locacion as l on v.destino_Id=l.id
        where l.ciudad = "Londres") as v2
        on v1.nombre=v2.nombre;
        
 select v.id,estimado,llegada,nombre,salida,avion_Id,destino_Id,origen_Id from vuelo as v 
 inner join locacion as l on v.origen_Id = l.id
 where l.ciudad = "a" or l.pais = "Inglaterra";
 
   select * from vuelo as v
   inner join vuelotripulante as vt on v.id=vt.vuelo_Id
   where vt.vuelo_Id = 1;
 
 /*
 
   
   
   insert into vuelo (llegada,salida,avion_Id,destino_Id,origen_Id) values
				  ('2021-11-26 09:05:00','2021-11-26 09:00:00', 1 , 2 , 1),
                   ('2021-11-26 10:09:50','2021-11-26 09:00:00', 1 , 1 , 3),
                  ('2021-11-26 09:09:00','2021-11-26 09:00:00', 2 , 1 , 2);
                  
                        insert into Tripulante  (apellido,titulo,vuelo_Id) values
						("Brando","Copiloto",1),
                        ("Joestar","Ingeniero de Vuelo",1),
                        ("Kujo","Piloto",2);
*/

-- Script Leandro
/*insert into tipoAvion
values(001,10.000,1000,'Comercial'),
      (002,20.000,2000,'Comercial');*/

/*insert into tipoAvion(Id,Carga,categoriaAvion)
values(003,1.000,'Carga'),
      (004,1.000,'Carga');*/


insert into avion(nombre,tipoAvion_Id)
values
('Avion Olimpia',1),
('Avion Ackerman',2);

insert into avion(nombre,tipoAvion_Id)
values
('Avion Juli',1),
('Avion Rocio',2);

select * from hangar;

insert into hangar
values(0001,'Hangar Olimpia',true,1),
      (0002,'Hangar Manzanares',false,null),
      (0003,'Hangar Alma',false,null),
      (0004,'Hangar Pilar',false,null);

insert into hangar(Id,Nombre,Ocupado)
values(0005,'Hangar Wilson',false);

insert into hangar(Id,Nombre,Ocupado)
values(0006,'Hangar Zoe',false),
      (0007,'Hangar Dua',false),
      (0008,'Hangar Enzo',false),
      (0009,'Hangar Shaila',false),
      (0010,'Hangar Jordan',false);

UPDATE hangar
SET hangar.Ocupado = false
WHERE hangar.Id = 0005;

UPDATE avion
SET hangar_Id = 0001
WHERE avion.Id = 1;

INSERT INTO usuario(activo, credencial, password)
VALUES
(true, 'tabathapm@gmail.com', '123');

INSERT INTO locacion(ciudad, pais)
VALUES
("Mendoza", "Argentina"),
("Cordoba", "Argentina"),
("Chubut", "Argentina"),
("Montevideo", "Uruguay");

INSERT INTO tripulante(nombre, apellido, titulo, estado)
VALUES
("Juli", "Barraza", "Piloto", true),
("Peter", "Parker", "Piloto", true),
("Jack", "Sparrow", "Piloto", true),
("Jodie", "Comer", "Piloto", true),
("Due", "Lipa", "Copiloto", true),
("Ed", "Sheeran", "Copiloto", true),
("Harry", "Style", "Copiloto", true),
("Miley", "Cyrus", "Copiloto", true),
("Billie", "Eilish", "tripulante de cabina", true),
("Elton", "John", "tripulante de cabina", true),
("Taylor", "Swift", "tripulante de cabina", true),
("Rick", "Astley", "tripulante de cabina", true),
("Dove", "Cameron", "tripulante de cabina", true),
("Liam", "Hemsworth", "tripulante de cabina", true),
("Tony", "Stark", "tripulante de cabina", true),
("Charly", "Garcia", "tripulante de cabina", true),
("Villanelle", "Astankova", "Ingeniero de Vuelo", true),
("Selena", "Gomez", "Ingeniero de Vuelo", true),
("Charlie", "Puth", "Ingeniero de Vuelo", true),
("John", "Lennon", "Ingeniero de Vuelo", true);