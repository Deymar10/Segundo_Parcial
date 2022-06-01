<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Seminario"%>
<%
    Seminario seminario = (Seminario) request.getAttribute("seminario");
%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="es">
    <head>
        <fieldset>
        <p style="text-align: center; font-size: 22px">
            SEGUNDO PARCIAL TEM-742
        </p>
        <p style="text-align: center; font-size: 22px">
            Nombre: Deymar Huanca Arcani
        </p>
        <p style="text-align: center; font-size: 22px">
            Carnet: 11545268
        </p>
    </fieldset>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" rel="stylesheet">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

        <title>seminario</title>
    </head>
    <body>
        <div class="container">
            <h1>Formulario de seminarios</h1>
            <jsp:include page="WEB-INF/menu.jsp">
                <jsp:param name="option" value="seminario"/>
            </jsp:include>
            <br>
            <form action="SeminarioControlador" method="post">
                <input type="hidden" name="id" value="${seminario.id}" />
                <div class="mb-3">
                    <label for="" class="form-label">Titulo</label>
                    <input type="text" class="form-control" name="titulo" value="${seminario.titulo}" placeholder="Escriba el nombre del seminario">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Fecha</label>
                    <input type="text" class="form-control" name="fecha" value="${seminario.fecha}" placeholder="Escriba la fecha ejemplo 2022-05-19">
                </div>
                <div class="mb-3">
                    <label for="" class="form-label">Cupo</label>
                    <input type="text" class="form-control" name="cupo" value="${seminario.cupo}" placeholder="Escriba el cupo">
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    </body>
</html>