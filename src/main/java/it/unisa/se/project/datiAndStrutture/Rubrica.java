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
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Rubrica {
    private List<Contatto> rubrica;
    
    /**
     * @brief Aggiunge un nuovo contatto
     * @param contatto Il contatto da aggiungere
     */
    public void aggiungiContatto(Contatto contatto) {
        
    }

    /**
     * @brief Rimuove un contatto
     * @param contatto Il contatto da rimuovere
     */
    public void rimuoviContatto(Contatto contatto) {

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
        return Collections.emptyList();
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
        File myfile =new File(percorso);
        if(myfile.exists()){
            System.out.println("cambia nome file");
        }
        else{
            BufferedWriter buffwriter= new BufferedWriter(new FileWriter(myfile));
            buffwriter.flush();
            buffwriter.close();
        }
        throw new IOException("file non salvato");
    }

    /**
     * @brief Carica la rubrica da file
     * @param percorso Percorso del file
     * @throws IOException in caso di errori di I/O
     */
    public void caricaFile(String percorso) throws IOException {
        File myfile = new File(percorso);
        String nomeFile=percorso.substring(percorso.lastIndexOf("\\")+1,percorso.length());
        if(myfile.isFile()){
            BufferedReader buffread= new BufferedReader(new FileReader(nomeFile));
            while(buffread.ready()){
                System.out.println(buffread.readLine());
            }
            buffread.close();
            
        }else
            System.out.println("file non trovato");
        
        throw new IOException("file non caricato");
        
    }
}
