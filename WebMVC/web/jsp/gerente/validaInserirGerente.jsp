<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>

<%
    String nome = request.getParameter("NOME");
    String tipo = request.getParameter("TIPO");
    String status = request.getParameter("STATUS");
    String ip = request.getParameter("IP");
    Gerente ger = new Gerente(nome, tipo, status, ip);
    ControllerGerente gercont = new ControllerGerente();
    gercont.inserir(ger);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirGerente.jsp";
    response.sendRedirect(url);
%>

