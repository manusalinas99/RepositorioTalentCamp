<%@taglib uri= "http://java.sun.com/jsp/jstl/core" prefix ="c"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>COMIDA</title>
</head>
<body>
       <c:out value="${comida}"/>
  <select name="color" id="color">
  <option value="r">Rojo</option>
  <option value="a">Azul</option>
  <option value="v">Verde</option>
</select>
<p><a href="index">P�gina de Inicio</a></p> 
</body>
</html>