<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

	<head>
	
	    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	    <link href="css/homeDos.css" rel="stylesheet" />
	    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
	    
	  
	    <title>Vuelos</title>
	    
	</head>
	
<body class="sb-nav-fixed">
 

 <main>
            
                    <h1 class="mt-4">Vuelos</h1>
                    

					<div>
					<form:form action="buscarVuelos">
					<input type="text" class="navbar navbar-default input-lg" placeholder="Buscar vuelo" name="busqueda">
					<button type="submit">Buscar</button>
					</form:form>
					</div>
					
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
                            
                            <td><a href="vueloDescripcion?idVuelo=${vuelos.Id}">ver</a></td> 
                                        
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


