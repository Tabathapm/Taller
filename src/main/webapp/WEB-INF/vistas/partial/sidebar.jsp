<%--<div class="border-end bg-white" id="sidebar-wrapper">--%>
<%--    <div class="sidebar-heading border-bottom bg-light">Bienvenido admin</div>--%>
<%--    <div class="list-group list-group-flush">--%>
<%--        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="tripulacion">Trupulacion</a>--%>
<%--        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="hangares">Hangares</a>--%>
<%--        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="vuelos">Vuelos</a>--%>
<%--        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="pasajes">Pasajes</a>--%>
<%--        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- - - - </a>--%>
<%--        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#">- - - - </a>--%>


<%--        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseLayouts" aria-expanded="false" aria-controls="collapseLayouts">--%>
<%--            <div class="sb-nav-link-icon"></div>--%>
<%--            Layouts--%>
<%--            <div class="sb-sidenav-collapse-arrow"></div>--%>
<%--        </a>--%>
<%--        <div class="collapse" id="collapseLayouts" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">--%>
<%--            <nav class="sb-sidenav-menu-nested nav">--%>
<%--                <a class="nav-link" href="layout-static.html">Static Navigation</a>--%>
<%--                <a class="nav-link" href="layout-sidenav-light.html">Light Sidenav</a>--%>
<%--            </nav>--%>
<%--        </div>--%>
<%--    </div>--%>
<%--</div>--%>


<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-light" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <%-- ------------------------ --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseVuelos" aria-expanded="false" aria-controls="collapseVuelos">
                    Vuelos
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseVuelos" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="agregar-vuelo">Agregar</a>
                        <a class="nav-link" href="#">Borrar</a>
                        <a class="nav-link" href="vuelos">Ver Vuelos</a>
                    </nav>
                </div>
                <%-- ------------------------ --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseTripulacion" aria-expanded="false" aria-controls="collapseTripulacion">
                    Tripulacion
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseTripulacion" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="pilotos">Pilotos</a>
                        <a class="nav-link" href="#">Copilotos</a>
                        <a class="nav-link" href="#">Ing. de vuelo</a>
                        <a class="nav-link" href="#">Tripulantes de cabina</a>
                        <a class="nav-link" href="asignarTripulante">Asignar Tripulante</a>
                        <a class="nav-link" href="tripulantes">Ver todos</a>
                    </nav>
                </div>
                <%-- ------------------------ --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseHangares" aria-expanded="false" aria-controls="collapseHangares">
                    Hangares
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseHangares" aria-labelledby="headingThree" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                    	<a class="nav-link" href="hangares">Ver Hangares</a>
                        <a class="nav-link" href="hangares-vacios">Vacios</a>
<%--                        <a class="nav-link" href="hangares-asignar">Asignar</a>--%>
                    </nav>
                </div>
                <%-- ------------------------ --%>
                <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapseUsuarios" aria-expanded="false" aria-controls="collapseUsuarios">
                    Usuarios
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapseUsuarios" aria-labelledby="headingFour" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav">
                        <a class="nav-link" href="agregarUsuario">Agregar</a>
                        <a class="nav-link" href="#">Borrar</a>
                        <a class="nav-link" href="#">Ver todo</a>
                    </nav>
                </div>
                <%-- ------------------------ --%>
                    <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#collapsePages" aria-expanded="false" aria-controls="collapsePages">
                    Pages
                    <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                </a>
                <div class="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                    <nav class="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                        <a class="nav-link collapsed" href="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseAuth" aria-expanded="false" aria-controls="pagesCollapseAuth">
                            Authentication
                            <div class="sb-sidenav-collapse-arrow"><i class="fas fa-angle-down"></i></div>
                        </a>
                        <div class="collapse" id="pagesCollapseAuth" aria-labelledby="headingOne" data-bs-parent="#sidenavAccordionPages">
                            <nav class="sb-sidenav-menu-nested nav">
                                <a class="nav-link" href="login.html">Login</a>
                                <a class="nav-link" href="register.html">Register</a>
                                <a class="nav-link" href="password.html">Forgot Password</a>
                            </nav>
                        </div>
                    </nav>
                </div>
            </div>
        </div>
    </nav>
</div>