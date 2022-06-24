<%--<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">--%>
<%--    <div class="container-fluid">--%>
<%--        <button class="btn btn-secondary bg-light" id="sidebarToggle">--%>
<%--            <span class="navbar-toggler-icon"></span>--%>
<%--        </button>--%>

<%--        <div class="collapse navbar-collapse" id="navbarSupportedContent">--%>
<%--            <span class="d-flex justify-content-end align-items-center">--%>
<%--                <img src="<c:url value="/images/viajar.png" />" style="width: 5%; margin-right: 4%;">--%>
<%--                    <h4>Bienvenido "nombreADMIN"</h4>--%>
<%--            </span>--%>

<%--            <ul class="navbar-nav ms-auto mt-2 mt-lg-0">--%>
<%--                <li class="nav-item active">--%>
<%--                    <a class="nav-link" href="home">--%>
<%--                        Home--%>
<%--                    </a>--%>
<%--                </li>--%>
<%--            &lt;%&ndash;                &ndash;%&gt;--%>
<%--                <li class="nav-item dropdown">--%>
<%--                    <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Perfil</a>--%>
<%--                    <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">--%>
<%--                        <a class="dropdown-item" href="perfil">Mi perfil</a>--%>
<%--                        <a class="dropdown-item" href="#">Modificar</a>--%>
<%--                        <div class="dropdown-divider"></div>--%>
<%--                        <a class="dropdown-item" href="logout">Cerrar sesion</a>--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--            </ul>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</nav>--%>


<nav class="sb-topnav navbar navbar-expand navbar-light bg-light justify-content-between">
    <!-- Navbar Brand-->
    <div class="d-flex">
        <img src="<c:url value="/images/viajar.png" />" style="width: 6%; margin-left: 1%;">
        <a class="navbar-brand ps-3" href="home" style="width: 25%;">Nombre App</a>
        <button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0" id="sidebarToggle" href="#!">
            <svg class="svg-inline--fa fa-bars" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="bars" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg="">
                <path fill="currentColor" d="M0 96C0 78.33 14.33 64 32 64H416C433.7 64 448 78.33 448 96C448 113.7 433.7 128 416 128H32C14.33 128 0 113.7 0 96zM0 256C0 238.3 14.33 224 32 224H416C433.7 224 448 238.3 448 256C448 273.7 433.7 288 416 288H32C14.33 288 0 273.7 0 256zM416 448H32C14.33 448 0 433.7 0 416C0 398.3 14.33 384 32 384H416C433.7 384 448 398.3 448 416C448 433.7 433.7 448 416 448z"></path>
            </svg>
        </button>
    </div>
    <!-- Sidebar Toggle-->
    <div class="d-flex">
        <!-- Navbar-->
        <ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                    <svg class="svg-inline--fa fa-user fa-fw" aria-hidden="true" focusable="false" data-prefix="fas" data-icon="user" role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512" data-fa-i2svg=""><path fill="currentColor" d="M224 256c70.7 0 128-57.31 128-128s-57.3-128-128-128C153.3 0 96 57.31 96 128S153.3 256 224 256zM274.7 304H173.3C77.61 304 0 381.6 0 477.3c0 19.14 15.52 34.67 34.66 34.67h378.7C432.5 512 448 496.5 448 477.3C448 381.6 370.4 304 274.7 304z"></path></svg><!-- <i class="fas fa-user fa-fw"></i> Font Awesome fontawesome.com -->
                </a>
                <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown">
                    <li><a class="dropdown-item" href="perfil">Mi Perfil</a></li>
                    <li><a class="dropdown-item" href="#">Modificar</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="logout">Cerrar sesion</a></li>
                </ul>
            </li>
        </ul>
    </div>
</nav>