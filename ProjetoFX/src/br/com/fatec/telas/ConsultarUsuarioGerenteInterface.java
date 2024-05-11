/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatec.telas;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import padraomvc.controller.ControllerUsuarioGerente;
import padraomvc.model.bean.UsuarioGerente;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author ProfAlexandre
 */
public class ConsultarUsuarioGerenteInterface implements Initializable {

    @FXML
    private Label lbObservacao;

    @FXML
    private TextField txtObservacao;

    @FXML
    private TableView<UsuarioGerente> listaUsuarioGerente;

    @FXML
    private TableColumn<UsuarioGerente,String> tid;

    @FXML
    private TableColumn<UsuarioGerente,Integer> tidUsuario;
    
    @FXML
    private TableColumn<UsuarioGerente,Integer> tlogin;


    @FXML
    private TableColumn<UsuarioGerente,Integer> tidGerente;

    @FXML
    private TableColumn<UsuarioGerente,String> tgerente;    
    
    @FXML
    private TableColumn<UsuarioGerente,String> tobservacao;

    
    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerUsuarioGerente usugerCont = null;
    
    ObservableList<UsuarioGerente> oList = null;

    List<UsuarioGerente> lista = null;
    
    public static UsuarioGerente usugerSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        usugerCont = new ControllerUsuarioGerente();

        btConsultar.setOnAction((ActionEvent event) -> {
            UsuarioGerente usuger = new UsuarioGerente(txtObservacao.getText());
            
            try {
                montaLista(usuger);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuarioGerente.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            setUsuarioGerente(listaUsuarioGerente.getItems().get(row));
            System.out.println(listaUsuarioGerente.getItems().get(row));
            FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/AlterarUsuarioGerenteInterface.fxml"));
            Parent novatela = null;
            try {
                novatela = loader.load();
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(ConsultarUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaUsuarioGerente.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            UsuarioGerente usuger = listaUsuarioGerente.getItems().get(row);
            try {
                usugerCont.excluir(usuger);
                listaUsuarioGerente.getItems().remove(row);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(ConsultarGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = No Excluir");

            }
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
                    Logger.getLogger(ConsultarUsuarioGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });   
    }
    
    public void montaLista(UsuarioGerente usuger) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = usugerCont.listar(usuger);
        lista = new ArrayList<>();
        

        for (Object objLista : listaObj) {
            lista.add((UsuarioGerente) objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tidUsuario.setCellValueFactory(new PropertyValueFactory<>("idU"));
        tlogin.setCellValueFactory(new PropertyValueFactory<>("usu"));
        tidGerente.setCellValueFactory(new PropertyValueFactory<>("idG"));        
        tgerente.setCellValueFactory(new PropertyValueFactory<>("ger"));        
        tobservacao.setCellValueFactory(new PropertyValueFactory<>("obs"));

        listaUsuarioGerente.setItems(oList);
    }

    public void setUsuarioGerente (UsuarioGerente usuger) {
        this.usugerSaidaTela = usuger;
    }
    
    public UsuarioGerente getUsuarioGerente() {
        return this.usugerSaidaTela;
    }
}
