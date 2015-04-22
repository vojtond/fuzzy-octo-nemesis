/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;

import javax.swing.JLabel;

import Hl.model.Pokus;
import Hl.model.board.MazeBoard;

import Hl.model.board.MazeCard;
import Hl.model.board.MazeField;
import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;

/**
 *
 * @author Pikachu
 */
public class GCard extends JLayeredPane implements Serializable{
 
   
    private MazeCard card;
    private ImageIcon icon;
    private JLabel obr;
    private JLabel treasure;
        private Dimension dim; 
    public GCard(Pokus game,MazeCard card,int i,int j){
          double ratio,rH,rW;
        int gH,gW;
         int height=40;
        int width=40;
        rH=(double)40/40;
        rW=(double)40/40;
        ratio=rH>1 ? 1:rH;
        ratio=rW>1 ? ratio : ( rW > rH ? rH : rW);
        gH=(int)(height*ratio);
        gW=(int)(width*ratio);
        dim=new Dimension (gH,gW);

        this.setPreferredSize(dim);
        this.setSize(dim);
        this.setOpaque(true);
        this.setLayout(null);

        this.card=card;
        if (i>0 && j>0){
            System.out.print(i+" "+j+"tu\n");
        game.maze.get(i, j).addObserver(new GCard.GSObserver());
        
        }
        this.icon=setMyImage(this.card);
        this.treasure=new JLabel();
      this.setLayout(null);
      if (card.poklad!=null){

      
        this.treasure.setText(""+card.poklad.code);
        this.treasure.setSize(20, 20);
        
         
      }
  this.add(treasure,2,0);
    
      
       this.obr=new JLabel();
   
      obr.setIcon(icon);
      obr.setIconTextGap(0);
      obr.setSize(40,40);
      this.add(obr,1,0);
 
      
    }
   public  void setImage(MazeCard card){
       if (card.poklad!=null){
         this.treasure.setText(""+card.poklad.code);
         this.treasure.setSize(20, 20);
       }else  this.treasure.setText("");
       this.card=card;
       this.icon=GCard.setMyImage(card);
       this.obr.setIcon(icon); 
   }
   public static ImageIcon setMyImage(MazeCard card){
      
       ImageIcon icon=new ImageIcon("");
      
        if (card.canGo(MazeCard.CANGO.LEFT)){
          if (card.canGo(MazeCard.CANGO.RIGHT)){
              icon=new ImageIcon("LR.png");
          }
      }
        if (card.canGo(MazeCard.CANGO.UP)){
          if (card.canGo(MazeCard.CANGO.DOWN)){
              icon=new ImageIcon("LR90.png");
          }
      }  
      if (card.canGo(MazeCard.CANGO.LEFT)){
          if (card.canGo(MazeCard.CANGO.UP)){
              icon=new ImageIcon("LU.png");
          }
      }
      if (card.canGo(MazeCard.CANGO.RIGHT)){
          if (card.canGo(MazeCard.CANGO.UP)){
              icon=new ImageIcon("LU90.png");
          }
      }
      if (card.canGo(MazeCard.CANGO.RIGHT)){
          if (card.canGo(MazeCard.CANGO.DOWN)){
              icon=new ImageIcon("LU180.png");
          }
      }
      if (card.canGo(MazeCard.CANGO.LEFT)){
          if (card.canGo(MazeCard.CANGO.DOWN)){
              icon=new ImageIcon("LU270.png");
          }
      }
      if (card.canGo(MazeCard.CANGO.UP)){
          if (card.canGo(MazeCard.CANGO.RIGHT)){
             if (card.canGo(MazeCard.CANGO.LEFT)){
              
                icon=new ImageIcon("LUR.png");
             }
                 
             
          }
      }
       if (card.canGo(MazeCard.CANGO.UP)){
          if (card.canGo(MazeCard.CANGO.RIGHT)){
             if (card.canGo(MazeCard.CANGO.DOWN)){
              
                icon=new ImageIcon("LUR90.png");
             }
                 
             
          }
      }
        if (card.canGo(MazeCard.CANGO.DOWN)){
          if (card.canGo(MazeCard.CANGO.RIGHT)){
             if (card.canGo(MazeCard.CANGO.LEFT)){
              
                icon=new ImageIcon("LUR180.png");
             }
                 
             
          }
      }
      if (card.canGo(MazeCard.CANGO.UP)){
          if (card.canGo(MazeCard.CANGO.LEFT)){
             if (card.canGo(MazeCard.CANGO.DOWN)){
              
                icon=new ImageIcon("LUR270.png");
             }
                 
             
          }
      }
      return icon;
     
  
              }
  
    private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
           MazeField argu=(MazeField)arg;
           System.out.print("tady\n"+argu.row()+argu.col());
           GCard.this.setImage(argu.getCard());

           //repaint();
       }
   }
    
}
