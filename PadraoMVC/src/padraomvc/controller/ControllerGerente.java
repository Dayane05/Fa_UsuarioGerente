/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.controller;

import java.sql.SQLException;
import java.util.List;
import padraomvc.model.dao.DaoGerente;
import padraomvc.util.ControllerBasico;

/**
 *
 * @author LAB 211
 */
public class ControllerGerente implements ControllerBasico {
    
    DaoGerente dao;

    @Override
    public Object inserir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoGerente();
        return dao.inserir(obj);
    }

    @Override
    public Object alterar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoGerente();
        return dao.alterar(obj);
    }

    @Override
    public Object buscar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoGerente();
        return dao.buscar(obj);
    }

    @Override
    public Object excluir(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoGerente();
        return dao.excluir(obj);
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException, ClassNotFoundException {
        dao = new DaoGerente();
        return dao.listar(obj);
     }
    
    public List<Object> listarTudo(String nome) throws SQLException, ClassNotFoundException {
        dao = new DaoGerente();
        return dao.listarTudo(nome);
     } 
}
