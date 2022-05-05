<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<%--	CSS		--%>
		<link href="<c:url value="/css/index.css" />">
		<%--	Bootstrap	--%>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		<%--	Icono	--%>
		<link rel="icon" type="image/png" href="<c:url value="/images/viajar.png"/>">
	</head>
	<body>
		<img src="<c:url value="/images/runway_192834344.jpg" />" style="width: 100%">

		<section class="container-fluid w-100 d-flex justify-content-center align-items-center home" style="margin-top: -39%">
			<div class="d-flex justify-content-center d-flex flex-row mt-4 botones">
				<div class="row justify-content-center align-items-center" style="width: 68%;">
					<div class="col-auto bg-light p-5 rounded-3 shadow-lg">
						<div class="d-flex align-items-center">
							<img src="<c:url value="/images/viajar.png" />" style="width: 8%; margin-right: 4%;">
							<h3 class="form-signin-heading">
								Bienvenido al nuevo sistema de "nombre"
							</h3>
						</div>
						<hr class="colorgraph">

						<form:form action="validar-login" method="POST" modelAttribute="datosLogin">
							<%--Elementos de entrada de datos, el elemento path debe indicar en que atributo del objeto usuario se guardan los datos ingresados--%>
							<div class="input-group p-2 d-flex align-items-center">
								<form:input path="email" id="email" type="email" class="form-control" placeholder="ejemplo@email.com"/>
							</div>
							<div class="input-group p-2 d-flex align-items-center">
								<form:input path="password" type="password" id="password" class="form-control" placeholder="**********"/>
							</div>
							<br>
							<button class="btn btn-primary w-100" Type="Submit"/>Login</button>
						</form:form>
						<br>
<%--						<p>¿No tenes una cuenta? <a href="registrarme"	>Registrarme</a></p>--%>
						<%--Bloque que es visible si el elemento error no esta vacio	--%>
						<c:if test="${not empty error}">
							<h4><span>${error}</span></h4>
							<br>
						</c:if>
						${msg}
					</div>
				</div>
			</div>
		</section>

		<footer class="bg-dark text-center text-white" style="margin-top: 318px;">
			<div class="container p-5 pb-0">
				<section class="mb-4">
					<!-- Facebook -->
					<a class="btn btn-primary btn-floating m-1" style="background-color: #3b5998;" href="#" role="button">
						<i class="fab fa-facebook-f"></i>
					</a>

					<!-- Twitter -->
					<a class="btn btn-primary btn-floating m-1" style="background-color: #55acee;" href="#" role="button">
						<i class="fab fa-twitter"></i>
					</a>

					<!-- Google -->
					<a class="btn btn-primary btn-floating m-1" style="background-color: #dd4b39;" href="#"  role="button">
						<i class="fab fa-google"></i>
					</a>

					<!-- Instagram -->
					<a class="btn btn-primary btn-floating m-1" style="background-color: #ac2bac;" href="#" role="button">
						<i class="fab fa-instagram"></i>
					</a>

					<!-- Linkedin -->
					<a class="btn btn-primary btn-floating m-1" style="background-color: #0082ca;" href="#" role="button">
						<i class="fab fa-linkedin-in"></i>
					</a>
					<!-- Github -->
					<a class="btn btn-primary btn-floating m-1" style="background-color: #333333;" href="#" role="button">
						<i class="fab fa-github"></i>
					</a>
				</section>
			</div>

			<!-- Copyright -->
			<div class="text-center p-3 text-white" >
				© 2022 Copyright:
				<!--        <a class="text-white" href="http://localhost/GauchoRocket/">GauchoRocket.com</a>-->
				<a class="text-white" href="https://www.youtube.com/watch?v=TUVcZfQe-Kw">nombre-a-completar.com</a>
			</div>
		</footer>

		<!--<script type="text/javascript" src="/public/bootstrap/js/bootstrap.min.js"></script>-->
		<script src="https://kit.fontawesome.com/b883f5a3c0.js" crossorigin="anonymous"></script>

		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
	</body>
</html>
