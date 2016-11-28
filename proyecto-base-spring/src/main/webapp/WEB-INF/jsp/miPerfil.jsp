<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<body>
	<div>LOS DATOS DE USUARIO INGRESADOS FUERON:</div>
	<div>Nombre</div>
	<div> ${nombre} </div>
	<div>Apellido </div>
	<div> ${apellido} </div>
	<div>Dni </div>
	<div> ${dni} </div>
	<div>Email </div>
	<div> ${email} </div>
	<div>FechaNacimiento </div>
	<div> ${fechaNac} </div>
	<div>Contraseña </div>
	<div> ${password} </div>
</body>
</html>