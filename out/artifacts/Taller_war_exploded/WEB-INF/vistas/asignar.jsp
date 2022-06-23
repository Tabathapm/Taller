<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Asignar Tripulante</title>
</head>
<body>

	 <main>
            
             
                    <h1 class="mt-4">Tripulante - ${tripulante.Id}</h1>
                    

				<table class="table">
					  <thead>
					    <tr>
					        <th scope="col">Vuelo</th>
                            <th scope="col">Origen</th>
                            <th scope="col">Destino</th>
                            <th scope="col">Tipo de Vuelo</th>
                            <th scope="col">Salida</th>
                            <th scope="col">Ver</th>
					    </tr>
					  </thead>
					  
					    <tbody>
					    
                        <c:forEach items="${vuelo}" var="vuelos">
                        <tr>
                            <td><p>${vuelos.nombre}</p></td>
                            <td><p>${vuelos.origen.ciudad}-${vuelos.origen.pais}</p></td>
                            <td><p>${vuelos.destino.ciudad}-${vuelos.destino.pais}</p></td>
                            <td><p>${vuelos.avion.tipoAvion.categoriaAvion}</p></td>
                            <td><p>${vuelos.salida}</p></td>
                            
                            <td><a href="asignarTripulante/exitoso?vueloId=${vuelos.Id}">Asignar</a></td> 
                                        
                        </tr>
                        </c:forEach>
                        
                        </tbody>
                        
					</table>
           
                      
             
              </main>
           
   

 	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/homeDos.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="assets/demo/chart-area-demo.js"></script>
    <script src="assets/demo/chart-bar-demo.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
    <script src="js/datatables-simple-demo.js"></script>      
														
</body>
</html>