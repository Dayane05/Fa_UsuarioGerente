/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import padraomvc.util.DaoBasico;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Gerente;
import padraomvc.util.ConexaoDb;

/**
 *
 * @author LAB 211
 */
public class DaoGerente implements DaoBasico {
    
    private final Connection c;
    
    public DaoGerente() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }
    
    @Override
    public Object inserir(Object obj) throws SQLException {
        Gerente sisEnt = (Gerente) obj;
        String sql = "insert into gerente" + " (nome, tipo, status, ip)" + " values (?,?,?,?)";
    
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setString(1,sisEnt.getNome());
        stmt.setString(2,sisEnt.getTipo());
        stmt.setString(3,sisEnt.getStatus());
        stmt.setString(4,sisEnt.getIp());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            sisEnt.setId(id);
        }
        stmt.close();
        return sisEnt;
    }
    
    @Override
    public Object alterar(Object obj) throws SQLException {
        Gerente sisEnt = (Gerente) obj;
        String sql = "UPDATE gerente SET nome = ?, tipo = ?, status = ?, ip = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,sisEnt.getNome());
        stmt.setString(2,sisEnt.getTipo());
        stmt.setString(3,sisEnt.getStatus());
        stmt.setString(4,sisEnt.getIp());
        stmt.setInt(5,sisEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        return sisEnt;
    }

    @Override
    public Object excluir(Object obj) throws SQLException {
        Gerente sisEnt = (Gerente) obj;
        String sql = "delete from gerente WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,sisEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return sisEnt;
    }

    @Override
    public Object buscar(Object obj) throws SQLException {
        Gerente sisEnt = (Gerente) obj;
        String sql = "select * from gerente WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,sisEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            Gerente sisSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                sisSaida = new Gerente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return sisSaida;
    }
    
    
    @Override
    public List<Object> listar(Object obj) throws SQLException  {
        Gerente sisEnt = (Gerente) obj;
        // usus: array armazena a lista de registros
        List<Object> geren = new ArrayList<>();
        
        String sql = "select * from gerente where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + sisEnt.getNome() + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Gerente ger = new Gerente(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            geren.add(ger);
        }
        
        rs.close();
        stmt.close();
        return geren;
    }
    
    public List<Object> listarTudo(String nome) throws SQLException  {
        // usus: array armazena a lista de registros
        List<Object> geren = new ArrayList<>();
        
        String sql = "select * from gerente where nome like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + nome + "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            Gerente ger = new Gerente(
                rs.getInt(1),
                rs.getString(2),
                rs.getString(3),
                rs.getString(4),
                rs.getString(5)
            );
            // adiciona o usu à lista de usus
            geren.add(ger);
        }
        
        rs.close();
        stmt.close();
        return geren;
    }
}
