<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="padraomvc.model.bean.Usuario"%>
<%@page import="padraomvc.controller.ControllerUsuario"%>
<%@page import="padraomvc.model.bean.Gerente"%>
<%@page import="padraomvc.controller.ControllerGerente" %>
<%@page import="padraomvc.model.bean.UsuarioGerente"%>
<%@page import="padraomvc.controller.ControllerUsuarioGerente"%>
<%
    int idU = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idG = Integer.parseInt(request.getParameter("ID_GERENTE"));
    String obs = request.getParameter("OBS");
    UsuarioGerente usuger = new UsuarioGerente(idU, idG, obs);
    ControllerUsuarioGerente usugercont = new ControllerUsuarioGerente();
    usugercont.inserir(usuger);
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoUsuarioGerente.jsp";
    response.sendRedirect(url);

%>