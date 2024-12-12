/**
 * @file RubricaController.java
 * @brief Controller principale dell'applicazione
 * 
 * Gestisce l'interazione tra il modello, Rubrica, e la vista, RubricaView
 */
package it.unisa.se.project.controllers;

import it.unisa.se.project.datiAndStrutture.Contatto;
import it.unisa.se.project.datiAndStrutture.Email;
import it.unisa.se.project.datiAndStrutture.NumeroTel;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author firy
 */
 
public class RubricaController implements Initializable{
    
    @FXML
    private MenuItem salvaButton;
    @FXML
    private TextField nomeField;
    @FXML
    private TextField cognomeField;
    @FXML
    private TextField numeriTelField;
    @FXML
    private Button rimuoviButton;
    @FXML
    private TableView<Contatto> contattoTable;
    @FXML
    private TableColumn<Contatto, String> nameClm;
    @FXML
    private TableColumn<Contatto, String> surnameClm;
    @FXML
    private TableColumn<Contatto, String> num1Clm;
    @FXML
    private TableColumn<Contatto, String> num2Clm;
    @FXML
    private TableColumn<Contatto, String> num3Clm;
    @FXML
    private TableColumn<Contatto, String> mail1Clm;
    @FXML
    private TableColumn<Contatto, String> mail2Clm;
    @FXML
    private TableColumn<Contatto, String> mail3Clm;
    
    ObservableList <Contatto> contacts;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        contacts=FXCollections.observableArrayList();
        contattoTable.setItems(contacts);
        
        surnameClm.setCellValueFactory(c -> {return new SimpleStringProperty(c.getValue().getCognome());});
        nameClm.setCellValueFactory(new PropertyValueFactory("name"));
        num1Clm.setCellValueFactory(new PropertyValueFactory("num1"));
        num2Clm.setCellValueFactory(new PropertyValueFactory("num2"));
        num3Clm.setCellValueFactory(new PropertyValueFactory("num3"));
        mail1Clm.setCellValueFactory(new PropertyValueFactory("mail1"));
        mail2Clm.setCellValueFactory(new PropertyValueFactory("mail2"));
        mail3Clm.setCellValueFactory(new PropertyValueFactory("mail3"));
    }   
    
    /**
     * @brief Gestisce l'aggiunta di un nuovo contatto
     */
    @FXML
    public void handleAggiungiContatto() {
        //students.add(new Student(nameField.getText(),surnameField.getText(), codeField.getText())); esempio aggiunta studente in esercizio di oop
        
    
    }

    /**
     * @brief Gestisce la modifica di un contatto
     */
    @FXML
    public void handleModificaContatto() {

    }

    /**
     * @brief Gestisce l'eliminazione di un contatto
     */
    @FXML
    public void handleRimuoviContatto() {

    }

    /**
     * @brief Gestisce la ricerca dei contatti
     */
    @FXML
    public void handleRicerca() {

    }

    /**
     * @brief Gestisce il salvataggio della rubrica
     */
    @FXML
    public void handleSalvataggio() {

    }

    /**
     * @brief Gestisce il caricamento della rubrica
     */
    @FXML
    public void handleCaricamento() {

    }
}
