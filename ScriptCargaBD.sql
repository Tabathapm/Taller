use db;

insert into usuario (credencial,password) values('usuario','usuario'),
												('usuario@mail.com','usuario');

insert into tipoavion (carga,capacidad,categoriaAvion) values (5000,250,'Comercial'),
															  (25000,20,'Carga');

insert into avion (nombre,tipoAvion_Id) values ('avionA',1),
											   ('avionB',2);
                                               
insert into locacion (ciudad,coordenadas,pais) values ('Buenos Aires','999','Argentina'),
													  ('Londres','777','Inglaterra');

insert into vuelo (estimado,llegada,salida,nombre,avion_Id,destino_Id,origen_Id) values
				  ('2021-11-26 09:00:00','2021-11-26 09:00:00','2021-11-26 09:00:00','Buenos Aires - Londres', 1 , 2 , 1),
                  ('2021-11-26 09:00:00','2021-11-26 09:00:00','2021-11-26 09:00:00','Londres - Buenos Aires', 2 , 1 , 2);
                  
