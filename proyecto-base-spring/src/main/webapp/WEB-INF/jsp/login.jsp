<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  %>

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
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
	    
	    <link href="../css/estilos.css" rel="stylesheet">
	    
	    <!-- JavaScript -->
	    <script type="text/javascript" src="../js/bootstrap.min.js"></script>
	    <script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 	</head>
 	
	<body>
		<nav class="navbar navbar-fixed-top menu">
  			<div class="container-fluid">
				<ul class="nav nav-pills navbar-right">
				  	<c:choose>
					  	<c:when test="${logueo=='mariano9@hotmail.com'}">
					  		<li><a class="btn btn-menu" href="proyecto-base-spring/0"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesion</a></li>
						  	<li><a class="btn btn-menu" href="./login=0">${logueo}</a></li>
					  	</c:when>
					  	<c:otherwise>
							<li><a class="btn btn-menu" href="/proyecto-base-spring"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>
							<li><a class="btn btn-menu" href="/proyecto-base-spring/proyecto-base-spring/registracion"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>
						  	<li><a class="btn btn-menu" href="./login=0"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:otherwise>
					</c:choose>							  	
				</ul>
			</div>
		</nav>
	    <div class="container">
	        <div class="row">
	            <div class="col-xs-12">
	                <h1 class="page-header text-center titulo">KEEP RUNNING</h1>
	                <h2 class="text-center texto-login">Login</h2>
	           		<div class="col-xs-6 col-xs-offset-3">${error}</div>
					<div class="col-xs-6 col-xs-offset-3 transparencia contenedor-login">
						<form:form method="post" modelAttribute="classLogin" class="form-horizontal" role="form">
							<div class="form-group">
								<label for="email">Email</label>
								<form:input type="text" path="email" class="form-control" id="usuario" required="required"/>
							</div>
							<br>
							<div class="form-group">
								<label for="password">Contraseña</label>
								<form:input type="text" path="password" class="form-control" id="contraseña" required="required"/>
							</div>
							<br>
							<div class="text-center">
								<button type="submit" class="btn btn-success btnIngresar">Ingresar</button>
								<a class="btn btn-danger btnCancelar" href="/proyecto-base-spring">Cancelar</a>
								<a class="btn btn-primary btnRegistrarse" href="/proyecto-base-spring/proyecto-base-spring/registracion">Registrarse</a>
							</div>
						</form:form>
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

