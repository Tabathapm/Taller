<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/homeDos.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
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

                <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Agregar Usuario</h3>
                <form>

                    <div class="row">
                        <div class="col-md-6 mb-4">

                            <div class="form-outline">
                                <input type="text" id="firstName" class="form-control form-control-lg">
                                <label class="form-label" for="firstName">Nombre</label>
                            </div>

                        </div>
                        <div class="col-md-6 mb-4">

                            <div class="form-outline">
                                <input type="text" id="lastName" class="form-control form-control-lg">
                                <label class="form-label" for="lastName">Apellido</label>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-4 d-flex align-items-center">

                            <div class="form-outline datepicker w-100">
                                <input type="text" class="form-control form-control-lg" id="birthdayDate">
                                <label for="birthdayDate" class="form-label">Birthday</label>
                            </div>

                        </div>
                        <div class="col-md-6 mb-4">

                            <h6 class="mb-2 pb-1">Sexo: </h6>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="femaleGender" value="option1" checked="">
                                <label class="form-check-label" for="femaleGender">Femenino</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="maleGender" value="option2">
                                <label class="form-check-label" for="maleGender">Masculino</label>
                            </div>

                            <div class="form-check form-check-inline">
                                <input class="form-check-input" type="radio" name="inlineRadioOptions" id="otherGender" value="option3">
                                <label class="form-check-label" for="otherGender">Other</label>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-6 mb-4 pb-2">

                            <div class="form-outline">
                                <input type="email" id="emailAddress" class="form-control form-control-lg">
                                <label class="form-label" for="emailAddress">Email</label>
                            </div>

                        </div>
                        <div class="col-md-6 mb-4 pb-2">

                            <div class="form-outline">
                                <input type="tel" id="phoneNumber" class="form-control form-control-lg">
                                <label class="form-label" for="phoneNumber">Phone Number</label>
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <div class="col-12">

                            <select class="select form-control-lg">
                                <option value="1" disabled="">Elegir Rol</option>
                                <option value="2">Rol 1</option>
                                <option value="3">Rol 2</option>
                                <option value="4">Rol 3</option>
                            </select>
                            <label class="form-label select-label">Elegir Rol</label>

                        </div>
                    </div>

                    <div class="mt-4 pt-2">
                        <input class="btn btn-primary btn-lg" type="submit" value="Agregar">
                    </div>

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
</body>
</html>