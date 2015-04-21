package Hl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;

import Hl.model.Pokus;
import Hl.GUI.GameAppFrame;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
 *
 * @author Pikachu
 */
public class Main  {
  
    Pokus game;
    private GameAppFrame AppFrame;
    public static void serializaceDataOut(GameSave ish) throws FileNotFoundException, IOException{
        
        String fileName="Test.txt";
        FileOutputStream fos=new FileOutputStream(fileName);
       
        ObjectOutputStream oos=new ObjectOutputStream(fos);

        oos.writeObject(ish);
        
        oos.close();
        System.out.print("done\n");
                
        
    }
    public static GameSave serializeDataIn() throws FileNotFoundException, IOException, ClassNotFoundException{
        String fileName= "Test.txt";
        FileInputStream fin = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(fin);
        GameSave s= (GameSave) ois.readObject();
        ois.close();
        return s;
}
    public Main() throws IOException, FileNotFoundException, ClassNotFoundException{
        
            game =Pokus.NewPokus(4,5);
         
            AppFrame=new GameAppFrame(game);
          
         
       
    }
    public static void main(String[] args) {
   
       javax.swing.SwingUtilities.invokeLater(new Runnable(){
           @Override
           public void run(){
            
               try {
                   createAndShowGUI();
               } catch (IOException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
       });
       
      
      
      
    }
    private static void createAndShowGUI() throws IOException, FileNotFoundException, ClassNotFoundException{
        System.out.print("2");
       JFrame.setDefaultLookAndFeelDecorated(true);
       
       new Main();
    }
    
  
}
