/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;
import static Hl.GUI.GCard.setMyImage;
import javax.swing.JLabel;
import Hl.model.Pokus;
import Hl.model.board.MazeBoard;
import Hl.model.board.MazeCard;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Point;

import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 *
 * @author Pikachu
 */

public final class GFreeCard {   
 private GSObserver obs;
    public  Point pozice;
    public  MazeCard FreeCard;
    public GCard Gfreecard;
    private boolean updatefree;
    private static GFreeCard GGfreeCard;
    public ImageIcon icon;
    public static GFreeCard newGFreeCard(Pokus game){
        GFreeCard.GGfreeCard=new GFreeCard( game);
        return GGfreeCard;
    
    }
    private GFreeCard(Pokus game){
       // this.setSize(60,61);
        this.pozice=new Point(game.CardSize,0);
        this.updatefree=true;
        this.FreeCard=game.getBoard().getFreeCard();
        obs=new GSObserver();
        game.getBoard().addObserver(obs);
        game.getBoard().getFreeCard().addObserver(obs);
       // this.setLayout(null);
        
        this.Gfreecard=new GCard(null,FreeCard,0,0);
           // 
        //this.add(this.Gfreecard);
        Gfreecard.setLocation(this.pozice);
      //  setLocation(this.pozice);

   
    }
     private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
           
           MazeCard maze=(MazeCard)arg;
            GFreeCard.this.FreeCard.deleteObserver(obs);
           GFreeCard.this.FreeCard=maze;
           GFreeCard.this.FreeCard.addObserver(obs);
            setMyFreeImage();
           
       
         
       }
   }
     public MazeCard getFreeCard(){
         return this.FreeCard;
     }
     public void setMyFreeImage(){
        // this.FreeCard=game.maze.getFreeCard();
         Gfreecard.setImage(this.FreeCard);
 
         // this.Gfreecard.setImage(FreeCard);
         //   setIcon(icon);
         
     }
     public void setLocation(Point p){
         this.pozice=p;
         this.Gfreecard.setLocation(pozice);
     }
   
    
  
    
}
