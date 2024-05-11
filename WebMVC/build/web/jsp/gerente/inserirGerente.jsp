<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - GERENTE</title>
    <body>
       <div class="container"/>
        <h1>INSERIR GERENTE</h1>
        <form name="inserirGerente" action="validaInserirGerente.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Tipo: <input type="text" name="TIPO" value=""> <br>
            Status: <input type="text" name="STATUS" value=""> <br>
            Ip: <input type="text" name="IP" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>

