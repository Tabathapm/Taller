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

<%--                        <div id = "grafico" style="width: 700px; height: 500px;"></div>--%>


                        <c:forEach items="${verQueOnda}" var="ver">
<%--                            <p>${verQueOnda.chars()}</p>--%>
                            <p>${ver}</p>
<%--                            <p>${verQueOnda}</p>--%>
<%--                            <p>${verQueOnda}</p>--%>
                        </c:forEach>


























                        <script>
                            <%--google.charts.load('current', {'packages':['corechart']});--%>
                            <%--google.charts.setOnLoadCallback(drawChart);--%>
                            <%--function drawChart() {--%>
                            <%--    let data = google.visualization.arrayToDataTable([--%>
                            <%--        ['cabina', 'cantidad'],--%>
                            <%--        ['${verQueOnda.ciudad}', parseInt('${verQueOnda.id}')],--%>
                            <%--    ]);--%>
                            <%--        let options = {--%>
                            <%--            title: 'Ver que onda'--%>
                            <%--        };--%>
                            <%--        let chart = new google.visualization.PieChart(document.getElementById('grafico'));--%>
                            <%--        chart.draw(data, options);--%>
                            <%--    }--%>
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
