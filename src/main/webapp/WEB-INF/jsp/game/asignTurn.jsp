<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sevenislands" tagdir="/WEB-INF/tags" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<style>
    body {
        background-image: url("/resources/images/grafics/tablero.png");
        background-size: cover;
        background-repeat: no-repeat;
        background-position: center;
        background-attachment: fixed;
    }
</style>
<sevenislands:layout2 pageName="lobby_asignTurn">
    <body>
        <div>
            <a class="btn btn-default" href="<spring:url value='/home' htmlEscape='true'/>">ABANDONAR PARTIDA</a>
        </div>
        <div>
            <center>
                <a title="partida" href="/turn/newRound"><img src="/resources/images/grafics/boton.png" alt="partida" height="150" width="150"/></a>
            </center>
        </div>
    </body>
</sevenislands:layout2>