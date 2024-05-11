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
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
public class AlterarGerenteInterface implements Initializable {

    @FXML
    private Button btSalvar;

    @FXML
    private Label lbLogin;

    @FXML
    private TextField txtLogin;

    @FXML
    private Label lbTipo;

    @FXML
    private TextField txtTipo;

    @FXML
    private Label lbStatus;

    @FXML
    private TextField txtStatus;

    @FXML
    private Label lbIp;

    @FXML
    private TextField txtIp;
    
    @FXML
    private Button btVoltar;
    
    @FXML
    private Label lbIdT;

    @FXML
    private Label lbId;

    ControllerGerente usuCont = null;
    
    Gerente ger = null;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
         initComponentes(); 
    }    

    private void initComponentes (){

        usuCont = new ControllerGerente();
        ConsultarGerenteInterface telaAnterior = new ConsultarGerenteInterface();
        setGerente(telaAnterior.getGerente());

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
                    Logger.getLogger(AlterarGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        btSalvar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ger = new Gerente(Integer.parseInt(lbIdT.getText()),
                                  txtLogin.getText(),
                                  txtTipo.getText(),
                                  txtStatus.getText(),
                                  txtIp.getText());

                try {
                    usuCont.alterar(ger);
                } catch (SQLException ex) {
                    Logger.getLogger(AlterarGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AlterarGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                FXMLLoader loader = new FXMLLoader(ProjetoFX.class.getResource("/br/com/fatec/xmls/MenuInterface.fxml"));
                Parent novatela = null;
                try {
                    novatela = loader.load();
                    Stage stg = ProjetoFX.getStage();
                    stg.setScene(new Scene(novatela));
                    stg.show();
                } catch (IOException ex) {
                    Logger.getLogger(AlterarGerenteInterface.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

    }
    
    public void setGerente(Gerente ger) {
        JOptionPane.showMessageDialog(null, ger.getNome());
        this.lbIdT.setText(""+ger.getId());
        this.txtLogin.setText(ger.getNome());
        this.txtTipo.setText(ger.getTipo());
        this.txtStatus.setText(ger.getStatus());
        this.txtIp.setText(ger.getIp());
    }
    
}
    
