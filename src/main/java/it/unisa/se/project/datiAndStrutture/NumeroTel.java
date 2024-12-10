/**
 * @file NumeroTel.java
 * @brief Rappresenta un numero di telefono
 * 
 * Gestisce la validazione e formattazione dei numeri di telefono
 */
package it.unisa.se.project.datiAndStrutture;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class NumeroTel {
    private String numero;

    /**
     * @brief Costruisce un nuovo numero di telefono
     * @param numero Il numero in formato stringa
     * @throws IllegalArgumentException se il numero non è valido
     */
    public NumeroTel(String numero) {
        this.numero = numero;
    }

    /**
     * @brief Valida il formato del numero
     * @return true se il formato è valido
     */
    public boolean valido() {
        if (numero == null || numero.isEmpty())
            return false;
            
        
        String phoneRegex = "^\\+?[0-9]{1,3}[0-9\\s\\-()]{8,15}$";  //secondo questa regex, il numero di telefono non è valido se è composto da più di 15 cifre e meno di 8, inoltre il prefisso 
                                                                    //è facoltativo e comprende il + iniziale
        Pattern pattern = Pattern.compile(phoneRegex);
        Matcher matcher = pattern.matcher(numero);
        
        return matcher.matches();
    }

    @Override
    public String toString() {
        return numero;
    }
}
