<%
    //if(session.getAttribute("Login") !="OK"){
    //    response.sendRedirect("Login.jsp");
    //}
//%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Participante"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
    <fieldset>
        
        <p style="text-align: center; font-size: 25px">
            SEGUNDO PARCIAL TEM-742
        </p>
        <p style="text-align: center; font-size: 25px">
            Nombre: Deymar Huanca Arcani
        </p>
        <p style="text-align: center; font-size: 25px">
            Carnet: 11545268
        </p>
    </fieldset>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Participantes</title>
</head>
<body>
    <div class="container"> 
        <h1>Participantes</h1>
        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="option" value="participantes"/>
        </jsp:include>

        <br>
        <a href="ParticipanteControlador?action=add" class="btn btn-primary btn-sm"><i class="fa-solid fa-circle-plus"></i> Nuevo</a>
        <table class="table table-striped">
            <tr>
                <th>Id</th>
                <th>Apellidos</th>
                <th>Nombres</th>
                <th>Id_seminario</th>
                <th>Confirmado</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${participantes}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.apellidos}</td>
                    <td>${item.nombres}</td>
                    <td>${item.id_seminario}</td>
                    <td>${item.confirmado}</td>
                    <td><a href="ParticipanteControlador?action=edit&id=${item.id}"><i class="fa-solid fa-pen-to-square"></i></a></td>
                    <td><a href="ParticipanteControlador?action=delete&id=${item.id}" onclick="return(confirm('¿Esta seguro?'))"><i class="fa-solid fa-trash-can"></i></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>