/**
 * @file NonValidoExcpetion.java
 * @brief Eccezione che gestisce l'input non valido da parte dell'utente
 */

package it.unisa.se.project.eccezioni;

/**
 *
 * @author Utente
 */
public class NonValidoException extends RuntimeException{
    /**
     * @brief Eccezione che quando viene catturata genera un messaggio per l'utente
     * 
     * @param msg 
     */
    public NonValidoException(String msg){
        super(msg);
    }
}
