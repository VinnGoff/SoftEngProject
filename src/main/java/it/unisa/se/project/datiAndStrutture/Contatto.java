/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.unisa.se.project.datiAndStrutture;

import java.util.Arrays;

/**
 *
 * @author vgoff
 */
public class Contatto {
    private String nome;
    private String cognome;
    private int numeriTel[];
    private String indirizziEmail[];
    
    public Contatto(String nome, String cognome, int numeriTel[], String indirizziEmail[]){
        this.nome = nome;
        this.cognome = cognome;
        this.numeriTel = numeriTel;
        this.indirizziEmail = indirizziEmail;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public int[] getNumeriTel() {
        return numeriTel;
    }
    
    public String[] getIndirizziEmail() {
        return indirizziEmail;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public void setNumeriTel(int numeriTel[]) {
        this.numeriTel = numeriTel;
    }
    
    public void setIndirizziEmail(String indirizziEmail[]) {
        this.indirizziEmail = indirizziEmail;
    }
    
    
    @Override
    public String toString() {
        return ("Nome: " + nome + "\nCognome: " + cognome + "\nNumeri di telefono: " + Arrays.toString(numeriTel) + "\nIndirizzi e-mail: " + Arrays.toString(indirizziEmail));
    }
}
