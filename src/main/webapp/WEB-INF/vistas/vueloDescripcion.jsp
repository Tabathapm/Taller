<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

<title>${vuelo.nombre}</title>
</head>
<body>
	
	
							<table class="table">
					  <thead>
					    <tr>
					        <th scope="col">Vuelo</th>
                            <th scope="col">Origen</th>
                            <th scope="col">Destino</th>
                            <th scope="col">Tipo de Vuelo</th>
                            <th scope="col">Estimado</th>
                            <th scope="col">LLegada</th>
                            <th scope="col">Salida</th>
                            <th scope="col">Ver</th>
					    </tr>
					  </thead>
					  
					    <tbody>
					    
                       
                        <tr>
                            <td><p>${vuelo.nombre}</p></td>
                            <td><p>${vuelo.origen.ciudad}-${vuelo.origen.pais}</p></td>
                            <td><p>${vuelo.destino.ciudad}-${vuelo.destino.pais}</p></td>
                            <td><p>${vuelo.avion.tipoAvion.categoriaAvion}</p></td>
                            <td><p>${vuelo.estimado}</p></td>
                            <td><p>${vuelo.llegada}</p></td>
                            <td><p>${vuelo.salida}</p></td>
                            
                            <td><a href="buscarVuelos/vueloDescripcion?idVuelo=${vuelo.id}">ver</a></td> 
                                        
                        </tr>
                      
                        
                        </tbody>
                        
					</table>


</body>
</html>