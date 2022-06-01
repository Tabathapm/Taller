<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link href="css/hangares.css" rel="stylesheet" />
    <link href="css/hangaresOcupados.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.1.0/js/all.js" crossorigin="anonymous"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="ISO-8859-1">
<title>Hangares</title>
</head>
<body>

<%--<div class="container">--%>
<%--    <div class="row">--%>
<%--        <div class="col-sm">--%>
<%--            <input type="checkbox" disabled> hangar1--%>
<%--            <input type="checkbox"> hangar2--%>
<%--        </div>--%>


<%--    </div>--%>
<%--</div>--%>


<%--<label class="control-label text-success">Add Applications</label>--%>
<%--<div class="container border">--%>
<%--    <div class="row">--%>
<%--        <div class="col-sm anyClass">--%>
<%--            <div--%>
<%--                    class="form-check form-check-inline text-nowrap col-md-3 pl-2"--%>
<%--                    *ngFor="let name of listaDeHangares; let srno = index"--%>
<%--                    [attr.data-index]="srno"--%>
<%--            >--%>
<%--                <div *ngIf="srno == 1||srno == 4||srno == 7||srno == 10">--%>
<%--                    <span class="ml-4"></span>--%>
<%--                </div>--%>
<%--                <div *ngIf="srno == 2||srno == 5||srno == 8||srno == 11">--%>
<%--                    <span class="ml-5"></span>--%>
<%--                </div>--%>
<%--                <input type="checkbox" name="{{name}}" value="{{name}}" />--%>
<%--                <label class="pt-2 pl-1">{{name}}</label>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>

<div class="form-check">

    <c:forEach items="${listaDeHangares}" var="hangar">
            <input class="form-check-input" type="checkbox" value="" id="${hangar.id}" name="${hangar.nombre}" ${hangar.ocupado ? 'checked' : ''} disabled>
            <label class="form-check-label" for="${hangar.id}"> "${hangar.nombre}" </label>
            <br>
        </c:forEach>

    <%--    <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">--%>
<%--    <label class="form-check-label" for="flexCheckDefault">--%>
    </label>
</div>







<%--<label class="container" id="c1" >Uno--%>
<%--    <input type="checkbox" checked="checked">--%>
<%--    <span class="checkmark" style="background-color: red"></span>--%>



<%--</label>--%>




<%--<label class="container" id="c2">Dos--%>
<%--    <input type="checkbox" checked="checked">--%>
<%--    <span class="checkmark"></span>--%>
<%--</label>--%>
<%--<label class="container" id="c3">Tres--%>
<%--    <input type="checkbox" checked="checked">--%>
<%--    <span class="checkmark"></span>--%>
<%--</label>--%>
<%--<label class="container" id="c4">Cuatro--%>
<%--    <input type="checkbox" checked="checked">--%>
<%--    <span class="checkmark"></span>--%>
<%--</label>--%>
<%--<label class="container" id="c4">Cinco--%>
<%--    <input type="checkbox" checked="checked">--%>
<%--    <span class="checkmark"></span>--%>
<%--</label>--%>



<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
<script src="assets/demo/chart-area-demo.js"></script>
<script src="assets/demo/chart-bar-demo.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
<script src="js/datatables-simple-demo.js"></script>

</body>
</html>