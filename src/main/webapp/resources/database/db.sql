USE db;

INSERT INTO usuario(activo, email, password, rol)
VALUES
(true, 'tabathapm@gmail.com', '123', 'ADMIN');

INSERT INTO locacion(ciudad, pais)
VALUES
("Mendoza", "Argentina"),
("Cordoba", "Argentina"),
("Chubut", "Argentina"),
("Montevideo", "Uruguay"),
("Buenos Aires", "Argentina");

INSERT INTO tripulante(nombre, apellido, titulo)
VALUES
("Juli", "Barraza", "piloto"),
("Peter", "Parker", "piloto"),
("Jack", "Sparrow", "piloto"),
("Jodie", "Comer", "piloto"),
("Due", "Lipa", "copiloto"),
("Ed", "Sheeran", "copiloto"),
("Harry", "Style", "copiloto"),
("Miley", "Cyrus", "copiloto"),
("Billie", "Eilish", "tripulante de cabina"),
("Elton", "John", "tripulante de cabina"),
("Taylor", "Swift", "tripulante de cabina"),
("Rick", "Astley", "tripulante de cabina"),
("Dove", "Cameron", "tripulante de cabina"),
("Liam", "Hemsworth", "tripulante de cabina"),
("Tony", "Stark", "tripulante de cabina"),
("Charly", "Garcia", "tripulante de cabina"),
("Villanelle", "Astankova", "ing de vuelo"),
("Selena", "Gomez", "ing de vuelo"),
("Charlie", "Puth", "ing de vuelo"),
("John", "Lennon", "ing de vuelo");

INSERT INTO tipoavion(capacidad, tipo)
VALUES
(200, "comercial");

INSERT INTO tipoavion(carga, tipo)
VALUES
(200.0, "carga");