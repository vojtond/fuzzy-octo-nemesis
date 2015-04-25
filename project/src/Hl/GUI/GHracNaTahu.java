/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;

import Hl.model.Pokus;
import Hl.model.board.MazeField;
import Hl.model.board.MazeFigur;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Pikachu
 */
public class GHracNaTahu extends JLabel{
    public   ImageIcon icon;
    public GHracNaTahu(Pokus game){
       this.setLocation(game.getWidth()-100, 10);
        this.setSize(100, 70);
             icon=new ImageIcon("figur"+game.figur.player+".png");
               this.setIcon(icon); 
        this.setText(game.figur.name);
       
        game.addObserver(new GHracNaTahu.GSObserver());
    }
    public void changeturn(MazeFigur figur){
      icon=new ImageIcon("figur"+figur.player+".png");
        this.setIcon(icon); 
        this.setText(figur.name);
    }
    private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
           
          MazeFigur argu=(MazeFigur)arg;
          GHracNaTahu.this.changeturn(argu);
          // System.out.print("tady\n"+argu.row()+argu.col());
         
           //
       }
   }
}
