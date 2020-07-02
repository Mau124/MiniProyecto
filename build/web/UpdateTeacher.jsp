<%-- 
    Document   : UpdateTeacher
    Created on : 1/07/2020, 09:21:02 PM
    Author     : 52333
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
                <h1 class="display-4">Modificar maestro</h1>
            </div>
        </div>
        
        <% 
            int ID = Integer.parseInt(request.getParameter("IDTeacher"));
            String name = request.getParameter("name");
            String lastName = request.getParameter("lastName");
            int IDAcademy = Integer.parseInt(request.getParameter("Academy"));
        %>
        
        <div class="container">
            <form action="UpdateStudentController" method="GET">
                <div class="form-group">
                    <label for="IDTeacher">ID</label>
                    <input type="text" class="form-control" id="register" name="IDTeacher" readonly value="<%= request.getParameter("IDTeacher") %>">
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
                    <label for="Academy">Clave de ciudad</label>
                    <input type="text" class="form-control" id="codeCity" name="Academy" value="<%= request.getParameter("IDAcademy") %>">
                </div>
                <button type="submit" class="btn btn-primary">Modificar</button>
            </form>
        </div>
        
    </body>
</html>
