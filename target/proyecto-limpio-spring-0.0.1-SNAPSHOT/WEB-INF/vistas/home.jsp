<!DOCTYPE html>
<html>
	<head>
		<!-- Bootstrap core CSS -->
<%--	    <link href="css/bootstrap.min.css" rel="stylesheet" >--%>
<%--	    <!-- Bootstrap theme -->--%>
<%--	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">--%>

		<link href="css/home.css" rel="stylesheet" >
		
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

		<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

<%--		<link href="<c:url value="/css/home.css" />">--%>

<%--		<link rel="stylesheet" type="text/css" href="/resources/css/home.css">--%>
<%--			<link href="home.css">--%>

	</head>
	<body>
		<div class = "container" >
			<h1>Bienvenido al sistema "admin"</h1>
		</div>
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>


<%--		<ul class="nav flex-column">--%>
<%--			<li class="nav-item">--%>
<%--				<a class="nav-link active" aria-current="page" href="#">Active</a>--%>
<%--			</li>--%>
<%--			<li class="nav-item">--%>
<%--				<a class="nav-link" href="#">Link</a>--%>
<%--			</li>--%>
<%--			<li class="nav-item">--%>
<%--				<a class="nav-link" href="#">Link</a>--%>
<%--			</li>--%>
<%--			<li class="nav-item">--%>
<%--				<a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>--%>
<%--			</li>--%>
<%--		</ul>--%>



<%--		<div class="dropdown">--%>
<%--			<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">--%>
<%--				Asignacion--%>
<%--			</button>--%>
<%--			<ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">--%>
<%--				<li><a class="dropdown-item" href="#">Asignar tripulante</a></li>--%>
<%--				<li><a class="dropdown-item" href="#">Asignar hangar</a></li>--%>
<%--				<li><a class="dropdown-item" href="#">Something else here</a></li>--%>
<%--			</ul>--%>
<%--		</div>--%>


		<div class="container-fluid">
			<div class="row flex-nowrap">
				<div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark">
					<div class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
						<a href="/" class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
							<span class="fs-5 d-none d-sm-inline">Menu</span>
						</a>
						<ul class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start" id="menu">
							<li class="nav-item">
								<a href="#" class="nav-link align-middle px-0">
									<i class="fs-4 bi-house"></i> <span class="ms-1 d-none d-sm-inline">Home</span>
								</a>
							</li>
							<li>
								<a href="#submenu1" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
									<i class="fs-4 bi-speedometer2"></i> <span class="ms-1 d-none d-sm-inline">Tripulacion</span> </a>
								<ul class="collapse show nav flex-column ms-1" id="submenu1" data-bs-parent="#menu">
									<li class="w-100">
										<a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Asignar tripulacion de vuelo</span>  </a>
									</li>
									<li>
										<a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Cambiar tripulacion de vuelo</span>  </a>
									</li>
								</ul>
							</li>
<%--							<li>--%>
<%--								<a href="#" class="nav-link px-0 align-middle">--%>
<%--									<i class="fs-4 bi-table"></i> <span class="ms-1 d-none d-sm-inline">Hangar disponible para vuelo saliente</span></a>--%>
<%--							</li>--%>
<%--							<li>--%>
<%--								<a href="#submenu2" data-bs-toggle="collapse" class="nav-link px-0 align-middle ">--%>
<%--									<i class="fs-4 bi-bootstrap"></i> <span class="ms-1 d-none d-sm-inline">Hangar disponible para vuelo entrante</span></a>--%>


								<ul class="collapse nav flex-column ms-1" id="submenu2" data-bs-parent="#menu">
									<li class="w-100">
										<a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Itinerario</span> 1</a>
									</li>
									<li>
										<a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Limpiar destino/tripulacion de vuelos entrantes</span> 2</a>
									</li>
								</ul>
							</li>
							<li>
								<a href="#submenu3" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
									<i class="fs-4 bi-grid"></i> <span class="ms-1 d-none d-sm-inline">Hangar</span> </a>
								<ul class="collapse nav flex-column ms-1" id="submenu3" data-bs-parent="#menu">
									<li class="w-100">
										<a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Hangar disponible para vuelo entrante</span> </a>
									</li>
									<li>
										<a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Hangar disponible para vuelo saliente</span> </a>
									</li>

								</ul>
							</li>
							<li>
								<a href="#" class="nav-link px-0 align-middle">
									<i class="fs-4 bi-people"></i> <span class="ms-1 d-none d-sm-inline">Customers</span> </a>
							</li>
						</ul>
						<hr>
						<div class="dropdown pb-4">
							<a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
								<img src="https://github.com/mdo.png" alt="hugenerd" width="30" height="30" class="rounded-circle">
								<span class="d-none d-sm-inline mx-1">loser</span>
							</a>
							<ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
								<li><a class="dropdown-item" href="#">New project...</a></li>
								<li><a class="dropdown-item" href="#">Settings</a></li>
								<li><a class="dropdown-item" href="#">Profile</a></li>
								<li>
									<hr class="dropdown-divider">
								</li>
								<li><a class="dropdown-item" href="#">Sign out</a></li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col py-3">
					<h3>Left Sidebar with Submenus</h3>
					<p class="lead">
						An example 2-level sidebar with collasible menu items. The menu functions like an "accordion" where only a single
						menu is be open at a time. While the sidebar itself is not toggle-able, it does responsively shrink in width on smaller screens.</p>
					<ul class="list-unstyled">
						<li><h5>Responsive</h5> shrinks in width, hides text labels and collapses to icons only on mobile</li>
					</ul>
				</div>
			</div>
		</div>










	</body>
</html>