<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form action="/proyecto-base-spring/persona2" method="POST" modelAttribute="persona">
	<form:label path="nombre">Nombre</form:label>
	<form:input path="nombre" />
	<input type="submit" value="Enviar">
</form:form>
</body>
</html>