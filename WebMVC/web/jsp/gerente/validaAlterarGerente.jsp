<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String tipo = request.getParameter("TIPO");
    String status = request.getParameter("STATUS");
    String ip = request.getParameter("IP");
    Gerente ger = new Gerente(id, nome, tipo, status, ip);
    ControllerGerente gercont = new ControllerGerente();
    gercont.alterar(ger);
    String pbusca = request.getParameter("PBUSCA");
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarGerente.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>