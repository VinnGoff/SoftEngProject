/**
 * @file Email.java
 * @brief Rappresenta un indirizzo email
 * 
 * Gestisce la validazione e formattazione degli indirizzi email
 */
package it.unisa.se.project.datiAndStrutture;

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

    @Override
    public String toString() {
        return indirizzo;
    }
}
