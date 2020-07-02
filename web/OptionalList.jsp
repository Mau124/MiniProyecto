<%-- 
    Document   : UserLIst
    Created on : 30/06/2020, 03:46:50 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DataBase.DataBaseClass" %>
<%@page import="DataBase.OptionalDB" %>
<%@page import="Models.Optional" %>
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
            OptionalDB db = new OptionalDB();
            
            ArrayList<Optional> optionals = new ArrayList<Optional>();
            optionals = db.readAllOptional();
            
            if (optionals.isEmpty()) {
        %>
        <div class="alert alert-danger" role="alert">
            No existen estudiantes en la base de datos
        </div>
        <% 
            } else {
        %>
        
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4">Lista de materias opcionales</h1>
            </div>
        </div>
        
        <div class="container">
            <table class="table">
                <thead class="thead-dark">
                    <tr>
                      <th scope="col">Id</th>
                      <th scope="col">Nombre</th>
                      <th scope="col">Creditos</th>
                      <th scope="col">Clave de carrera</th>
                      <th scope="col">Opciones</th>
                    </tr>
                </thead>
                <tbody>
                
       <%
            for (Optional o : optionals) {
                String routeUpdate = "UpdateOptional.jsp?codeOptional=" + o.getIDOptional() + ""
                        + "&name=" + o.getName() + "&credits=" + o.getCredits() + ""
                        + "&codeCarer=" + o.getIDCarer();
                
                String routeDelete = "DeleteOptionalController?codeOptional=" + o.getIDOptional();
        %>
        
                <tr>
                  <td><%= o.getIDOptional() %></td>
                  <td><%= o.getName() %></td>
                  <td><%= o.getCredits() %></td>
                  <td><%= o.getIDCarer()%></td>
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
        
            <a class="btn btn-success" href="AddOptional.html" role="button">Agregar</a>
        
        </div>
        
    </body>
</html>
