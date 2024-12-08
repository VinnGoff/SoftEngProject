/**
 * @file Main.java
 * @brief Main class del progetto che lancia l'applicazione con la sua componente grafica
 * 
 */
package it.unisa.se.project.datiAndStrutture;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author vgoff
 */
public class Main extends Application{
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/it/unisa/se/project/views/RubricaView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch();
    }
    