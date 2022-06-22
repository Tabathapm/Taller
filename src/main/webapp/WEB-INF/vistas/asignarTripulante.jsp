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
            
             
                    <h1 class="mt-4">Tripulantes</h1>
                    

					<table class="table">
					  <thead>
					    <tr>	
					    	<th scope="col">Nombre</th>
					        <th scope="col">Apellido</th>
                            <th scope="col">Titulo</th>
                            
                            
					    </tr>
					  </thead>
					  
					    <tbody>
					    
                        <c:forEach items="${tripulantes}" var="tripulantes">
                        <tr>
                        	<td><p>${tripulantes.nombre}</p></td>
                            <td><p>${tripulantes.apellido}</p></td>
                            <td><p>${tripulantes.titulo}</p></td>
                            
                            <td><a href="asignarTripulante/asignar?tripulanteId=${tripulantes.id}">asignar</a></td> 
                                        
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

