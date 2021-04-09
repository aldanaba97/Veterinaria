<%-- 
    Document   : ListadoMascota
    Created on : 3 dic. 2020, 21:28:58
    Author     : Aldana
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="estilo/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="estilo/css/business-frontpage.css" rel="stylesheet" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
   
        <div class="container">
            <h1>Todas las mascotas</h1>
            <table class="table table-hover table-warning" style="background-color: #FFF7E2">
                <thead>
                    <tr style="background-color: #ffdf7e">
                        <th scope="col">Nombre de la mascota</th>
                        <th scope="col">Dueño</th>
                        <th scope="col">Telefono</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${lista}" var="m">
                        <tr>
                            <td>${m.nombre}</td>
                            <td>${m.c.nombreCliente}</td>
                            <td>${m.c.telefono}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <a href="index.html" class="btn btn-warning">Volver </a>
        </div>

    </body>
</html>
