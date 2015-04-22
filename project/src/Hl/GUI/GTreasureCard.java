/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;

import Hl.model.Pokus;
import Hl.model.board.MazeField;
import Hl.model.treasure.Treasure;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Marek
 */
public class GTreasureCard extends JPanel{
    public JLabel GTreasure;
    public GTreasureCard(Pokus game){
        GTreasure=new JLabel();
        this.add(GTreasure,BorderLayout.CENTER);
        GTreasure.setText(""+game.figur.treasure.code);
        game.addObserver(new GTreasureCard.GSObserver());
        
        
    
    
    }
     private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
           Treasure argu=(Treasure)arg;
           GTreasureCard.this.GTreasure.setText(""+argu.code);
           
          

           //repaint();
       }
   }
            
    
}
