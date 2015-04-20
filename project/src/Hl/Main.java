package Hl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;

import Hl.model.Pokus;
import Hl.GUI.GameAppFrame;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 *
 * @author Pikachu
 */
public class Main  {
   static Pokus tohle;
    Pokus game;
    private GameAppFrame AppFrame;
    public Main(){
        
         game =new Pokus();
         Main.tohle=game;
            AppFrame=new GameAppFrame(game);
       
    }
    public static void main(String[] args) {
   
       javax.swing.SwingUtilities.invokeLater(new Runnable(){
           @Override
           public void run(){
               createAndShowGUI();
           }
       });
       
      
      
      
    }
    private static void createAndShowGUI(){
        System.out.print("2");
       JFrame.setDefaultLookAndFeelDecorated(true);
       
       new Main();
    }
    
  
}
