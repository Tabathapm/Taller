<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
</head>
<div id="layoutSidenav_content">
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Agregar vuelo</h1>
        <form:form action="edit" method="POST" modelAttribute="vuelo1">
            <form:input path="id" value="${unVuelo.id}" type="number" readonly="true"/>
                      <div class="col-sm">
                            <label>Piloto</label>
                            <br>
                            <form:select  path="tripulacionVuelo[0].id" id="tripulacionVuelo" name="tripulacionVuelo">
                                <c:forEach items="${listaPilotos}" var="pilotos" varStatus="loop">
                                    <form:option value="${pilotos.id}">
                                            ${pilotos.id}-${pilotos.nombre},${pilotos.apellido}
                                    </form:option>
                                </c:forEach>
                            </form:select>

                          <form:select  path="tripulacionVuelo[1].id" id="tripulacionVuelo" name="tripulacionVuelo">
                              <c:forEach items="${listaCopilotos}" var="copilotos" varStatus="loop">
                                  <form:option value="${copilotos.id}">
                                      ${copilotos.id}-${copilotos.nombre},${copilotos.apellido}
                                  </form:option>
                              </c:forEach>
                          </form:select>
                        </div>

            <div class="col-sm">
                <label>Piloto</label>
                <br>
                <form:select  path="tripulacionVuelo[2].id" id="tripulacionVuelo" name="tripulacionVuelo">
                    <c:forEach items="${listaIngenieros}" var="ingeniero" varStatus="loop">
                        <form:option value="${ingeniero.id}">
                            ${ingeniero.id}-${ingeniero.nombre},${ingeniero.apellido}
                        </form:option>
                    </c:forEach>
                </form:select>
            </div>
                        <div class="col-sm">
                            <label>Tripulantes de cabina</label>
                            <br>
                            <%-- selectpicker: devuelve un array con las opciones marcadas   --%>
                            <form:select class="selectpicker" multiple-data-live-search="true" path="tripulacionVuelo[3].id">
                                <c:forEach items="${listaTripulantes}" var="tripulantesDeCabina" varStatus="loop">
                                <form:option value="${tripulantesDeCabina.id}">
                                    <option>
                                    ${tripulantesDeCabina.id}-${tripulantesDeCabina.nombre},${tripulantesDeCabina.apellido}
                                    </option>
                                </form:option>
                                </c:forEach>
                            </form:select>
                        </div>

                <button class="btn btn-primary w-50" Type="Submit"/>Asignar Tripulacion</button>
            </form:form>
        </div>
    </main>
</div>
</html>

