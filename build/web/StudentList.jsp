<%-- 
    Document   : UserLIst
    Created on : 30/06/2020, 03:46:50 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataBase.DataBaseClass" %>
<%@page import="DataBase.StudentDB" %>
<%@page import="Models.Student" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de estudiantes</title>
    </head>
    <body>
        <% 
            StudentDB db = new StudentDB();
            
            ArrayList<Student> students = new ArrayList<Student>();
            students = db.readAllStudents();
            
            if (students.isEmpty()) {
        %>
        <div class="alert alert-danger" role="alert">
            No existen estudiantes en la base de datos
        </div>
        <% 
            } else {
        %>
        
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4">Lista de estudiantes</h1>
            </div>
        </div>
        
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                      <th scope="col">Registro</th>
                      <th scope="col">Nombre</th>
                      <th scope="col">Apellido</th>
                      <th scope="col">Opciones</th>
                    </tr>
                </thead>
                <tbody>
                
       <%
            for (Student s : students) {
                String routeUpdate = "UpdateStudent.jsp?register=" + s.getRegister() + ""
                        + "&name=" + s.getName() + "&lastName=" + s.getLastName() + ""
                        + "&codeCity=" + s.getIDCity() + "&codeCarer=" + s.getIDCarer();
                
                String routeDelete = "DeleteStudentController?register=" + s.getRegister();
        %>
        
                <tr>
                  <td><%= s.getRegister() %></td>
                  <td><%= s.getName() %></td>
                  <td><%= s.getLastName() %></td>
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
        
            <a class="btn btn-success" href="AddStudent.html" role="button">Agregar</a>
        
        </div>
        
    </body>
</html>
