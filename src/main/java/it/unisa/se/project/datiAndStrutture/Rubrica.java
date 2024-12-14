/**
 * @file Rubrica.java
 * @brief Gestisce una collezione di contatti
 * 
 * Fornisce operazioni per aggiungere, rimuovere, cercare contatti
 * e salvare/caricare la rubrica da file
 */
package it.unisa.se.project.datiAndStrutture;

/**
 *
 * @author vgoff
 */
import java.io.*;
import java.util.*;

public class Rubrica {
    private List<Contatto> contatti;
    
    /**
     * @brief Costruttore della rubrica
     */
    public Rubrica() {
        this.contatti = new ArrayList<>();
    }
    
    /**
     * @brief Aggiunge un nuovo contatto
     * @param contatto Il contatto da aggiungere
     */
    public void aggiungiContatto(Contatto contatto) {
        if (contatto == null) {
            throw new IllegalArgumentException("Il contatto non può essere null");
        }
        contatti.add(contatto);
        Collections.sort(contatti); // Mantiene la lista ordinata
    }

    /**
     * @brief Rimuove un contatto
     * @param contatto Il contatto da rimuovere
     */
        public void rimuoviContatto(Contatto contatto) {
        contatti.remove(contatto);
    }
       
    /**
     * @brief Cerca contatti per nome o cognome
     * @param ricerca Stringa di ricerca
     * @return Lista dei contatti che soddisfano la ricerca
     */
    public List<Contatto> ricercaContatto(String ricerca) {
        List<Contatto> tempList = new ArrayList<>();
        for (Contatto c : rubrica) {
            if (c.getNome().toLowerCase().contains(ricerca.toLowerCase()) ||
                c.getCognome().toLowerCase().contains(ricerca.toLowerCase())) {
                tempList.add(c);
            }
        }
        return tempList;
    }

    /**
     * @brief Ordina i contatti alfabeticamente
     * @return Lista ordinata dei contatti
     */
    public List<Contatto> ordinaContatti() {
        return Collections.emptyList();//potrebbe non servire più perchè la tableview lo fa in automatico
    }

    /**
     * @brief Salva la rubrica su file
     * @param percorso Percorso del file
     * @throws IOException in caso di errori di I/O
     */
    
    public void salvaFile(String percorso) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(percorso))) {
            for (Contatto c : contatti) {
                // Formato CSV: nome,cognome,tel1,tel2,tel3,email1,email2,email3
                writer.write(String.format("%s,%s,", c.getNome(), c.getCognome()));
                
                // Scrivi numeri di telefono
                List<NumeroTel> numeri = c.getNumeriTel();
                for (int i = 0; i < Contatto.TELEFONI_MAX; i++) {
                    writer.write(i < numeri.size() ? numeri.get(i).toString() : "");
                    writer.write(",");
                }
                
                // Scrivi email
                List<Email> emails = c.getIndirizziEmail();
                for (int i = 0; i < Contatto.EMAIL_MAX; i++) {
                    writer.write(i < emails.size() ? emails.get(i).toString() : "");
                    if (i < Contatto.EMAIL_MAX - 1) writer.write(",");
                }
                writer.newLine();
            }
        }
    }

    /**
     * @brief Carica la rubrica da file
     * @param percorso Percorso del file
     * @throws IOException in caso di errori di I/O
     */
    public void caricaFile(String percorso) throws IOException {
        contatti.clear(); // Pulisce la lista prima di caricare nuovi contatti
        try (BufferedReader reader = new BufferedReader(new FileReader(percorso))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] parts = line.split(",");

                    // Parsing dei campi con gestione dei valori opzionali
                    String nome = parts.length > 0 ? parts[0].trim() : "";
                    String cognome = parts.length > 1 ? parts[1].trim() : "";

                    // Gestione numeri di telefono
                    NumeroTel num1 = (parts.length > 2 && !parts[2].trim().isEmpty()) ? new NumeroTel(parts[2].trim()) : null;
                    NumeroTel num2 = (parts.length > 3 && !parts[3].trim().isEmpty()) ? new NumeroTel(parts[3].trim()) : null;
                    NumeroTel num3 = (parts.length > 4 && !parts[4].trim().isEmpty()) ? new NumeroTel(parts[4].trim()) : null;

                    // Gestione email
                    Email mail1 = (parts.length > 5 && !parts[5].trim().isEmpty()) ? new Email(parts[5].trim()) : null;
                    Email mail2 = (parts.length > 6 && !parts[6].trim().isEmpty()) ? new Email(parts[6].trim()) : null;
                    Email mail3 = (parts.length > 7 && !parts[7].trim().isEmpty()) ? new Email(parts[7].trim()) : null;

                    // Se non ci sono numeri e email, li imposteremo come oggetti vuoti
                    // per il costruttore che richiede comunque tre numeri e tre email
                    if (num1 == null) num1 = new NumeroTel(""); // Placeholder vuoto
                    if (num2 == null) num2 = new NumeroTel(""); // Placeholder vuoto
                    if (num3 == null) num3 = new NumeroTel(""); // Placeholder vuoto

                    if (mail1 == null) mail1 = new Email(""); // Placeholder vuoto
                    if (mail2 == null) mail2 = new Email(""); // Placeholder vuoto
                    if (mail3 == null) mail3 = new Email(""); // Placeholder vuoto

                    // Crea il contatto solo se almeno nome o cognome sono valorizzati
                    if (!nome.isEmpty() || !cognome.isEmpty() || num1 != null || mail1 != null) {
                        Contatto nuovoContatto = new Contatto(nome, cognome, num1, num2, num3, mail1, mail2, mail3);
                        contatti.add(nuovoContatto);
                    } else {
                        System.err.println("Contatto ignorato: tutti i campi sono vuoti.");
                    }

                } catch (Exception e) {
                    System.err.println("Errore durante il parsing della riga: " + line);
                    System.err.println("Dettaglio: " + e.getMessage());
                }
            }
        }
        Collections.sort(contatti); // Mantiene la lista ordinata
    }
    
    /**
     * @brief Metodo che consente di avere tutti i contatti che ci sono in rubrica
     * @return ArrayList della rubrica 
     */
    public List<Contatto> getContatti() {
        return new ArrayList<>(contatti);
    }
}
