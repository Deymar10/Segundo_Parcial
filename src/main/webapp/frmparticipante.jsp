<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.emergentes.modelo.Participante"%>
<%
    Participante participante = (Participante) request.getAttribute("participante");
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


    <title>Participante</title>
</head>
<body>
    <div class="container">
        <h1>Formulario de participantes</h1>
        <jsp:include page="WEB-INF/menu.jsp">
            <jsp:param name="option" value="participantes"/>
        </jsp:include>
        <br>
        <form action="ParticipanteControlador" method="post">
            <input type="hidden" name="id" value="${participante.id}" />
            <div class="mb-3">
                <label for="" class="form-label">Apellidos</label>
                <input type="text" class="form-control" name="nombres" value="${participante.apellidos}" placeholder="Escriba el apellido">
            </div>
            <div class="mb-3">
                <label for="" class="form-label">Nombres</label>
                <input type="text" class="form-control" name="apellidos" value="${participante.nombres}" placeholder="Escriba la nombre">
            </div>
            <div class="mb-3">
                    <label for="nombre" class="form-label">Seminario</label>                    
                    <select name="id_seminario" class="form-label">
                        <option value="">-- Seleccione --</option>
                        <c:forEach var="item" items="${lista_seminario}">                        
                            <option value="${item.id}" 
                                    <c:if test="${participante.id_seminario == item.id}">
                                        selected
                                    </c:if> >${item.titulo}</option>
                        </c:forEach>
                    </select>
                </div>
            <div class="mb-3">
                <label for="" class="form-label">Confirmado</label>
                <input type="text" class="form-control" name="confirmado" value="${participante.confirmado}" placeholder="Escriba el confirmado">
            </div>
            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
</body>
</html>