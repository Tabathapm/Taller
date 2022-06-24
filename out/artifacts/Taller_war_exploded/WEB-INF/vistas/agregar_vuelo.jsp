<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
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
        <%-----------------------------------------------%>

    </head>
    <body class="sb-nav-fixed">
        <%@include file="partial/navBar.jsp"%>
        <%-- ------------------------ --%>
        <%-- ------------------------ --%>
        <div id="layoutSidenav">
            <%@include file="partial/sidebar.jsp"%>

            <div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid px-4">
                        <h1 class="mt-4">Agregar vuelo</h1>

                        <form action="addVuelo" method="POST" modelAttribute="datosVuelo">
                            <div style="margin: 2% 20% 0 0;">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <label>Origen</label>
                                        <br>
                                        <select name="origen"  id="selectOrigen">
                                            <option selected disabled>--- SELECCIONE ---</option>
                                            <c:forEach items="${locaciones}" var="locacion">
                                                <option value="${locacion.id}">${locacion.ciudad}, ${locacion.pais}</option>
                                            </c:forEach>
                                        </select>

                                    </div>
                                    <div class="col-sm">
                                        <label>Destino</label>
                                        <br>
                                        <select name="destino"  id="selectDestino">
                                            <option selected disabled>--- SELECCIONE ---</option>
                                            <c:forEach items="${locaciones}" var="locacion">
                                                <option value="${locacion.id}">${locacion.ciudad}, ${locacion.pais}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>

                                <div class="row py-3">
                                    <div class="d-flex">
                                        <div class="w-25">
                                            <fieldset class="border p-2">
                                                <legend class="float-none w-auto p-2">Salida</legend>
                                                <div class="col-sm">
                                                    <label for="fechaVueloSalida">Fecha</label>
                                                    <input name="fechaSalida" type="date" id="fechaVueloSalida" class="form-control">
                                                </div>
                                                <div class="col-sm">
                                                    <label for="horaVueloSalida">Hora</label>
                                                        <%--                                            <input type="text" id="horaVuelo" class="form-control">--%>
                                                    <input name="horaSalida" type="time" id="horaVueloSalida" class="form-control">
                                                </div>
                                            </fieldset>
                                        </div>

                                        <div class="w-25 pl-3">
                                            <fieldset class="border p-2">
                                                <legend class="float-none w-auto p-2">Llegada</legend>
                                                <div class="col-sm">
                                                    <label for="fechaVueloLlegada">Fecha</label>
                                                    <input name="fechaLlegada" type="date" id="fechaVueloLlegada" class="form-control">
                                                </div>
                                                <div class="col-sm">
                                                    <label for="horaVueloLlegada">Hora</label>
                                                        <%--                                            <input type="text" id="horaVuelo" class="form-control">--%>
                                                    <input name="horaLlegada" type="time" id="horaVueloLlegada" class="form-control">
                                                </div>
                                            </fieldset>
                                        </div>
                                    </div>
                                </div>
                                <div class="row py-3">
                                    <div class="col-sm-3">
                                        <h5>Avi&oacute;n</h5>

                                        <div class="form-check">
                                            <input class="form-check-input tipoAvion" type="checkbox" name="tipoDeAvion" value="comercial" id="comercial">
                                            <label class="form-check-label" for="comercial">Comercial</label>
                                        </div>

                                        <div class="form-check">
                                            <input class="form-check-input tipoAvion" type="checkbox" name="tipoDeAvion" value="carga" id="carga" >
                                            <label class="form-check-label" for="carga">Carga</label>
                                        </div>
                                    </div>

                                    <%------- Avion carga -------%>
<%--                                    <div class="col-sm-3" id="campoAvionCarga">--%>
<%--                                        <select name="avion"  id="selectAvionCarga">--%>
<%--                                            <option selected disabled>--- SELECCIONE ---</option>--%>
<%--                                            <c:forEach items="${avionesDeCarga}" var="avionCarga">--%>
<%--                                                <option value="${avionCarga.id}">${avionCarga.nombre}</option>--%>
<%--                                            </c:forEach>--%>
<%--                                        </select>--%>
<%--                                    </div>--%>
                                    <%------- Avion comercial -------%>
<%--                                    <div class="col-sm-3" id="campoAvionComercial">--%>
<%--                                        <select name="avion"  id="selectAvionComercial">--%>
<%--                                            <option selected disabled>--- SELECCIONE ---</option>--%>
<%--                                            <c:forEach items="${avionesComerciales}" var="avionComercial">--%>
<%--                                                <option value="${avionComercial.id}">${avionComercial.nombre}</option>--%>
<%--                                            </c:forEach>--%>
<%--                                        </select>--%>
<%--                                    </div>--%>
<%--                                </div>--%>

                                <div class="row py-3">
                                    <h5>Tripulaci&oacute;n</h5>

                                    <div class="row py-3">
                                        <div class="col-sm-3" id="campoPiloto">
                                            <label>Piloto</label>
                                            <br>
                                            <select name="piloto" class=""  id="selectPiloto">
                                                <option selected disabled>--- SELECCIONE ---</option>
                                                <c:forEach items="${pilotos}" var="piloto">
                                                    <option value="${piloto.id}">${piloto.nombre} ${piloto.apellido}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="col-sm-3" id="campoIngDeVuelo">
                                            <label>Ing. de vuelo</label>
                                            <br>
                                            <select name="ingDeVuelo" class="" id="selectIngDeVuelo">
                                                <option selected disabled>--- SELECCIONE ---</option>
                                                <c:forEach items="${ingsDeVuelo}" var="ingDeVuelo">
                                                    <option value="${ingDeVuelo.id}">${ingDeVuelo.nombre} ${ingDeVuelo.apellido}</option>
                                                </c:forEach>
                                            </select>
                                        </div>
                                    </div>

                                    <div class="row py-3">
                                        <div class="col-sm-3" id="campoCopiloto">
                                            <label>Copiloto</label>
                                            <br>
                                            <select name="copiloto" class=""  id="selectCopiloto">
                                                <option selected disabled>--- SELECCIONE ---</option>
                                                <c:forEach items="${copilotos}" var="copiloto">
                                                    <option value="${copiloto.id}">${copiloto.nombre} ${copiloto.apellido}</option>
                                                </c:forEach>
                                            </select>
                                        </div>

                                        <div class="col-sm-3" id="campoTripulanteDeCabina">
                                            <label>Tripulantes de cabina</label>
                                            <br>
<%--                                            selectpicker: devuelve un array con las opciones marcadas   --%>
                                            <select name="tripulantes" class="selectpicker" multiple data-live-search="true">
                                                <c:forEach items="${tripulantes}" var="tripulante">
                                                    <option value="${tripulante.id}">${tripulante.nombre} ${tripulante.apellido}</option>
                                                </c:forEach>
                                            </select>


                                        </div>
                                    </div>




                                </div>
                            </div>

                            <button class="btn btn-primary w-50" Type="Submit"/>Agregar</button>
                        </form>




                    </div>
                </main>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/homeDos.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="js/agregarViaje.js"></script>
    </body>
</html>
