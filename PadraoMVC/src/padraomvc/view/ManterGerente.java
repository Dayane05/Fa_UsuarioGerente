/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package padraomvc.view;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerGerente;
import padraomvc.model.bean.Gerente;
import padraomvc.util.ViewBasico;

/**
 *
 * @author LAB 211
 */
public class ManterGerente implements ViewBasico {

    @Override
    public void menu() throws SQLException, ClassNotFoundException {
        String msg = " 1 - Inserir \n 2 - Alterar \n 3 - Buscar \n 4 - Excluir \n 5 - Listar " ;
        int num = Integer.parseInt(JOptionPane.showInputDialog(msg));
        switch (num) {
            case 1:
                inserir();
                break;
            case 2 :
                alterar();
                break;
            case 3: 
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
        String nome = JOptionPane.showInputDialog("NOME");
        String tipo = JOptionPane.showInputDialog("TIPO");
        String status = JOptionPane.showInputDialog("STATUS");
        String ip = JOptionPane.showInputDialog("IP");
        Gerente sisEnt = new Gerente(nome, tipo, status, ip);
        ControllerGerente contSist = new ControllerGerente();
        Gerente sisSaida = (Gerente) contSist.inserir(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void alterar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String nome = JOptionPane.showInputDialog("NOME");
        String tipo = JOptionPane.showInputDialog("TIPO");
        String status = JOptionPane.showInputDialog("STATUS");
        String ip = JOptionPane.showInputDialog("IP");
        Gerente sisEnt = new Gerente(id,nome, tipo, status, ip);
        ControllerGerente contSist = new ControllerGerente();
        Gerente sisSaida = (Gerente) contSist.alterar(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void buscar() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Gerente sisEnt = new Gerente(id);
        ControllerGerente contSist = new ControllerGerente();
        Gerente sisSaida = (Gerente) contSist.buscar(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void excluir() throws SQLException, ClassNotFoundException {
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        Gerente sisEnt = new Gerente(id);
        ControllerGerente contSist = new ControllerGerente();
        Gerente sisSaida = (Gerente) contSist.excluir(sisEnt);
        JOptionPane.showMessageDialog(null,sisSaida.toString());
    }

    @Override
    public void listar() throws SQLException, ClassNotFoundException {
        String nome = JOptionPane.showInputDialog("NOME");
        Gerente sisEnt = new Gerente(nome);
        ControllerGerente contSist = new ControllerGerente();
        List<Object> listaGerente = contSist.listar(sisEnt);
        for (Object Obj : listaGerente) {
            Gerente gerente = (Gerente) Obj;
            JOptionPane.showMessageDialog(null,gerente.toString());
        }
    }
    
}
