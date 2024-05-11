/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

import br.com.fatec.telas.LoginInterface;
import padraomvc.model.bean.Usuario;
import padraomvc.controller.ControllerUsuario;
import padraomvc.model.bean.Gerente;
import padraomvc.controller.ControllerGerente;
import padraomvc.model.bean.UsuarioGerente;
import padraomvc.controller.ControllerUsuarioGerente;
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
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author ProfAlexandre
 */
public class InserirUsuarioGerenteInterface implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private Button btSalvar;

    @FXML
    private Label lbGerente;
    
    @FXML
    private ComboBox<Gerente> cbGerente;
    
    private ObservableList<Gerente> observableListGerente;

    @FXML
    private Label lbUsuario;
    
    @FXML
    private ComboBox<Usuario> cbUsuario;
    
    private ObservableList<Usuario> observableListUsuario;

    @FXML
    private Label lbObservacao;
    
    @FXML
    private TextField txtObservacao;
    
    private ObservableList<UsuarioGerente> observableListUsuarioGerente;
    
    @FXML
    private Button btVoltar;

    ControllerUsuario usuCont = null;
    
    ControllerGerente gerCont = null;
    
    ControllerUsuarioGerente usugerCont = null;

    List<Gerente> listaGerente = null;    
    
    List<Usuario> listaUsuario = null;
 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
        try {
            carregarComboBoxGerente();
            carregarComboBoxUsuarios();
        } catch (SQLException ex) {
            Logger.getLogger(InserirUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InserirUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
    private void initComponentes () { 
        gerCont = new ControllerGerente();        
        usuCont = new ControllerUsuario();

        
        btSalvar.setOnAction((ActionEvent event) -> {
            usugerCont = new ControllerUsuarioGerente();
            UsuarioGerente usuger = new UsuarioGerente(
                    cbUsuario.getSelectionModel().getSelectedItem().getId(), 
                    cbGerente.getSelectionModel().getSelectedItem().getId(),  
                    txtObservacao.getText() );
            try {
                usuger = (UsuarioGerente) usugerCont.inserir(usuger);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, usuger.getId());
        });
        
        
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
                    Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
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