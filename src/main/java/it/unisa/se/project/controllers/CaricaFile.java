/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package it.unisa.se.project.controllers;

/**
 *
 * @author Utente
 */
public class CaricaFile{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        BufferedReader reader= new BufferedReader(new InputStreamReader(Paths.get("manca il path del file")));
        String line;
        if((line=reader.readLine)!== null){
            System.out.println(line);
        }
        // TODO code application logic here
    }}
