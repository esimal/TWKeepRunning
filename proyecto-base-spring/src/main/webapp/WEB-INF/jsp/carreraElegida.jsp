<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="icon" href="../../favicon.ico">
		
		<title>Keep Running</title>
		
		<!-- Bootstrap core CSS -->
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<!-- Bootstrap theme -->
		<link href="css/bootstrap-theme.min.css" rel="stylesheet">
		
		<link href="../css/estilos.css" rel="stylesheet">
		
		<!-- JavaScript -->
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
 		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/carreraElegida.js"></script>
		<script type="text/javascript" src="../js/bootstrap.min.js"></script>
		<script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	</head>

<body>
	<nav class="navbar navbar-fixed-top menu">
		<div class="container-fluid">
			<ul class="nav nav-pills navbar-right">
				<c:choose>
					<c:when test="${email != null}">
						<li><a class="btn btn-menu" href="/proyecto-base-spring"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
				  		<li><a class="btn btn-menu" href="0"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesion</a></li>
						<li><a class="btn btn-menu" href="./login=0">${email}</a></li>
				  	</c:when>
				  	<c:otherwise>
						<li><a class="btn btn-menu" href="/proyecto-base-spring"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
						<li><a class="btn btn-menu" href="/proyecto-base-spring/proyecto-base-spring/registracion"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>				  	
						<li><a class="btn btn-menu" href="./login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>
	</nav>
	<div class="container">
		<div class="row">
			<div class="col-xs-12">
				<h1 class="page-header text-center titulo">KEEP RUNNING</h1>
				<h2 class="nombre-carrera">${nombre}</h2>
			</div>

			<div class="col-xs-12 contenedor-info">
				<div class="transparencia contenedor-carrera-elegida">
					<div class="btn-group btn-group-justified" role="group">
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-default" id="btnDescripcion">Descripci�n</button>
						</div>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-default" id="btnRecorrido">Recorrido</button>
						</div>
						<div class="btn-group" role="group">
							<button type="button" class="btn btn-default" id="btnReglamento">Reglamento</button>
						</div>
					</div>
					<br>
					<div class="texto-carrera-descripcion col-xs-12" id="descripcion">
						<div class="col-xs-7">
							<p class="dato-descripcion">LUGAR DE LARGADA</p>
							<hr class="hr-descripcion">
							${lugar}<br>
							<p class="dato-descripcion">FECHA</p>
							<hr class="hr-descripcion">
							${fecha}<br>
							<p class="dato-descripcion">HORA INICIO</p>
							<hr class="hr-descripcion">
							${hora}<br> 1KM al finalizar los 10 y 3 KM.<br>
							<p class="dato-descripcion">VALOR INSCRIPCI�N</p>
							<hr class="hr-descripcion">
							10KM y 3 KM: $ ${valor} (doscientos setenta pesos) incluye REMERA
							y Kit con productos.<br> 1 KM: $170 (ciento setenta pesos).
							Incluye REMERA y Kit con productos.
						</div>
						<div class="col-xs-5">
							<img class="img-rounded img-responsive" src="${imagenFlyer}" />
						</div>
					</div>
					<div class="text-center col-xs-12" id="recorrido">
						<img class="img-rounded img-responsive" src="${imagenRecorrido}" />
					</div>
					<div class="texto-carrera-reglamento col-xs-12" id="reglamento">
						<h4>INSCRIPCI�N</h4>
						<p>Preinscripci�n: A partir del mi�rcoles 31 de agosto. Todos
							los participantes podr�n preinscribirse en la carrera a trav�s de
							www.clubdecorredores.com. El cupo no tiene validez sino hasta que
							se realice el pago. Al agotarse los cupos no habr� cupos
							reservados para aquellos que no hubieran realizado el pago.</p>
						<br> Pasos de Preinscripci�n:<br>
						<ul>
							<li>Ingresar a www.clubdecorredores.com</li>
							<li>Completar los datos del formulario de preinscripci�n.</li>
							<li>Imprimir el formulario y firmarlo. Puede hacerlo en el
								mismo momento o desde el formulario que recibir� en su correo
								electr�nico. El mismo deber� ser entregado en el momento de
								retiro de Kits y Remeras, seg�n corresponda.</li>
						</ul>
						<hr class="hr-reglamento">
						<h4>RECOMENDACI�N</h4>
						<ul>
							<li>Sugerimos la posibilidad, de presentar el certificado m�dico con el objetivo de que Uds. est�n al tanto de su estado de salud y puedan prevenir 
							cualquier situaci�n adversa para ustedes y la organizaci�n del evento.</li>
							<li>Menores de Edad: los menores de 15 a�os SOLO podr�n participar de los 3KM con autorizaci�n de sus padres. Los mayores de 16 a�os hasta 18 a�os que 
							deseen participar de los 10KM deber�n ser autorizados por ambos padre y madre o tutor. Todos los participantes, al momento del retiro del Kit, deber�n 
							entregar el deslinde de responsabilidad firmado y una fotocopia de su DNI.</li>
							<li>Efectuar una adecuada planificaci�n de entrenamiento.</li>
							<li>Buen descanso el d�a previo a la prueba.</li>
							<li>No participar si se ha padecido una lesi�n o enfermedad recientemente.</li>
							<li>Recordar lo importante del precalentamiento.</li>
							<li>Procurar una adecuada dieta los d�as previos a la carrera (rica en hidratos de carbono y poca grasa).</li>
							<li>Hidrataci�n: antes, durante y despu�s de la carera</li>
						</ul>
						<hr class="hr-reglamento">
						<h4>CATEGOR�AS</h4>
						<ul>
							<li>10k desde 16 a�os (con autorizaci�n de los padres) hasta m�s de 50 a�os</li>
							<li>3k hasta 16 a�os (con autorizaci�n de los padres)</li>
							<li>1k hasta 12 a�os (con autorizaci�n de los padres)</li>
						</ul>
					</div>
					<div class="text-center">
						<c:choose>
							<c:when test="${email == null}">					
								<a href="./login"><button type="button" class="btn btn-success btnLogin" id="btnLogin">Inscripci�n</button></a><br>
							</c:when>
							<c:otherwise>
								<a href="./inscripcion/${carreraId}"><button type="button" class="btn btn-success btnLogin" id="btnLogin">Inscripci�n</button></a><br>					
							</c:otherwise>
						</c:choose>	
					</div>
				</div>
			</div>
		</div>
		<hr>

		<!-- Footer -->
		<footer>
			<div class="row">
				<div class="col-lg-12 footer">
					<p>Copyright &copy; Keep Runnig 2016</p>
				</div>
			</div>
		</footer>

	</div>
</body>
</html>
