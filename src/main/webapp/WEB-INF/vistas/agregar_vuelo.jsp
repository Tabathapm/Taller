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

                <form action="addVuelo" method="POST" modelAttribute="">
                    <div style="margin: 2% 20% 0 0;">
                        <div class="row">
                            <div class="col-sm">
                                <label>Origen</label>
                                <br>
                                <select class="" name="origen" id="selectOrigen">
                                    <option selected disabled>--- SELECCIONE ---</option>
                                    <option value="1">Origen 1</option>
                                    <option value="2">Origen 2</option>
                                    <option value="3">Origen 3</option>
                                </select>
                            </div>
                            <div class="col-sm">
                                <label>Destino</label>
                                <br>
                                <select class="" name="destino" id="selectDestino">
                                    <option selected disabled>--- SELECCIONE ---</option>
                                    <option value="1">Destino 1</option>
                                    <option value="2">Destino 2</option>
                                    <option value="3">Destino 3</option>
                                </select>
                            </div>
                            <div class="col-sm">
                                <label for="fechaVuelo">Fecha</label>
                                <input type="date" id="fechaVuelo" class="form-control">
                            </div>
                            <div class="col-sm">
                                <label for="horaVuelo">Hora</label>
                                <input type="text" id="horaVuelo" class="form-control">
                            </div>
                        </div>
                        <div class="row py-3">
                            <div class="col-sm">
                                <h5>Avi&oacute;n</h5>

                                <div class="form-check">
                                    <input class="form-check-input tipoAvion" type="checkbox"
                                     name="tipoAvionDefault1" value="comercial" id="comercial">
                                    <label class="form-check-label" for="comercial">Comercial</label>
                                </div>

                                <div class="form-check">
                                    <input class="form-check-input tipoAvion" type="checkbox"
                                     name="tipoAvionDefault2" value="carga" id="carga" >
                                    <label class="form-check-label" for="carga">Carga</label>
                                </div>
                            </div>
                        </div>

                        <div class="row py-3">
                            <h5>Tripulaci&oacute;n</h5>

                            <%--    COMERCIAL   --%>
                            <div class="col-sm">
                                <label>Piloto</label>
                                <br>
                                <select class="" name="piloto" id="selectPiloto">
                                    <option selected disabled>--- SELECCIONE ---</option>
                                    <option value="1">Piloto 1</option>
                                    <option value="2">Piloto 2</option>
                                    <option value="3">Piloto 3</option>
                                </select>
                            </div>

                            <div class="col-sm">
                                <label>Copiloto</label>
                                <br>
                                <select class="" name="copiloto" id="selectCopiloto">
                                    <option selected disabled>--- SELECCIONE ---</option>
                                    <option value="1">Copiloto 1</option>
                                    <option value="2">Copiloto 2</option>
                                    <option value="3">Copiloto 3</option>
                                </select>
                            </div>

                            <div class="col-sm">
                                <label>Tripulantes de cabina</label>
                                <br>
                                <%-- selectpicker: devuelve un array con las opciones marcadas   --%>
                                <select class="selectpicker" multiple data-live-search="true">
                                    <option>Opc 1</option>
                                    <option>Opc 2</option>
                                    <option>Opc 3</option>
                                </select>
                            </div>

                            <div class="col-sm">
                                <label>Ing. de vuelo</label>
                                <br>
                                <select class="" name="ingDeVuelo" id="selectIngDeVuelo">
                                    <option selected disabled>--- SELECCIONE ---</option>
                                    <option value="1">IngDeVuelo 1</option>
                                    <option value="2">IngDeVuelo 2</option>
                                    <option value="3">IngDeVuelo 3</option>
                                </select>
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
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>
<script>
    $('select').selectpicker();
</script>
</body>
</html>