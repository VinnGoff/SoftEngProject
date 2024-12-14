/**
 * @file RubricaController.java
 * @brief Controller principale dell'applicazione
 * @package it.unisa.se.project.controllers
 * Gestisce l'interazione tra il modello, Rubrica, e la vista, RubricaView
 */
package it.unisa.se.project.controllers;

import it.unisa.se.project.datiAndStrutture.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

/**
 *
 * @author firy
 * @brief class RubricaController con gli handle degli eventi
 * @implements Initializable per gestire controller
 * @section
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
    /**
     * @private contacts come lista osservabile della collezione
     * @private rubrica come nuova rubrica
     */
    
    private final ObservableList<Contatto> contacts = FXCollections.observableArrayList();
    private final Rubrica rubrica = new Rubrica();    
    
    /**
     * @brief Override del metodo initialize di Initializable
     * @param url
     * @param rb 
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setupTableColumns();
        setupTableSelection();
        contattoTable.setItems(contacts);
    }
    /**
     * @subsection
     * @brief setupTableColumns per collegare gli inserimeri field a tabella
     */           
    private void setupTableColumns() {
        nameClm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
        surnameClm.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCognome()));
        
        num1Clm.setCellValueFactory(cellData -> {
            List<NumeroTel> numeri = cellData.getValue().getNumeriTel();
            return new SimpleStringProperty(!numeri.isEmpty() ? numeri.get(0).toString() : "");
        });
        
        num2Clm.setCellValueFactory(cellData -> {
            List<NumeroTel> numeri = cellData.getValue().getNumeriTel();
            return new SimpleStringProperty(numeri.size() > 1 ? numeri.get(1).toString() : "");
        });
        
        num3Clm.setCellValueFactory(cellData -> {
            List<NumeroTel> numeri = cellData.getValue().getNumeriTel();
            return new SimpleStringProperty(numeri.size() > 2 ? numeri.get(2).toString() : "");
        });
        
        mail1Clm.setCellValueFactory(cellData -> {
            List<Email> emails = cellData.getValue().getIndirizziEmail();
            return new SimpleStringProperty(!emails.isEmpty() ? emails.get(0).toString() : "");
        });
        
        mail2Clm.setCellValueFactory(cellData -> {
            List<Email> emails = cellData.getValue().getIndirizziEmail();
            return new SimpleStringProperty(emails.size() > 1 ? emails.get(1).toString() : "");
        });
        
        mail3Clm.setCellValueFactory(cellData -> {
            List<Email> emails = cellData.getValue().getIndirizziEmail();
            return new SimpleStringProperty(emails.size() > 2 ? emails.get(2).toString() : "");
        });
    }
    
     /**
     * @subsection
     * @brief setupTableSelection permette di selezionare singola riga di contatto
     */           
    private void setupTableSelection() {
        contattoTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        contattoTable.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                popolaCampiContatto(newSelection);
            }
        });
    }
    
    /**
     * @brief Gestisce l'aggiunta di un nuovo contatto
     * @return void
     */
    @FXML
    public void handleAggiungiContatto() {
        if (!validateInputs()) {
            mostraErrore("Errore", "Nome o cognome non possono essere vuoti");
            return;
        }
        
        try {
            Contatto nuovoContatto = new Contatto(
                nameField.getText().trim(),
                surnameField.getText().trim(),
                new NumeroTel(num1Field.getText().trim()),
                new NumeroTel(num2Field.getText().trim()),
                new NumeroTel(num3Field.getText().trim()),
                new Email(mail1Field.getText().trim()),
                new Email(mail2Field.getText().trim()),
                new Email(mail3Field.getText().trim())
            );
            
            rubrica.aggiungiContatto(nuovoContatto);
            aggiornaTabella();
            svuotaCampi();
            
        } catch (IllegalArgumentException e) {
            mostraErrore("Errore", "Formato non valido per numero di telefono o email");
        }
    }

    /**
     * @brief Gestisce la modifica di un contatto
     */
    @FXML
    public void handleModificaContatto() {
        Contatto selected = contattoTable.getSelectionModel().getSelectedItem();
        if (selected != null && validateInputs()) {
            rubrica.rimuoviContatto(selected);
            handleAggiungiContatto();
        }
    }

    /**
     * @brief Gestisce l'eliminazione di un contatto
     */
    @FXML
    public void handleRimuoviContatto() {
        final Contatto selected = contattoTable.getSelectionModel().getSelectedItem();
        if (selected != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Conferma eliminazione");
            alert.setContentText("Sei sicuro di voler eliminare questo contatto?");
            
            alert.showAndWait().ifPresent(response -> {
                if (response == ButtonType.OK) {
                    rubrica.rimuoviContatto(selected);
                    aggiornaTabella();
                    svuotaCampi();
                }
            });
        }
    }

    /**
     * @brief Gestisce la ricerca dei contatti
     */
    @FXML
    public void handleRicerca() {
        String query = searchField.getText();
        contacts.setAll(rubrica.cercaContatto(query));
    }
    
    /**
     * @brief Gestisce il salvataggio della rubrica
     */
    @FXML
    public void handleSalvataggio() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Salva Rubrica");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        
        File file = fileChooser.showSaveDialog(contattoTable.getScene().getWindow());
        if (file != null) {
            try {
                rubrica.salvaFile(file.getAbsolutePath());
                mostraInfo("Successo", "Rubrica salvata correttamente");
            } catch (IOException e) {
                mostraErrore("Errore", "Errore durante il salvataggio del file: " + e.getMessage());
                Logger.getLogger(RubricaController.class.getName())
                      .log(Level.SEVERE, "Errore salvataggio file", e);
            }
        }
    }

    /**
     * @brief Gestisce il caricamento della rubrica
     */
    @FXML
    public void handleCaricamento() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Carica Rubrica");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
        
        File file = fileChooser.showOpenDialog(contattoTable.getScene().getWindow());
        if (file != null) {
            try {
                rubrica.caricaFile(file.getAbsolutePath());
                aggiornaTabella();
                mostraInfo("Successo", "Rubrica caricata correttamente");
            } catch (IOException e) {
                mostraErrore("Errore", "Errore durante il caricamento del file: " + e.getMessage());
                Logger.getLogger(RubricaController.class.getName())
                      .log(Level.SEVERE, "Errore caricamento file", e);
            }
        }
    }
    /**
     * @subsection
     * @brief aggiornaTabella
     * @post contacts settato con i dati del contatto
     */            
    private void aggiornaTabella() {
        contacts.setAll(rubrica.getContatti());
    }
    /**
     * @subsection
     * @brief validateInputs
     * @return nameField o surnameField non vuoti restituisce true
     */           
    private boolean validateInputs() {
        return !nameField.getText().trim().isEmpty() || 
               !surnameField.getText().trim().isEmpty();
    }
    /**
     * @subsection
     * @brief svuotaCampi per ogni field di testo del contatto
     * @post field di contatto vuoti
     */            
    private void svuotaCampi() {
        nameField.clear();
        surnameField.clear();
        num1Field.clear();
        num2Field.clear();
        num3Field.clear();
        mail1Field.clear();
        mail2Field.clear();
        mail3Field.clear();
    }
    /**
     * @subsection
     * @brief popolaCampiContatto per settare i field a valore o nulli
     * @param c contatto 
     */            
    private void popolaCampiContatto(Contatto c) {
        nameField.setText(c.getNome());
        surnameField.setText(c.getCognome());
        
        List<NumeroTel> numeri = c.getNumeriTel();
        num1Field.setText(!numeri.isEmpty() ? numeri.get(0).toString() : "");
        num2Field.setText(numeri.size() > 1 ? numeri.get(1).toString() : "");
        num3Field.setText(numeri.size() > 2 ? numeri.get(2).toString() : "");
        
        List<Email> emails = c.getIndirizziEmail();
        mail1Field.setText(!emails.isEmpty() ? emails.get(0).toString() : "");
        mail2Field.setText(emails.size() > 1 ? emails.get(1).toString() : "");
        mail3Field.setText(emails.size() > 2 ? emails.get(2).toString() : "");
    }
    /**
     * @subsection
     * @brief mostraErrore per caso di alert
     * @param title stringa
     * @param message stringa
     */        
    private void mostraErrore(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    /**
     * @subsection
     * @brief mostraInfo per messaggio alert
     * @param title stringa
     * @param message stringa
     */    
    private void mostraInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
