<%-- 
    Document   : Store
    Created on : 29-sep-2016, 13:32:51
    Author     : Daniel Aguilar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro Store</title>
    </head>
    <body>
        <form action="StoreController" method="post">
            <fieldset>
                <div>
                    <label>ID Store: </label>
                    <input type="text" name="idStore" value="${store.idStore}"
                           placeholder="idStore"
                           readonly="readonly"/>
                </div>
                <div>
                    <label>Nombre Store: </label>
                    <input type="text" name="name" value="${store.name}"
                           placeholder="Nombre"/>
                </div>

                <div>
                    <label>Direccion: </label>
                    <input type="text" name="adress" value="${store.adress}"
                           placeholder="Direccion"/>
                </div>
                <div>
                    <label>Telefono: </label>
                    <input type="text" name="phone" value="${store.phone}"
                           placeholder="Telefono"/>
                </div>
               
                <div>
                    <input type="submit" value="Guardar"/>
                </div>
            </fieldset>
        </form>
    </body>
</html>
