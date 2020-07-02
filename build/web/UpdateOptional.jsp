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
        <title>Modificar materia opcional</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"  crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="jumbotron jumbotron-fluid">
            <div class="container">
                <h1 class="display-4">Modificar materia opcional</h1>
            </div>
        </div>
        
        <% 
            int IDOptional = Integer.parseInt(request.getParameter("codeOptional"));
            String name = request.getParameter("name");
            int credits = Integer.parseInt(request.getParameter("credits"));
            int codeCarer = Integer.parseInt(request.getParameter("codeCarer"));
        %>
        
        <div class="container">
            <form action="UpdateOptionalController" method="GET">
                <div class="form-group">
                    <label for="codeOptional">ID</label>
                    <input type="text" class="form-control" id="codeOptional" name="codeOptional" readonly value="<%= request.getParameter("codeOptional") %>">
                </div>
                <div class="form-group">
                    <label for="name">Nombre</label>
                    <input type="text" class="form-control" id="name" name="name" value="<%= request.getParameter("name") %>" >
                </div> 
                <div class="form-group">
                    <label for="credits">Creditos</label>
                    <input type="text" class="form-control" id="credits" name="credits" value="<%= request.getParameter("credits") %>">
                </div>
                <div class="form-group">
                    <label for="codeCarer">Clave de la carrera</label>
                    <input type="text" class="form-control" id="codeCarer" name="codeCarer" value="<%= request.getParameter("codeCarer") %>">
                </div>
                <button type="submit" class="btn btn-primary">Modificar</button>
            </form>
        </div>
        
    </body>
</html>