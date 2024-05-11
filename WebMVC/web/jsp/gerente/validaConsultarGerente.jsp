
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>

<%
    String nome = request.getParameter("NOME");
    Gerente ger = new Gerente(nome);
    ControllerGerente gercont = new ControllerGerente();
    List<Object> listaGerente = gercont.listar(ger);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + ger.getNome()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA GERENTE</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Tipo">Tipo</th>
                  <th data-field="Status">Status</th>
                  <th data-field="Ip">Ip</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(listaGerente.isEmpty())) { %>    
                <tbody>
                    <% for (Object sisObj : listaGerente) {
                        Gerente sisSaida = (Gerente) sisObj;
                    %>
                    <tr>
                            <td><%=sisSaida.getId()%></td>
                            <td><%=sisSaida.getNome()%></td>
                            <td><%=sisSaida.getTipo()%></td>
                            <td><%=sisSaida.getStatus()%></td>
                            <td><%=sisSaida.getIp()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirGerente.jsp?<%=url + sisSaida.getId()%>">Excluir</a></td>
                                <td><a href="alterarGerente.jsp?<%=url + sisSaida.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>