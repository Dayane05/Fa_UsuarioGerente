<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>
<%@page import="padraomvc.model.bean.UsuarioGerente"%>
<%@page import="padraomvc.controller.ControllerUsuarioGerente"%>

<%
    String obs = request.getParameter("OBS");
    UsuarioGerente usuger = new UsuarioGerente(obs);
    ControllerUsuarioGerente usugercont = new ControllerUsuarioGerente();
    List<Object> listausuger = usugercont.listar(usuger);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usuger.getObs()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA RELAÇÃO</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdUsuGer">Id</th>
                  <th data-field="IdU">IdUsuario</th>
                  <th data-field="Login">Login</th>
                  <th data-field="IdG">IdGerente</th>
                  <th data-field="NomeGerente">Gerente</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listausuger.isEmpty())) { %>    
                <tbody>
                    <% for (Object objUsuGer : listausuger) { 
                        UsuarioGerente usuSistSaida = (UsuarioGerente) objUsuGer;
                        Usuario usuSaida = (Usuario) usuSistSaida.getUsu();
                        Gerente sisSaida = (Gerente) usuSistSaida.getGer();
                        %>
                        <tr>
                            <td><%=usuSistSaida.getId()%></td>
                            <td><%=usuSistSaida.getIdU()%></td>
                            <td><%=usuSaida.getLogin()%></td>
                            <td><%=usuSistSaida.getIdG()%></td>
                            <td><%=sisSaida.getNome()%></td>
                            <td><%=usuSistSaida.getObs()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoUsuarioGerente.jsp?<%=url + usuSistSaida.getId()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoUsuarioGerente.jsp?<%=url + usuSistSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>