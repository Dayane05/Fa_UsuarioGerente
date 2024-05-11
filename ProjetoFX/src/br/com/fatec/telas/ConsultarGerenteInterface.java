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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author ProfAlexandre
 */
public class ConsultarGerenteInterface implements Initializable {

    @FXML
    private Label lbLogin;

    @FXML
    private TextField txtNome;

    @FXML
    private TableView<Gerente> listaGerente;

    @FXML
    private TableColumn<Gerente,String> tid;

    @FXML
    private TableColumn<Gerente,String> tlogin;

    @FXML
    private TableColumn<Gerente,String> ttipo;

    @FXML
    private TableColumn<Gerente,String> tstatus;

    @FXML
    private TableColumn<Gerente,String> tip;
    
    @FXML
    private Button btAlterar;

    @FXML
    private Button btExcluir;

    @FXML
    private Button btVoltar;
    
    @FXML
    private Button btConsultar;

    ControllerGerente gerCont = null;
    
    ObservableList<Gerente> oList = null;

    List<Gerente> lista = null;
    
    public static Gerente gerSaidaTela = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }       
    
    private void initComponentes (){

        gerCont = new ControllerGerente();

        btConsultar.setOnAction((ActionEvent event) -> {
            Gerente ger = new Gerente(txtNome.getText());
            try {
                montaLista(ger);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Erro = Na Lista");
            }
        });

        btAlterar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TablePosition pos = listaGerente.getSelectionModel().getSelectedCells().get(0);
                int row = pos.getRow();
                setGerente(listaGerente.getItems().get(row));
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/AlterarGerenteInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(ConsultarGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        btExcluir.setOnAction((ActionEvent event) -> {
            TablePosition pos = listaGerente.getSelectionModel().getSelectedCells().get(0);
            int row = pos.getRow();
            Gerente ger = listaGerente.getItems().get(row);
            try {
                gerCont.excluir(ger);
                listaGerente.getItems().remove(row);
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
                    Logger.getLogger(ConsultarGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
    }
    
    public void montaLista(Gerente ger) throws SQLException, ClassNotFoundException {
        List<Object> listaObj = gerCont.listar(ger);
        lista = new ArrayList<>();

        for (Object objLista : listaObj) {
            lista.add((Gerente) objLista);
            System.out.println(objLista);
        }

        oList = FXCollections.observableArrayList(lista);
        tid.setCellValueFactory(new PropertyValueFactory<>("id"));
        tlogin.setCellValueFactory(new PropertyValueFactory<>("nome"));
        ttipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        tstatus.setCellValueFactory(new PropertyValueFactory<>("status"));
        tip.setCellValueFactory(new PropertyValueFactory<>("ip"));
        listaGerente.setItems(oList);
    }

    public void setGerente(Gerente usuG) {
        this.gerSaidaTela = usuG;
    }
    
    public Gerente getGerente() {
        return this.gerSaidaTela;
    }
}
