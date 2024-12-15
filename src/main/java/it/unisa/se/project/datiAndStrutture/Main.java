/**
 * @file Main.java
 * @brief Main class del progetto che lancia l'applicazione con la sua componente grafica
 * @package it.unisa.se.project.datiAndStrutture
 */
package it.unisa.se.project.datiAndStrutture;
/**
 * @name imports of main
 */
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
* @}
*/
/**
 *
 * @author vgoff
 * @brief classe Main
 * @extends Application
 */
public class Main extends Application{
    /**
     * @name start
     * @{
     * @brief load resource as parent root + set scene
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/it/unisa/se/project/views/RubricaView.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
    /**
     * @}
     */    
    /**
     * @name main()
     * @{
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       launch();
    }
    /**
     * @}
     */    
}
