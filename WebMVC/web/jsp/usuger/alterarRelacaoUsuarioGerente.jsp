<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>
        

<%@page import="padraomvc.model.bean.UsuarioGerente"%>
<%@page import="padraomvc.controller.ControllerUsuarioGerente"%>

<%
    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Object> listaUsuario = usuCont.listar(usuEnt);
    
    ControllerGerente gerCont = new ControllerGerente();
    Gerente pf = new Gerente("");
    List<Object> listaGerente = gerCont.listar(pf);
    
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);

    UsuarioGerente ussis = new UsuarioGerente(id);
    ControllerUsuarioGerente usugercont = new ControllerUsuarioGerente();
    ussis = (UsuarioGerente) usugercont.buscar(ussis);
    
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO PESSOA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - USUÁRIO GERENTE</h1>
        <form name="alterarUsuarioGerente" action="validaAlterarRelacaoUsuarioGerente.jsp" method="post">
            <table>
                    <tr>
                        <td>Gerente:</td>
                        <td>
                            <select NAME ="ID_GERENTE" class="browser-default">
                               <% for (Object sisObj : listaGerente) {
                                    Gerente sisSaida = (Gerente) sisObj;
                               %>
                                   <% if( ussis.getIdG()== sisSaida.getId()) { %>
                                        <option selected value="<%=sisSaida.getId()%>"><%=sisSaida.getNome()%></option>
                                   <% } else { %>
                                        <option value="<%=sisSaida.getId()%>"><%=sisSaida.getNome()%></option>
                                   <% } %>
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
                                    <% if( ussis.getIdU()== usuSaida.getId()) { %>
                                        <option selected value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                    <% } else { %>
                                        <option value="<%=usuSaida.getId()%>"><%=usuSaida.getLogin()%></option>
                                    <% } %>

                               <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=ussis.getObs()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=ussis.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>