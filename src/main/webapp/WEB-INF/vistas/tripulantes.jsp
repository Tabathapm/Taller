<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

	<head>
	
	    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
	    <link href="css/homeDos.css" rel="stylesheet" />
	    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
	    
	  
	    <title>Tripulantes</title>
	    
	</head>
	
<body class="sb-nav-fixed">
 

 <main>
            
                    <h1 class="mt-4">Tripulantes</h1>
                    

					<div>
					<form:form action=" ">
					<input type="text" class="navbar navbar-default input-lg" placeholder=" " name="busqueda">
					<button type="submit">Buscar</button>
					</form:form>
					</div>
					
					<table class="table">
					  <thead>
					    <tr>
					        <th scope="col">Apellido</th>
                            <th scope="col">Titulo</th>
                            <th scope="col">Estado</th>
                            
					    </tr>
					  </thead>
					  
					    <tbody>
					    
                        <c:forEach items="${tripulantes}" var="tripulantes">
                        <tr>
                            <td><p>${tripulantes.apellido}</p></td>
                            <td><p>${tripulantes.titulo}</p></td>
                            <td><p>${tripulantes.estado}</p></td>
                           
                            
                            <td><a href="asignarTripulante?tripulanteId=${tripulantes.id}">asignar</a></td> 
                                        
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


