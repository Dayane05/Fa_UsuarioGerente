<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Gerente ger = new Gerente(id);
    ControllerGerente gerCont = new ControllerGerente();
    gerCont.excluir(ger);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarGerente.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>