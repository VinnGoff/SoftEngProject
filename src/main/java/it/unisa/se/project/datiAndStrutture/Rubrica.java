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
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.util.Iterator;

public class Rubrica {
    private ArrayList<Contatto> rubrica;
    
    /**
     * @brief Costruttore della rubrica
     */
    public Rubrica() {
        rubrica = new ArrayList<>();
    }
    
    /**
     * @brief Aggiunge un nuovo contatto
     * @param contatto Il contatto da aggiungere
     */
    public void aggiungiContatto(Contatto contatto) {
        rubrica.add(contatto);
    }

    /**
     * @brief Rimuove un contatto
     * @param contatto Il contatto da rimuovere
     */
    public void rimuoviContatto(Contatto contatto) {
        if (!rubrica.isEmpty()) {
            rubrica.remove(contatto);
        }
    }
    
    /**
     * @brief Modifica un contatto
     * @param contatto Il contatto da modificare
     */
    public void modificaContatto(Contatto contatto) {
        
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
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(percorso)))){
            final String SEPARATORE = ","; // Separatore tra i campi
            pw.println("Cognome,Nome,Numero1,Numero2,Numero3,E-mail1,E-mail2,E-mail3");
            for (Contatto contatto : rubrica) {
                // Nome
                pw.append(contatto.getNome());
                pw.append(SEPARATORE);
                
                // Cognome
                pw.append(contatto.getCognome());
                pw.append(SEPARATORE);
                
                // Numeri di telefono
                for (NumeroTel numeroTel : contatto.getNumeriTel()) {
                    pw.append(numeroTel.toString());
                    pw.append(SEPARATORE);
                }

                // Indirizzi email
                Iterator<Email> emailIterator = contatto.getIndirizziEmail().iterator();
                while (emailIterator.hasNext()) {
                    Email email = emailIterator.next();
                    pw.append(email.toString());
                    if (emailIterator.hasNext()) {
                        pw.append(SEPARATORE);
                    }
                }
                pw.append("\n");
            }
        } catch (IOException ex) {
            System.err.println("Errore durante la scrittura del file: " + ex.getMessage());
        }
    }

    /**
     * @brief Carica la rubrica da file
     * @param percorso Percorso del file
     * @throws IOException in caso di errori di I/O
     */
    public void caricaFile(String percorso) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(percorso))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    // Salta la riga di intestazione
                    firstLine = false;
                    continue;
                }

                String[] fields = line.split(",");
                if (fields.length < 7) {
                    throw new IOException("Formato file CSV non valido");
                }

                String cognome = fields[0];
                String nome = fields[1];
                List<NumeroTel> numeriTel = new ArrayList<>();
                List<Email> indirizziEmail = new ArrayList<>();

                // Leggi i numeri di telefono
                for (int i = 2; i < 5; i++) {
                    if (!fields[i].isEmpty()) {
                        numeriTel.add(new NumeroTel(fields[i]));
                    }
                }

                // Leggi gli indirizzi email
                for (int i = 5; i < fields.length; i++) {
                    if (!fields[i].isEmpty()) {
                        indirizziEmail.add(new Email(fields[i]));
                    }
                }

                Contatto contatto = new Contatto(nome, cognome, numeriTel.get(0), numeriTel.get(1), numeriTel.get(2), indirizziEmail.get(0), indirizziEmail.get(1), indirizziEmail.get(2));
                rubrica.add(contatto);
            }
        } catch (IOException ex) {
            System.err.println("Errore durante la lettura del file: " + ex.getMessage());
            throw ex;
        }
    }
}
