/**
 * @file Email.java
 * @brief Rappresenta un indirizzo email
 * 
 * Gestisce la validazione e formattazione degli indirizzi email
 */
package it.unisa.se.project.datiAndStrutture;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Email {
    private String indirizzo;

    /**
     * @brief Costruisce un nuovo indirizzo email
     * @param indirizzo L'indirizzo email
     * @throws IllegalArgumentException se l'indirizzo non è valido
     */
    public Email(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    /**
     * @brief Valida il formato dell'indirizzo
     * @return true se il formato è valido
     */
    public boolean valido() {
        if(indirizzo==null || indirizzo.isEmpty())
            return false;
        
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";    //Questa regex fa si che la mail non sia valida se non presenta -@- , -.- e il TLD finale da almeno 2 caratteri
        
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(indirizzo);
        
        return matcher.matches();
    }

    @Override
    public String toString() {
        return indirizzo;
    }
}
