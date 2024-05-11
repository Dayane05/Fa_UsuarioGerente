<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>
<%@page import="padraomvc.model.bean.UsuarioGerente"%>
<%@page import="padraomvc.controller.ControllerUsuarioGerente"%>

<%
    ControllerGerente gerCont = new ControllerGerente();
    Gerente pf = new Gerente("");
    List<Object> listaGerente = gerCont.listar(pf);

    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Object> listaUsuario = usuCont.listar(usuEnt);
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR RELAÇÕES</title>
    <body>
        <div class="container"/>
            <h1>Inserir Usuario Gerente</h1>
            <form name="inseriUsuarioGerente" action="validaRelacaoUsuarioGerente.jsp" method="POST">
                <table>
                    <tr>
                        <td>Gerente:</td>
                        <td>
                            <select NAME ="ID_GERENTE" class="browser-default">
                               <% for (Object sisObj : listaGerente) {
                                    Gerente sisSaida = (Gerente) sisObj;
                                %>
                                    <option value="<%=sisSaida.getId()%>"><%=sisSaida.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                               <% for (Object usuObj : listaUsuario) {
                                    Usuario usuSaida = (Usuario) usuObj;
                                %>
                                    <option value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
