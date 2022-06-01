<%
    String option = request.getParameter("option");
%>

<ul class="nav nav-tabs">
    <li class="nav-item">
        <a class="nav-link <%=(option.equals("seminarios") ? "active" : "")%>" href="SeminarioControlador">Seminarios</a>
    </li>
    <li class="nav-item">
        <a class="nav-link <%=(option.equals("participantes") ? "active" : "")%>" href="ParticipanteControlador">Participantes</a>
    </li>
</ul>
