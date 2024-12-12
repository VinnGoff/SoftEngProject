/**
 * @file RubricaController.java
 * @brief Controller principale dell'applicazione
 * 
 * Gestisce l'interazione tra il modello, Rubrica, e la vista, RubricaView
 */
package it.unisa.se.project.controllers;

import it.unisa.se.project.datiAndStrutture.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 *
 * @author firy
 */
 
public class RubricaController implements Initializable{
    
    @FXML
    private Button saveBtn;
    @FXML
    private Button EliminaBtnContatto;
    @FXML
    private Button ModificaBtnContatto;
    @FXML
    private TextField nameField;
    @FXML
    private TextField surnameField;
    @FXML
    private TextField num1Field;
    @FXML
    private TextField num2Field;
    @FXML
    private TextField num3Field;
    @FXML
    private TextField mail1Field;
    @FXML
    private TextField mail2Field;
    @FXML
    private TextField mail3Field;
    @FXML
    private TextField searchField;
    @FXML
    private Button cercaBtnRubrica;
    @FXML
    private Button aprirubricaBtnRubrica;
    @FXML
    private Button caricamentoBtnRubrica;
    @FXML
    private Button salvataggioBtnRubrica;
    @FXML
    private Button annullaBtn;
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
        
        contattoTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }   
    
    /**
     * @param e
     * @brief Gestisce l'aggiunta di un nuovo contatto
     */
    @FXML
    public void handleAggiungiContatto(ActionEvent e) {
        contacts.add(new Contatto(nameField.getText(), surnameField.getText(), new NumeroTel(num1Field.getText()), new NumeroTel(num2Field.getText()), new NumeroTel(num3Field.getText()), new Email(mail1Field.getText()), new Email(mail2Field.getText()), new Email(mail3Field.getText()))); 
    }

    /**
     * @param e
     * @brief Gestisce la modifica di un contatto
     */
    @FXML
    public void handleModificaContatto(ActionEvent e) {
       Contatto c=contattoTable.getSelectionModel().getSelectedItem();
       //s.setName(event.getNewValue());
       
       
    }

    /**
     * @param e
     * @brief Gestisce l'eliminazione di un contatto
     */
    @FXML
    public void handleRimuoviContatto(ActionEvent e) {
        Contatto selected=contattoTable.getSelectionModel().getSelectedItem();
        contacts.remove(selected);
    }

    /**
     * @param e
     * @brief Gestisce la ricerca dei contatti
     */
    @FXML
    public void handleRicerca(ActionEvent e) {
        //ricercaContatto(searchField.getText());
    }

    /**
     * @param e
     * @brief Gestisce il salvataggio della rubrica
     */
    @FXML
    public void handleSalvataggio(ActionEvent e) {
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Export Contacts");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File selectedFile = fileChooser.showSaveDialog(null);

        if (selectedFile != null) {
            rubric.(selectedFile.getAbsolutePath());
            System.out.println("Contacts exported successfully.");
        }
        */
    }

    /**
     * @param e
     * @brief Gestisce il caricamento della rubrica
     */
    @FXML
    public void handleCaricamento(ActionEvent e) {
        /*
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        File file = fileChooser.showOpenDialog(null);

        if (file != null) {
            Rubrica importedRubric = rubric.importContacts(file.getAbsolutePath());
            
            if (importedRubric != null) {
                rubric.getContacts().addAll(importedRubric.getContacts());
                contattoTable.refresh();
            } 
        }
        */
    }
}
