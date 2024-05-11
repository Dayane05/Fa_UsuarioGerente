/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import padraomvc.model.bean.Gerente;
import padraomvc.controller.ControllerGerente;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerUsuario;
import padraomvc.controller.ControllerUsuarioGerente;
import padraomvc.model.bean.Usuario;
import padraomvc.model.bean.UsuarioGerente;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author ProfAlexandre
 */
public class AlterarUsuarioGerenteInterface implements Initializable {

    @FXML
    private Button btSalvar;

    @FXML
    private Label lbGerente;
    
    @FXML
    private ComboBox<Gerente> cbGerente;
    
    private ObservableList<Gerente> observableListGerente = null;

    @FXML
    private Label lbUsuario;
    
    @FXML
    private ComboBox<Usuario> cbUsuario;
    
    private ObservableList<Usuario> observableListUsuario;

    @FXML
    private Label lbObservacao;
    
    @FXML
    private TextField txtObservacao;
    
    @FXML
    private Button btVoltar;
    
    @FXML
    private Label lbIdT;

    @FXML
    private Label lbId;
    
    UsuarioGerente usuger = null;

    ControllerUsuarioGerente usugerCont = null;
    
    ControllerUsuario usuCont = null;
    
    ControllerGerente gerCont = null;
    
    List<Gerente> listaGerente = null;    
    
    List<Usuario> listaUsuario = null;
    
    private String nLogin;
    
    private String nGerente;
    
    
    List<UsuarioGerente> listaUsuarioGerente = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try { 
            initComponentes();
        } catch (SQLException ex) {
            Logger.getLogger(AlterarUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AlterarUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        try {
            carregarComboBoxGerente();
            carregarComboBoxUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(InserirUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InserirUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    private void initComponentes () throws SQLException, ClassNotFoundException{
        gerCont = new ControllerGerente();        
        usuCont = new ControllerUsuario();

        usugerCont = new ControllerUsuarioGerente();
        ConsultarUsuarioGerenteInterface telaAnterior = new ConsultarUsuarioGerenteInterface();
        setUsuarioGerente(telaAnterior.getUsuarioGerente());

        btVoltar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btSalvar.setOnAction((ActionEvent event) -> {
            Usuario usuEnt = (Usuario) cbUsuario.getSelectionModel().getSelectedItem();
            Gerente gerEnt = (Gerente) cbGerente.getSelectionModel().getSelectedItem();
            
            usuger = new UsuarioGerente(
                    Integer.parseInt(lbIdT.getText()),
                    usuEnt.getId(),
                    gerEnt.getId(),
                    txtObservacao.getText());
            try {
                usugerCont.alterar(usuger);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(AlterarUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/MenuInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(AlterarUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void setUsuarioGerente(UsuarioGerente usuger) {
        JOptionPane.showMessageDialog(null, usuger.getId());
        this.lbIdT.setText(""+usuger.getId());
        this.cbUsuario.setPromptText(usuger.getnUsuario());
        this.cbGerente.setPromptText(usuger.getnGerente());
        this.txtObservacao.setText(usuger.getObs());
    }
    
        public void carregarComboBoxGerente()throws SQLException, ClassNotFoundException {
        Gerente pf = new Gerente("");
        List<Object> listaObj = gerCont.listar(pf);
        listaGerente = new ArrayList<>();
        
        for(Object objlista : listaObj){
            listaGerente.add((Gerente) objlista);
        }
        
        observableListGerente = FXCollections.observableArrayList(listaGerente);
        
        cbGerente.setItems(observableListGerente);
    }
    
        public void carregarComboBoxUsuarios()throws SQLException, ClassNotFoundException {
        Usuario usu = new Usuario("");
        List<Object> listaObj = usuCont.listar(usu);
        listaUsuario = new ArrayList<>();
        
        for(Object objlista : listaObj){
            listaUsuario.add((Usuario) objlista);
        }
        
        observableListUsuario = FXCollections.observableArrayList(listaUsuario);
        
        cbUsuario.setItems(observableListUsuario);
    } 
}
    
