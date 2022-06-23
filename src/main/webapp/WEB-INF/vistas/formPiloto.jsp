<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>


    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <%--    --%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>

    <%--	Icono	--%>
    <link rel="icon" type="image/png" href="<c:url value="/images/viajar.png"/>">
</head>
<body class="sb-nav-fixed">
<%@include file="partial/navBar.jsp"%>
<div id="layoutSidenav">
    <%@include file="partial/sidebar.jsp"%>

    <div id="layoutSidenav_content">
        <main>
            <div class="container-fluid px-4">

                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Agregar Piloto</h3>
                <form action="agregarPiloto" method="post" modelAttribute="piloto">

                    <div class="row">
                        <div class="col-md-6 mb-4">

                            <div class="form-outline">
                                <input name="nombre" type="text" id="firstName" class="form-control form-control-lg">
                                <label class="form-label" for="firstName">Nombre</label>
                            </div>

                        </div>
                        <div class="col-md-6 mb-4">

                            <div class="form-outline">
                                <input name="apellido" type="text" id="lastName" class="form-control form-control-lg">
                                <label class="form-label" for="lastName">Apellido</label>
                            </div>

                        </div>

                          <div class="col-md-6 mb-4">
                              <select name = "titulo" class="form-select" id="title" aria-label="Default select example">
                                  <option value="Piloto">Piloto</option>
                              </select>
                              <label class="form-label" for="title">Titulo</label>
                          </div>


                        <div class="col-md-6 mb-4">
                            <div class="form-outline">
                                <input name="inicioActividad" type="date" id="activityStart" class="form-control form-control-lg">
                                <label class="form-label" for="activityStart">Inicio de actividad</label>
                            </div>
                        </div>


                        <div class="col-md-6 mb-4">
                            <div class="form-outline">
                                <input name="horasActivo" type="number" id="activeHours" class="form-control form-control-lg">
                                <label class="form-label" for="activeHours">Horas activo</label>
                            </div>
                        </div>

                        <div class="col-md-6 mb-4">
                            <div class="form-outline">
                                <input name="horasDescanso" type="number" id="restingHours" class="form-control form-control-lg">
                                <label class="form-label" for="restingHours">Horas descanso</label>
                            </div>
                        </div>


                        <div class="col-md-6 mb-4">
                            <div class="form-check">
                                <input name="estado" class="form-check-input" type="checkbox" value="true" id="flexCheckDefault">
                                <label class="form-check-label" for="flexCheckDefault">Activo</label>
                            </div>
                        </div>

                    </div>

                    <div class="mt-4 pt-2">
                        <input class="btn btn-primary btn-lg" type="submit" value="Agregar">
                    </div>

                </form>
            </div>

            <table class="table">
                <tr>
                    <td><p>Nombre</p></td>
                    <td><p>Apellido</p></td>
                    <td><p>Titulo</p></td>
                    <td><p>Estado</p></td>
                    <td><p>Horas Activo</p></td>
                    <td><p>Horas Descanso</p></td>
                    <td><p>Inicio actividad</p></td>

                    <%--                    <td><a href="asignarTripulante?tripulanteId=${tripulantes.id}">asignar</a></td>--%>

                </tr>
                <c:forEach items="${pilotos}" var="piloto">
                    <tr>
                        <td><p>${piloto.nombre}</p></td>
                        <td><p>${piloto.apellido}</p></td>
                        <td><p>${piloto.titulo}</p></td>
                        <td><p>${piloto.estado}</p></td>
                        <td><p>${piloto.horasActivo}</p></td>
                        <td><p>${piloto.horasDescanso}</p></td>
                        <td><p>${piloto.inicioActividad}</p></td>

                            <%--                    <td><a href="asignarTripulante?tripulanteId=${tripulantes.id}">asignar</a></td>--%>

                    </tr>
                </c:forEach>
            </table>

        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="js/homeDos.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>

</body>
</html>
