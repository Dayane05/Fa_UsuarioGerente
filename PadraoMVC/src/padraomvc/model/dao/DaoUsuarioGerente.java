/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.model.dao;

import padraomvc.model.bean.UsuarioGerente;
import padraomvc.util.ConexaoDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import padraomvc.model.bean.Gerente;
import padraomvc.model.bean.Usuario;
import padraomvc.util.DaoBasico;

/**
 *
 * @author User
 */
public class DaoUsuarioGerente implements DaoBasico {

    private final Connection c;
    
    public DaoUsuarioGerente() throws SQLException, ClassNotFoundException{
        this.c = ConexaoDb.getConexaoMySQL();
    }

    @Override
    public Object excluir(Object obj) throws SQLException{
        UsuarioGerente usuEnt = (UsuarioGerente) obj;
        String sql = "delete from usuarios_gerente WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuEnt.getId());
        // executa
        stmt.execute();
        stmt.close();
        c.close();
        return usuEnt;
    }
    
    @Override
    public Object buscar(Object obj) throws SQLException{
        UsuarioGerente usuEnt = (UsuarioGerente) obj;
        String sql = "select * from usuarios_gerente WHERE id = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setInt(1,usuEnt.getId());
            // executa
            ResultSet rs = stmt.executeQuery();
            UsuarioGerente usuSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new UsuarioGerente(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getInt(3),
                    rs.getString(4));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usuSaida;
   }
    
    public Object buscarLogin(String login) throws SQLException{
        String sql = "select * from usuarios WHERE login = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setString(1,login);
            // executa
            ResultSet rs = stmt.executeQuery();
            Usuario usuSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new Usuario(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usuSaida;
   }
    
   public Object buscarNome(String nome) throws SQLException{
        String sql = "select * from gerente WHERE nome = ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
            // seta os valores
            stmt.setString(1,nome);
            // executa
            ResultSet rs = stmt.executeQuery();
            Gerente usuSaida = null;
            while (rs.next()) {      
            // criando o objeto Usuario
                usuSaida = new Gerente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5));
            // adiciona o usu à lista de usus
            }
            stmt.close();
        return usuSaida;
   }

    @Override
    public Object inserir(Object obj) throws SQLException{
        UsuarioGerente usuEnt = (UsuarioGerente) obj;
        String sql = "insert into usuarios_gerente" + " (idU, idG, obs)" + " values (?,?,?)";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);

        // seta os valores
        stmt.setInt(1,usuEnt.getIdU());
        stmt.setInt(2,usuEnt.getIdG());
        stmt.setString(3,usuEnt.getObs());

        // executa
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1);
            usuEnt.setId(id);
        }
        stmt.close();
        return usuEnt;
    }

    @Override
    public Object alterar(Object obj) throws SQLException{
        UsuarioGerente usuEnt = (UsuarioGerente) obj;
        String sql = "UPDATE usuarios_gerente SET idU = ?, idG = ?, obs = ? WHERE id = ?";
        // prepared statement para inserção
        PreparedStatement stmt = c.prepareStatement(sql);
        // seta os valores
        stmt.setInt(1,usuEnt.getIdU());
        stmt.setInt(2,usuEnt.getIdG());
        stmt.setString(3,usuEnt.getObs());
        stmt.setInt(4,usuEnt.getId());

        // executa
        stmt.execute();
        stmt.close();
        return usuEnt;
    }

    @Override
    public List<Object> listar(Object obj) throws SQLException{
         UsuarioGerente usuEnt = (UsuarioGerente) obj;
        // usus: array armazena a lista de registros
        List<Object> usus = new ArrayList<>();
        
        String sql = "select * from usuarios_gerente where obs like ?";
        PreparedStatement stmt = this.c.prepareStatement(sql);
        // seta os valores
        stmt.setString(1,"%" + usuEnt.getObs()+ "%");
        
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {      
            // criando o objeto Usuario
            UsuarioGerente usuger = new UsuarioGerente(
                rs.getInt(1),
                rs.getInt(2),
                rs.getInt(3),
                rs.getString(4)
            );
            // adiciona o usu à lista de usus
            usus.add(usuger);
        }
        
        rs.close();
        stmt.close();
        return usus;
   }  
}
