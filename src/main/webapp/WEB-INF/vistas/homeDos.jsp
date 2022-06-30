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
    <%--  Grafico  --%>
    <script type="text/javascript" src = "https://www.gstatic.com/charts/loader.js"></script>
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
                    <h1 class="mt-4">Bienvenidos al sistema</h1>

                    <div id = "grafico" style="width: 700px; height: 500px;"></div>

                    ${destinos}

<%--                    <c:forEach items="${destinos}" var="d">--%>
<%--                        <p> ${d}, ${d.id}</p>--%>
<%--                    </c:forEach>--%>

<%--                    <c:forEach items="${destinos}" var="d">--%>
<%--                        <p> ${d.id}, ${d.pais}  </p>--%>
<%--                    </c:forEach>--%>

                    <p> ${destinos} </p>
                    <img src="<c:url value="/images/runway_192834344.jpg" />" style="width: 100%">

                    <script>
                        google.charts.load('current', {'packages':['corechart']});
                        google.charts.setOnLoadCallback(drawChart);
                        function drawChart() {
                            let data = google.visualization.arrayToDataTable([
                                ['pais', 'cantidad'],
                                <c:forEach items="${destinos}" var="d">
                                    ['${d.pais}', parseInt('${d.id}')],
                                </c:forEach>
<%--                                ['${destinos.pais}', parseInt('${destinos.id}')],--%>
                            ]);
                            let options = {
                                title: 'Destinos con mas vuelos'
                            };
                            let chart = new google.visualization.PieChart(document.getElementById('grafico'));
                            chart.draw(data, options);
                        }
                    </script>
                </div>
            </main>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    <script src="js/homeDos.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>

</body>
</html>
