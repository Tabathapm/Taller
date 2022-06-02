<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Id de vuelo : ${vuelo1.id}</h1>
<h2>Cantidad de Tripulantes : ${vuelo1.tripulacionVuelo.size()}</h2>
tripulacion:
    <br><c:forEach items="${tripulacionVuelo}" var="tr" varStatus="loop">
            ${tr.id}
            ${tr.nombre}
            ${tr.titulo}
        <br>
    </c:forEach>

