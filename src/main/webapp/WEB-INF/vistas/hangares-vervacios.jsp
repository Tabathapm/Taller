<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%--    <link href="css/hangares.css" rel="stylesheet" />--%>
<%--    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />--%>
<%--    <link href="css/homeDos.css" rel="stylesheet" />--%>
<%--    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>--%>
<%--    &lt;%&ndash;	Icono	&ndash;%&gt;--%>
<%--    <link rel="icon" type="image/png" href="<c:url value="/images/viajar.png"/>">--%>

<%--    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">--%>
<%--    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">--%>
<%--    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>--%>
<%--    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>--%>

    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <%--	Icono	--%>
    <link rel="icon" type="image/png" href="<c:url value="/images/viajar.png"/>">


    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/hangares.css" rel="stylesheet" />
    <%--    <link href="css/hangaresOcupados.css" rel="stylesheet" />--%>
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <meta charset="ISO-8859-1">

<title>Hangares Vacios</title>
</head>
<body class="sb-nav-fixed">

<%@include file="partial/navBar.jsp"%>
<%-- ------------------------ --%>
<%-- ------------------------ --%>

<div id="layoutSidenav">
    <%@include file="partial/sidebar.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container">
                <h2>Hangares vacios</h2>

                <form action="homeDos" method="post" modelAttribute="asignarAvionAHangar">
                    <select name="idHangar">
                        <option>Seleccionar hangar vacio</option>
                        <c:forEach items="${hangaresVacios}" var="hangar">
                            <option value="${hangar.id}">${hangar.nombre}</option>
                        </c:forEach>

                    </select>

                    <select name="idAvion">
                        <option>Seleccionar avion vacio</option>
                        <c:forEach items="${avionesVacios}" var="avion">
                            <option value="${avion.id}">${avion.nombre}</option>
                        </c:forEach>

                    </select>

                    <button type="submit">Enviar</button>
                </form>

            </div>
        </main>
    </div>
</div>



<%--<div class="container">--%>
<%--    <h2>Hangares vacios</h2>--%>

<%--    <form action="homeDos" method="post" modelAttribute="asignarAvionAHangar">--%>
<%--        <select name="idHangar">--%>
<%--            <option>Seleccionar hangar vacio</option>--%>
<%--            <c:forEach items="${hangaresVacios}" var="hangar">--%>
<%--                <option value="${hangar.id}">${hangar.nombre}</option>--%>
<%--            </c:forEach>--%>

<%--        </select>--%>

<%--        <select name="idAvion">--%>
<%--            <option>Seleccionar avion vacio</option>--%>
<%--            <c:forEach items="${avionesVacios}" var="avion">--%>
<%--                <option value="${avion.id}">${avion.nombre}</option>--%>
<%--            </c:forEach>--%>

<%--        </select>--%>

<%--        <button type="submit">Enviar</button>--%>
<%--    </form>--%>

<%--</div>--%>




<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>--%>
<%--<script src="js/homeDos.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>--%>
<%--<script src="assets/demo/chart-area-demo.js"></script>--%>
<%--<script src="assets/demo/chart-bar-demo.js"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>--%>
<%--<script src="js/datatables-simple-demo.js"></script>--%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>


</body>
</html>