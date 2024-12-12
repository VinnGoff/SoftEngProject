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
        return Collections.emptyList();
    }

    /**
     * @brief Salva la rubrica su file
     * @param percorso Percorso del file
     * @throws IOException in caso di errori di I/O
     */
    public void salvaFile(String percorso) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(percorso)))){
            pw.println("Nome,Cognome,Numeri di telefono,Indirizzi e-mail");
            for (Contatto contatto : rubrica) {
                pw.append(contatto.getNome());
                pw.append(",");
                pw.append(contatto.getCognome());
                pw.append(",");
                // Converti l'ArrayList di numeri in stringa
                String numeriTel = contatto.getNumeriTel().toString();
                // Rimuovi le parentesi quadre dall'output dell'ArrayList
                numeriTel = numeriTel.substring(1, numeriTel.length() - 1);
                pw.append(numeriTel);
                pw.append(",");
                
                // Converti l'ArrayList di email in stringa
                String email = contatto.getIndirizziEmail().toString();
                // Rimuovi le parentesi quadre dall'output dell'ArrayList
                email = email.substring(1, email.length() - 1);
                pw.append(email);
                pw.append("\n");
            }
        } catch (IOException ex) {
            
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
