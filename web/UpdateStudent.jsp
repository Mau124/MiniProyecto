<%-- 
    Document   : UpdateStudent
    Created on : 1/07/2020, 10:36:32 PM
    Author     : Andres
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Modificar estudiante</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"  crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4">Modificar estudiante</h1>
            </div>
        </div>
        
        <% 
            String register = request.getParameter("register");
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            int codeCity = Integer.parseInt(request.getParameter("codeCity"));
            int codeCarer = Integer.parseInt(request.getParameter("codeCarer"));
        %>
        
        <div class="container">
            <form action="UpdateStudentController" method="GET">
                <div class="form-group">
                    <label for="register">Registro</label>
                    <input type="text" class="form-control" id="register" name="register" readonly value="<%= request.getParameter("register") %>">
                </div>
                <div class="form-group">
                    <label for="name">Nombre</label>
                    <input type="text" class="form-control" id="name" name="name" value="<%= request.getParameter("name") %>" >
                </div> 
                <div class="form-group">
                    <label for="lastName">Apellido</label>
                    <input type="text" class="form-control" id="lastName" name="lastName" value="<%= request.getParameter("lastName") %>">
                </div>
                <div class="form-group">
                    <label for="codeCity">Clave de ciudad</label>
                    <input type="text" class="form-control" id="codeCity" name="codeCity" value="<%= request.getParameter("codeCity") %>">
                </div>
                <div class="form-group">
                    <label for="codeCarer">Clave de carrera</label>
                    <input type="text" class="form-control" id="codeCarer" name="codeCarer" value="<%= request.getParameter("codeCarer") %>">
                </div>
                <button type="submit" class="btn btn-primary">Modificar</button>
            </form>
        </div>
        
    </body>
</html>
