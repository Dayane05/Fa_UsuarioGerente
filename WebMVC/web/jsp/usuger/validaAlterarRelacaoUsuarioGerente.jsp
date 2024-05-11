<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente"%>
<%@page import="padraomvc.model.bean.UsuarioGerente"%>
<%@page import="padraomvc.controller.ControllerUsuarioGerente"%>


<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idU = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idG = Integer.parseInt(request.getParameter("ID_GERENTE"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    UsuarioGerente ussis = new UsuarioGerente(id, idU, idG, obs);
    ControllerUsuarioGerente usugercont = new ControllerUsuarioGerente();
    usugercont.alterar(ussis);
    String url = "validaConsultarRelacaoUsuarioGerente.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    