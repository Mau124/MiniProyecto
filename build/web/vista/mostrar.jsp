<%-- 
    Document   : mostrar
    Created on : 1/07/2020, 07:09:25 PM
    Author     : Angel Manuel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Administrar Artículos</title>
</head>
<body>
	<h1>Lista  Teacher</h1>
	<table>
		<tr>
			<td><a href="Crear_Actualizar_Eliminar_Teacher?action=index" >Ir al menú</a> </td>
		</tr>
	</table>
	
	<table border="1" width="100%">
		<tr>
		 <td> IDTeacher</td>
		 <td> Name</td>
		 <td> LastName</td>
		 <td> IDAcademy</td>
		 <td colspan=2>ACCIONES</td>
		</tr>
		<c:forEach var="maestro" items="${lista}">
			<tr>
				<td><c:out value="${maestro.IDTeacher}"/></td>
				<td><c:out value="${maestro.Name}"/></td>
				<td><c:out value="${maestro.LastName}"/></td>
				<td><c:out value="${maestro.IDAcademy}}"/></td>
				<td><a href="adminArticulo?action=showedit&id=<c:out value="${Teacher.IDTeacher}" />">Editar</a></td>
				<td><a href="adminArticulo?action=eliminar&id=<c:out value="${maestro.IDTeacher}"/>">Eliminar</a> </td>				
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>
