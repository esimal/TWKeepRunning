<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
	    <link href="../css/estilos.css" rel="stylesheet">
	</head>
	
	<body>
		<nav class="navbar navbar-fixed-top menu">
  			<div class="container-fluid">
				<ul class="nav nav-pills navbar-right">
				  	<c:choose>
					  	<c:when test="${logueo=='mariano9@hotmail.com'}">
					  		<li><a class="btn btn-menu" href="proyecto-base-spring/0"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesion</a></li>					  	
					  		<li><a class="btn btn-menu" href="#"><span class="glyphicon glyphicon-log-in"></span> ${logueo}</a></li>
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
	                <h2 class="text-center texto-login">Inscripcion Realizada!</h2>
	           
					<div class="col-xs-6 col-xs-offset-3 transparencia contenedor-inscripcion">
						<div class="texto-inscripcion text-center">
							<p>${logueo}, ya estas inscripto a: ${nombre}</p><br>
							<p>Tu Nro de corredor es: (TRAERLO DE LA DB)${nro_remera}</p>
						</div>
						<div class="text-center">
							<a class="btn btn-primary btnContinuar" href="/proyecto-base-spring">Finalizar</a>
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