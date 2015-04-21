/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;
import static Hl.GUI.GCard.setMyImage;
import javax.swing.JLabel;
import Hl.model.Pokus;
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

public final class GFreeCard extends JPanel{   
    private Pokus game;
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
        this.setSize(40,41);
        this.game=game;
        this.pozice=new Point(200,200);
        this.updatefree=true;
        this.FreeCard=game.maze.getFreeCard();
        game.maze.addObserver(new GSObserver());
        this.setLayout(null);
        
        this.Gfreecard=new GCard(FreeCard);
           // 
        this.add(this.Gfreecard);
        Gfreecard.setLocation(0, 0);
        setLocation(this.pozice);

   
    }
     private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
           
           GFreeCard.this.updatefree=true;
           repaint();
       }
   }
     public MazeCard getFreeCard(){
         return this.FreeCard;
     }
     public void setMyFreeImage(){
         this.FreeCard=game.maze.getFreeCard();
         Gfreecard.setImage(this.FreeCard);
       
         // this.Gfreecard.setImage(FreeCard);
         //   setIcon(icon);
         
     }
     @Override
    public void paintComponent(Graphics g){
       setLocation(this.pozice);
   
        super.paintComponent(g);
        if (this.updatefree=true){
            this.updatefree=false;
            setMyFreeImage();
        }
           
         
    }

    
  
    
}
