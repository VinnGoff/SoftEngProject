/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.rubricagruppo16;

import it.unisa.se.project.datiAndStrutture.Contatto;
import it.unisa.se.project.eccezioni.NonValidoException;

/**
 *
 * @author vgoff
 */
import java.util.ArrayList;

public class Rubrica {
    private ArrayList<Contatto>lista;
   
    public Rubrica(){
        this.lista=new ArrayList<>();
    }
    
    public void inserisciContatto(Contatto x){
        if (x.getNome()=="null" && x.getCognome()=="null") 
            throw new NonValidoException("inserire un nome o cognome");
    }
 
    public Contatto ricerca(String nome){
        
        return null;
        
    }
    
    public modificaContatto(Contatto contatto){
        
    }

    public void eliminaContatto(int index){
       
    }

    public void stampaRubrica(){
      
    }
}
