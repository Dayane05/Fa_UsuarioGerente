<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Gerente ger = new Gerente(id);
    ControllerGerente gerCont = new ControllerGerente();
    ger = (Gerente) gerCont.buscar(ger);
    String pbusca = request.getParameter("PBUSCA");

%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - GERENTE</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR GERENTE</h1>
        <form name="alterarGerente" action="validaAlterarGerente.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=ger.getNome()%>"> <br>
            Tipo: <input type="text" name="TIPO" value="<%=ger.getTipo()%>"> <br>
            Status: <input type="text" name="STATUS" value="<%=ger.getStatus()%>"> <br>
            Ip: <input type="text" name="IP" value="<%=ger.getIp()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=ger.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>