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
public class InserirGerenteInterface implements Initializable {

    /**
     * Initializes the controller class.
     */
    
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

    ControllerGerente gerCont = null;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initComponentes();
    }    
    
    private void initComponentes () {
        btSalvar.setOnAction((ActionEvent event) -> {
            gerCont = new ControllerGerente();
            Gerente ger = new Gerente(txtLogin.getText(),txtTipo.getText(),txtStatus.getText(),txtIp.getText());
            try {
                ger = (Gerente) gerCont.inserir(ger);
            } catch (SQLException | ClassNotFoundException ex) {
                Logger.getLogger(LoginInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, ger.getNome());
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

    
}
