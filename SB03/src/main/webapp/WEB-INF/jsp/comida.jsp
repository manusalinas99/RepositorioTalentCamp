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


<form action="generarArchivo" method="get">
        Ingrediente: <input type="text" name="ingrediente"></br>
        <input type="submit" value="Generar Archivo">
 </form>
    
<p><a href="index">Página de Inicio</a></p> 
</body>
</html>