<%-- 
    Document   : listarStore
    Created on : 29-sep-2016, 13:38:46
    Author     : Daniel Aguilar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Listar Store</title>
    </head>
    <body>
         <table>
            <thead>
                <tr>
                    <th>ID Store</th>
                    <th>Nombre Store</th>
                    <th>Direccion</th>
                    <th>Telefono</th>
                    
                </tr>
            </thead>
            <tbody>
                <c:forEach var="store" items="${stores}">
                    <tr>
                        <td>${store.idStore}</td>
                        <td>${store.name}</td>
                        <td>${store.adress}</td>
                        <td>${store.phone}</td>
                        
                        <td><a href="StoreController?action=cambiar&idStore=${store.idStore}">Cambiar</a></td>
                        <td><a href="StoreController?action=borrar&idStore=${store.idStore}">Borrar</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <p>
            <a href="StoreController?action=agregar">Nueva Store</a>
        </p>
    </body>
</html>
