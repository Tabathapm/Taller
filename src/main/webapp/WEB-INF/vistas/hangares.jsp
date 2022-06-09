<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

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
<title>Hangares</title>
</head>
<body class="sb-nav-fixed">

<%@include file="partial/navBar.jsp"%>
<%-- ------------------------ --%>
<%-- ------------------------ --%>


<div id="layoutSidenav">
    <%@include file="partial/sidebar.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <div class="form-check">

                <c:forEach items="${listaDeHangares}" var="hangar">
                    <input class="form-check-input" type="checkbox" value="" id="${hangar.id}" name="${hangar.nombre}" ${hangar.ocupado ? 'checked' : ''} disabled>
                    <label class="form-check-label" for="${hangar.id}"> "${hangar.nombre}" </label>
                    <br>
                </c:forEach>


                </label>
            </div>
        </main>
    </div>
</div>

<%--<div class="form-check">--%>

<%--    <c:forEach items="${listaDeHangares}" var="hangar">--%>
<%--            <input class="form-check-input" type="checkbox" value="" id="${hangar.id}" name="${hangar.nombre}" ${hangar.ocupado ? 'checked' : ''} disabled>--%>
<%--            <label class="form-check-label" for="${hangar.id}"> "${hangar.nombre}" </label>--%>
<%--            <br>--%>
<%--        </c:forEach>--%>


<%--    </label>--%>
<%--</div>--%>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>

</body>
</html>