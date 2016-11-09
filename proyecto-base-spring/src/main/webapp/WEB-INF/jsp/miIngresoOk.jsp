<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"  %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<body>
	<div>LOS DATOS DE USUARIO INGRESADOS FUERON:</div>
	<div>Email : ${classLogin.email}</div>
	<div>Password: ${classLogin.password} </div>
</body>
</html>