/**
 * @file NumeroTel.java
 * @brief Rappresenta un numero di telefono
 * 
 * Gestisce la validazione e formattazione dei numeri di telefono
 */
package it.unisa.se.project.datiAndStrutture;

public class NumeroTel {
    private String numero;

    /**
     * @brief Costruisce un nuovo numero di telefono
     * @param numero Il numero in formato stringa
     */
    public NumeroTel(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return numero;
    }
}
