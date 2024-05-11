/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import padraomvc.controller.ControllerUsuarioGerente;
import padraomvc.model.bean.UsuarioGerente;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.util.ViewBasico;

/**
 *
 * @author User
 */
public class ManterUsuarioGerente implements ViewBasico{
    
    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1 : 
                inserir();
                break;
            case 2 : 
                alterar();
                break;
            case 3 : 
                buscar();
                break;
            case 4 : 
                excluir();
                break;
            case 5 : 
                listar();
                break;
            default : 
                System.out.println("Opcao inválida");
                break;
        }
    }

    @Override
    public void inserir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idG = Integer.parseInt(JOptionPane.showInputDialog("IDG"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioGerente usugerEnt = new UsuarioGerente(id,idU, idG, obs);
        ControllerUsuarioGerente contUsu = new ControllerUsuarioGerente();
        UsuarioGerente usuSaida = (UsuarioGerente) contUsu.inserir(usugerEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        int idU = Integer.parseInt(JOptionPane.showInputDialog("IDU"));
        int idG = Integer.parseInt(JOptionPane.showInputDialog("IDG"));
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioGerente usugerEnt = new UsuarioGerente(id, idU, idG, obs);
        ControllerUsuarioGerente contUsu = new ControllerUsuarioGerente();
        UsuarioGerente usuSaida = (UsuarioGerente) contUsu.alterar(usugerEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioGerente usugerEnt = new UsuarioGerente(id);
        ControllerUsuarioGerente contUsu = new ControllerUsuarioGerente();
        UsuarioGerente usuSaida = (UsuarioGerente) contUsu.buscar(usugerEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
        JOptionPane.showMessageDialog(null,usuSaida.getUsu().toString());
        JOptionPane.showMessageDialog(null,usuSaida.getGer().toString());

    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        UsuarioGerente usugerEnt = new UsuarioGerente(id);
        ControllerUsuarioGerente contUsu = new ControllerUsuarioGerente();
        UsuarioGerente usuSaida = (UsuarioGerente) contUsu.excluir(usugerEnt);
        JOptionPane.showMessageDialog(null,usuSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String obs = JOptionPane.showInputDialog("OBS");
        UsuarioGerente usugerEnt = new UsuarioGerente(obs);
        ControllerUsuarioGerente contUsu = new ControllerUsuarioGerente();
        List<Object> listaUsuario = contUsu.listar(usugerEnt);
        for (Object usuObj : listaUsuario) {
            UsuarioGerente usuSaida = (UsuarioGerente) usuObj;
            JOptionPane.showMessageDialog(null,usuSaida.toString());
            JOptionPane.showMessageDialog(null,usuSaida.getUsu().toString());
            JOptionPane.showMessageDialog(null,usuSaida.getGer().toString());
        }
    }

}
