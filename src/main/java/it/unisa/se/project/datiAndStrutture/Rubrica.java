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
//import java.io.BufferedReader;
import java.io.IOException;
//import java.scanner.Scanner;
import java.util.Collections;
import java.util.List;
//import java.io.File;
//import java.io.FileReader;
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
            pw.println("Nome,Cognome,Numero 1,Numero 2, Numero 3,Email 1, Email 2, Email 3");
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
    /*public void caricaFile(String percorso) throws IOException {
        
        try{
            File myfile = new File(percorso);
            String nomeFile=percorso.substring(percorso.lastIndexOf("\\")+1,percorso.length());
            BufferedReader buffread= new BufferedReader(new FileReader(nomeFile));
            PrintWriter fileOutput= new PrintWriter(buffread);
        }
        catch(IOException e){
            System.out.println("Errore");
        }
        finally{
            buffread.close();
        }
        
    }*/
}
