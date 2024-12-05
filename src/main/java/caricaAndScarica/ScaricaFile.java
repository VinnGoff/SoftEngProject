/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package caricaAndScarica;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.file;
import java.util.Scanner;
import java.nio.file.*;
/**
 *
 * @author Utente
 * 
 * NON PER LA CONSEGNA, SOLO UNA PROVA INCOMPLETA
 */

public class ScaricaFile{

    Scanner nomeInput= new Scanner(System.in);

    try{
        System.out.println("inserisci nome del file");
        String fileName=nomeInput.nextLine;
        File file=new File(fileName);
    }
    //??ancora da valutare se sovrascrivere il file
    catch(!file.exist()){ 
        throw new FileNotFoundException;
    }
    
    try(BufferedWriter buffw=new BufferedWriter(file.getAbsoluteFile())){
        buffw.write();//manca passaggio scrittura
        buffw.close();
    }
    catch(IOException e){
        e.printStackTrace();
}
}
