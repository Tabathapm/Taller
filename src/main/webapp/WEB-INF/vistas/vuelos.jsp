<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vuelos</title>
</head>
<body>

        <form:form action="validar-login" method="POST" modelAttribute="datosLogin">
							
			<div class="input-group p-2 d-flex align-items-center">
					<form:input path="busqueda" id="barra-buscar" type="busqueda" class="form-control"/>
			</div>
			<br>
			<button class="btn btn-primary w-100" Type="Submit"/>Buscar</button>
			
		</form:form>
		
		
		
			<div class="row row-cols-1 row-cols-md-5 g-4">
			
			
				 <section class="d-flex contenedor" id="wrapper">
			        <article  class="contenido2" id="page-content-wrapper">
			            <h3>vuelos</h3>
			            <div class="table-responsive">
			                <div class="padding">
			                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            <th scope="col"></th>
                            
                        </tr>
                        </thead>
                           
                           <tbody>
                        <c:forEach items="${vuelo}" var="vuelos">
                        <tr>
                            <td><p>${vuelos.nombre}</p></td>
                            <td><p>${vuelos.destino.ciudad}</p></td>
                            <td><p>${vuelos.avion.tipoAvion.categoriaAvion}</p></td>
                            <td><p>${vuelos.destino.ciudad}</p></td>
                            <td><p>${vuelos.destino.pais}</p></td>
                            <td><p>${vuelos.origen.ciudad}</p></td>
                            <td><p>${vuelos.origen.pais}</p></td>    
                            
                                   
                        </tr>
                        </c:forEach>
                        </tbody>
                        
                 
                    </table>
                </div>

            </div>
            <br>
        </article>
    </section>
				
</body>
</html>