/**
 * @file Email.java
 * @brief Rappresenta un indirizzo email
 * @package it.unisa.se.project.datiAndStrutture
 * Gestisce la validazione e formattazione degli indirizzi email
 */
package it.unisa.se.project.datiAndStrutture;

/**
 * @brief classe Email
 */
public class Email {
    /**
     * @private Stringa indirizzo email
     */
    private String indirizzo;

    /**
     * @brief Costruisce un nuovo indirizzo email
     * @param indirizzo L'indirizzo email
     */
    public Email(String indirizzo) {
        this.indirizzo = indirizzo;
    }
    /**
     * @brief toString email
     * @return indirizzo email
     */
    @Override
    public String toString() {
        return indirizzo;
    }
}
