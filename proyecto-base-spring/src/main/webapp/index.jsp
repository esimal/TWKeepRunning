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
	    
	    <link href="css/estilos.css" rel="stylesheet">
	</head>

	<body>
		<nav class="navbar navbar-fixed-top menu">
  			<div class="container-fluid">
				<ul class="nav nav-pills navbar-right">
				  	<c:choose>
					  	<c:when test="${email != null}">
					  		<li><a class="btn btn-menu" href="proyecto-base-spring/0"><span class="glyphicon glyphicon-log-in"></span> Cerrar Sesion</a></li>
					  		<li><a class="btn btn-menu" href="proyecto-base-spring/login=0">${email}</a></li>
					  	</c:when>
					  	<c:otherwise>
							<li><a class="btn btn-menu" href="/proyecto-base-spring"><span class="glyphicon glyphicon-home"></span> Inicio</a></li>				
							<li><a class="btn btn-menu" href="proyecto-base-spring/registracion"><span class="glyphicon glyphicon-user"></span> Registrarse</a></li>					  	
					  		<li><a class="btn btn-menu" href="proyecto-base-spring/login=0"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
						</c:otherwise>
					</c:choose>				  	
				</ul>
			</div>
		</nav>
	    <div class="container">
	        <div class="row">
	            <div class="col-xs-12">
	                <h1 class="page-header text-center titulo">KEEP RUNNING</h1>
	            </div>
	            <div class="col-xs-12">
	                <h2 class="carreras-abiertas text-center">Carreras Abiertas</h2>
	            </div>
				<!-- <div class="col-xs-12">
					<h2 class="carreras-abiertas text-center">
						<a href="proyecto-base-spring/todasLasCarreras">Ver todas Las Carreras</a>
					</h2>
				</div> -->
	            <div class="col-lg-3 col-md-4 col-xs-6">
	                <div class="transparencia">
	                	<a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=1">
							<img class="img-rounded" src="/proyecto-base-spring/img/carrera-mujer-2016.jpg"/>
							Carrera 1 <br>
							Detalle
	                	</a>
	                </div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6">
	                <div class="transparencia">
	                	<a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=2">
							<img class="img-rounded" src="/proyecto-base-spring/img/carrera-neon.jpg"/>
							Carrera 2 <br>
							Detalle
	               		</a>
	            	</div>
	            </div>            
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	                <div class="transparencia">
	                	<a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=3">
							<img class="img-rounded" src="/proyecto-base-spring/img/carrera-educacion.jpg"/>
							Carrera 3 <br>
							Detalle
	               		</a>
	               	</div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=4">
							<img class="img-rounded" src="/proyecto-base-spring/img/carrera21.jpg"/>
							Carrera 4 <br>
							Detalle
		                </a>
		            </div>    
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=5">
							<img class="img-rounded" src="/proyecto-base-spring/img/flyer-1.jpg"/>
							Carrera 5 <br>
							Detalle
		                </a>
		        	</div>        
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=6">
							<img class="img-rounded" src="/proyecto-base-spring/img/kitcompetencia.jpg"/>
							Carrera 6 <br>
							Detalle
		                </a>
	            	</div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=7">
							<img class="img-rounded" src="/proyecto-base-spring/img/maraton-lasrozas.jpg"/>
							Carrera 7 <br>
							Detalle
		                </a>
	                </div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=8">
							<img class="img-rounded" src="/proyecto-base-spring/img/carrera22.png"/>
							Carrera 8 <br>
							Detalle
		                </a>
	                </div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=9">
							<img class="img-rounded" src="/proyecto-base-spring/img/rioja-winerun.jpg"/>
							Carrera 9 <br>
							Detalle
		                </a>
	                </div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=10">
							<img class="img-rounded" src="/proyecto-base-spring/img/the-north-face.jpg"/>
							Carrera 10 <br>
							Detalle
		                </a>
	                </div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=11">
							<img class="img-rounded" src="/proyecto-base-spring/img/uch-10k-2016.jpg"/>
							Carrera 11 <br>
							Detalle
		                </a>
	                </div>
	            </div>
	            <div class="col-lg-3 col-md-4 col-xs-6 thumb">
	            	<div class="transparencia">
		                <a class="thumbnail texto-carrera" href="proyecto-base-spring/carrera=12">
							<img class="img-rounded" src="/proyecto-base-spring/img/vitoria.jpg"/>
							Carrera 12 <br>
							Detalle
		                </a>
	                </div>
	            </div>
	        </div>
	
	        <hr>
	
	        <!-- Footer -->
	        <footer>
	            <div class="row">
	                <div class="col-lg-12 footer">
	                    <p>Copyright &copy; Keep Running 2016</p>
	                </div>
	            </div>
	        </footer>
	
	    </div>
	</body>
</html>
