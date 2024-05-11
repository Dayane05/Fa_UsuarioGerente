<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.UsuarioGerente"%>
<%@page import="padraomvc.controller.ControllerUsuarioGerente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioGerente usuger = new UsuarioGerente(id);
    ControllerUsuarioGerente usugerCont = new ControllerUsuarioGerente();
    usugerCont.excluir(usuger);
    String pbusca = request.getParameter("PBUSCA");
    String url = "validaConsultarRelacaoUsuarioGerente.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>

