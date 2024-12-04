/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package it.unisa.se.project.eccezioni;

/**
 *
 * @author Utente
 */
public class NonValidoException extends RuntimeException{
    public NonValidoException(String msg){
        super(msg);
    }
}
