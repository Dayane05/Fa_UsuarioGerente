<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - GERENTE</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR GERENTE</h1>
       <form name="consultarGerente" action="validaConsultarGerente.jsp" method="post">
           NOME <input type="text" name ="NOME" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
