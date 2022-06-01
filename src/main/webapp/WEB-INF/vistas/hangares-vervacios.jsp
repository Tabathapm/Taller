<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <meta charset="ISO-8859-1">

<title>Hangares Vacios</title>
</head>
<body>

<%--<table>--%>
<%--<c:forEach items="${hangaresVacios}" var="hangar">--%>
<%--    <tr>--%>
<%--        <td>${hangar.nombre}</td>--%>
<%--        <td>${hangar.ocupado}</td>--%>
<%--    </tr>--%>

<%--</c:forEach>--%>

<%--</table>--%>

<div class="container">
    <h2>Hangares vacios</h2>

    <form action="homeDos" method="post" modelAttribute="asignarAvionAHangar">
        <select name="idHangar">
            <option>Seleccionar hangar vacio</option>
            <c:forEach items="${hangaresVacios}" var="hangar">
                <option value="${hangar.id}">${hangar.nombre}</option>
            </c:forEach>
            <%--        <table>--%>
            <%--            <c:forEach items="${hangaresVacios}" var="hangar">--%>
            <%--                <tr>--%>
            <%--                    <td>${hangar.nombre}</td>--%>
            <%--                    <td>${hangar.ocupado}</td>--%>
            <%--                </tr>--%>

            <%--            </c:forEach>--%>

            <%--        </table>--%>
        </select>


        <select name="idAvion">
            <option>Seleccionar avion vacio</option>
            <c:forEach items="${avionesVacios}" var="avion">
                <option value="${avion.id}">${avion.nombre}</option>
            </c:forEach>
            <%--        <table>--%>
            <%--            <c:forEach items="${hangaresVacios}" var="hangar">--%>
            <%--                <tr>--%>
            <%--                    <td>${hangar.nombre}</td>--%>
            <%--                    <td>${hangar.ocupado}</td>--%>
            <%--                </tr>--%>

            <%--            </c:forEach>--%>

            <%--        </table>--%>
        </select>

        <button type="submit">Enviar</button>
    </form>



<%--    <div class="dropdown">--%>
<%--        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Hangares vacios--%>
<%--            <span class="caret"></span></button>--%>
<%--        <ul class="dropdown-menu">--%>
<%--            <li><a href="#"><c:forEach items="${hangaresVacios}" var="hangar">--%>
<%--                <tr>--%>
<%--            <li><td>${hangar.nombre}</td>--%>

<%--                    &lt;%&ndash;                <li><td>${hangar.ocupado}</td></li>&ndash;%&gt;--%>
<%--                </tr>--%>

<%--                </c:forEach></a></li>--%>
<%--&lt;%&ndash;            <li><a href="#">CSS</a></li>&ndash;%&gt;--%>
<%--&lt;%&ndash;            <li><a href="#">JavaScript</a></li>&ndash;%&gt;--%>


<%--&lt;%&ndash;        <c:forEach items="${hangaresVacios}" var="hangar">&ndash;%&gt;--%>
<%--&lt;%&ndash;            <tr>&ndash;%&gt;--%>
<%--&lt;%&ndash;                <li><td>${hangar.nombre}</td>&ndash;%&gt;--%>

<%--&lt;%&ndash;&lt;%&ndash;                <li><td>${hangar.ocupado}</td></li>&ndash;%&gt;&ndash;%&gt;--%>
<%--&lt;%&ndash;            </tr>&ndash;%&gt;--%>

<%--&lt;%&ndash;        </c:forEach>&ndash;%&gt;--%>




<%--        </ul>--%>
<%--    </div>--%>
</div>

<%--        <table>--%>
<%--            <c:forEach items="${hangaresVacios}" var="hangar">--%>
<%--                <tr>--%>
<%--                    <td>${hangar.nombre}</td>--%>
<%--                    <td>${hangar.ocupado}</td>--%>
<%--                </tr>--%>

<%--            </c:forEach>--%>

<%--        </table>--%>




</body>
</html>