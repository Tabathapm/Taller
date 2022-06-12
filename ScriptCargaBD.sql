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