<%-- 
    Document   : TeacherList
    Created on : 1/07/2020, 09:11:43 PM
    Author     : 52333
--%>

<%@page import="Models.Teacher"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DataBase.TeacherDB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de estudiantes</title>
    </head>
    <body>
        <% 
            TeacherDB db = new TeacherDB();
            
            ArrayList<Teacher> teachers = new ArrayList<Teacher>();
            teachers = db.ListarMaestros();
            
            if (teachers.isEmpty()) {
        %>
        <div class="alert alert-danger" role="alert">
            No existen estudiantes en la base de datos
        </div>
        <% 
            } else {
        %>
        
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4">Lista de maestros</h1>
            </div>
        </div>
        
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                      <th scope="col">ID</th>
                      <th scope="col">Nombre</th>
                      <th scope="col">Apellido</th>
                      <th scope="col">Opciones</th>
                    </tr>
                </thead>
                <tbody>
                
       <%
            for (Teacher m : teachers) {
                String routeUpdate = "UpdateTeacher.jsp?IDTeacher=" + m.getIDTeacher()+ ""
                        + "&name=" + m.getName() + "&lastName=" + m.getLastName() + ""
                        + "&Academy=" + m.getIDAcademy();
                
                String routeDelete = "DeleteTeacherController?IDTeacher=" + m.getIDTeacher();
        %>
        
                <tr>
                  <td><%= m.getIDTeacher() %></td>
                  <td><%= m.getName() %></td>
                  <td><%= m.getLastName() %></td>
                  <td>
                      <a class="btn btn-warning" href="<%= routeUpdate %>" role="button">Actualizar</a>
                      <a class="btn btn-danger" href="<%= routeDelete %>" role="button">Eliminar</a>
                  </td>
                </tr>
            
        <%      }   
            }
        %>
                
                </tbody>
            </table>
        
            <a class="btn btn-success" href="AddTeacher.html" role="button">Agregar</a>
        
        </div>
        
    </body>
</html>
