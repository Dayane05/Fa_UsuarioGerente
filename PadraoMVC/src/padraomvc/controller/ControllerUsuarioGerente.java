/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Gerente;
import padraomvc.model.bean.Usuario;
import padraomvc.model.bean.UsuarioGerente;
import padraomvc.model.dao.DaoUsuarioGerente;
import padraomvc.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerUsuarioGerente implements ControllerBasico {
    
    DaoUsuarioGerente dao;
    ControllerUsuario contUsu;
    ControllerGerente contGer;
    
    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGerente();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGerente();
        return dao.alterar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGerente();
        return dao.excluir(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGerente();
        UsuarioGerente objSaida = (UsuarioGerente) dao.buscar(obj);
        Object usu = new Usuario(objSaida.getIdU());
        Object ger = new Gerente(objSaida.getIdG());
        contUsu = new ControllerUsuario();
        contGer = new ControllerGerente();
        
        Usuario usuEnt = (Usuario) contUsu.buscar(usu);
        Gerente gerEnt = (Gerente) contGer.buscar(ger);
        
        
        ger = contGer.buscar(ger);
        objSaida.setnUsuario(usuEnt.getLogin());
        objSaida.setnGerente(gerEnt.getNome());
        objSaida.setUsu(contUsu.buscar(usu));
        objSaida.setGer(contGer.buscar(ger));
        
        return objSaida;
    }
    
    public Object buscarLogin(String login) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGerente();
        return dao.buscarLogin(login);
    }
    
    public Object buscarNome(String nome) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGerente();
        return dao.buscarNome(nome);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoUsuarioGerente();
        List<Object> listaAux = dao.listar(obj);
        List<Object> lista = new ArrayList<>();
        for (Object objlista : listaAux) {
            lista.add(buscar(objlista));
        }
        return lista;
     }
    
}
