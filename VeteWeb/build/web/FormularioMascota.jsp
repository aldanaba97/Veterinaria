<%-- 
    Document   : FormularioMascota
    Created on : 3 dic. 2020, 21:28:23
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

        <form method="POST" action="altoMasco">
            <div class="container col-6">
                <h1>Cargar una mascota</h1>
                <div class="card border-light">
                    <div class="card-body " style="background-color: #FFF7E2">

                        
                        <div class="form-group">
                            <label for="inputAddress">Nombre de la mascota</label>
                            <input type="text" class="form-control" id="inputAddress" name="txtNombre" placeholder="Escriba el nombre de la mascota">
                        </div>
                        <div class="form-group">
                            <label for="inputAddress2">Nacimiento</label>
                            <input type="number" class="form-control" id="inputAddress2" name="txtNacimiento" placeholder="Escriba año de nacimiento de la mascota">
                        </div>

                        <div class="form-group">
                            <label for="inputState">Elegir dueño</label>
                            <select id="inputState" class="form-control" name="cboCliente">
                                <option selected>Elegir</option>
                                <c:forEach var="c" items="${cliente}">
                                    <option value="${c.id_cliente}"> ${c.nombreCliente}</option>  
                                </c:forEach>

                            </select>
                        </div>
                        <div class="form-group">
                            <label for="inputState">Elegir especie</label>
                            <select id="inputState" class="form-control" name="cboEspecie">
                                <option selected>Elegir</option>
                                <c:forEach var="e" items="${especie}">
                                    <option value="${e.id_especialidad}"> ${e.descripcion}</option>  
                                </c:forEach>
                            </select>
                        </div>
                        <br>
                        <button type="submit" class="btn btn-warning">Cargar</button>
                    </div>
                </div>
                <br>
                
                <p align="left">
                 <a href="index.html" class="btn btn-warning">Volver</a>   
                </p>
                
            </div>


        </div>
    </form>
        <%@include file = "estilo/elementos/nvar.jsp" %>
</body>
</html>
