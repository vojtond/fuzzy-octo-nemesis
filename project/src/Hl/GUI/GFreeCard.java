/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;
import javax.swing.JLabel;
import Hl.model.Pokus;
import Hl.model.board.MazeCard;
import java.awt.Graphics;
import java.awt.Point;

import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;


/**
 *
 * @author Pikachu
 */

public final class GFreeCard extends JLabel{   
    private Pokus game;
    public  Point pozice;
    private boolean updatefree;
    private static GFreeCard GGfreeCard;
    public static GFreeCard newGFreeCard(Pokus game){
        GFreeCard.GGfreeCard=new GFreeCard( game);
        return GGfreeCard;
    
    }
    private GFreeCard(Pokus game){
        this.game=game;
        this.pozice=new Point(200,200);
        this.updatefree=true;
        this.setMyImage();     
        
        this.game.maze.addObserver(new GSObserver());
    }
 
    public void setMyImage(){
        ImageIcon icon=new ImageIcon();
        if (game.maze.getFreeCard().canGo(MazeCard.CANGO.LEFT)){
            if (game.maze.getFreeCard().canGo(MazeCard.CANGO.RIGHT)){
                icon=new ImageIcon("LR.png");
            }
        }
        if (game.maze.getFreeCard().canGo(MazeCard.CANGO.UP)){
            if (game.maze.getFreeCard().canGo(MazeCard.CANGO.DOWN)){
                icon=new ImageIcon("LR90.png");
            }
        }
        if (game.maze.getFreeCard().canGo(MazeCard.CANGO.LEFT)){
            if (game.maze.getFreeCard().canGo(MazeCard.CANGO.UP)){
                icon=new ImageIcon("LU.png");
            }
        }
        if (game.maze.getFreeCard().canGo(MazeCard.CANGO.RIGHT)){
            if (game.maze.getFreeCard().canGo(MazeCard.CANGO.UP)){
                icon=new ImageIcon("LU90.png");
            }
        }
        if (game.maze.getFreeCard().canGo(MazeCard.CANGO.RIGHT)){
            if (game.maze.getFreeCard().canGo(MazeCard.CANGO.DOWN)){
                icon=new ImageIcon("LU180.png");
            }
        }
        if (game.maze.getFreeCard().canGo(MazeCard.CANGO.LEFT)){
            if (game.maze.getFreeCard().canGo(MazeCard.CANGO.DOWN)){
                icon=new ImageIcon("LU270.png");
            }
      }
      if (game.maze.getFreeCard().canGo(MazeCard.CANGO.UP)){
          if (game.maze.getFreeCard().canGo(MazeCard.CANGO.RIGHT)){
             if (game.maze.getFreeCard().canGo(MazeCard.CANGO.LEFT)){
              
                icon=new ImageIcon("LUR.png");
             }
                 
             
          }
      }
       if (game.maze.getFreeCard().canGo(MazeCard.CANGO.UP)){
          if (game.maze.getFreeCard().canGo(MazeCard.CANGO.RIGHT)){
             if (game.maze.getFreeCard().canGo(MazeCard.CANGO.DOWN)){
              
                icon=new ImageIcon("LUR90.png");
             }
                 
             
          }
      }
        if (game.maze.getFreeCard().canGo(MazeCard.CANGO.DOWN)){
          if (game.maze.getFreeCard().canGo(MazeCard.CANGO.RIGHT)){
             if (game.maze.getFreeCard().canGo(MazeCard.CANGO.LEFT)){
              
                icon=new ImageIcon("LUR180.png");
             }
                 
             
          }
      }
         if (game.maze.getFreeCard().canGo(MazeCard.CANGO.UP)){
          if (game.maze.getFreeCard().canGo(MazeCard.CANGO.LEFT)){
             if (game.maze.getFreeCard().canGo(MazeCard.CANGO.DOWN)){
              
                icon=new ImageIcon("LUR270.png");
             }
                 
             
          }
      }
      setLocation(this.pozice);
       setIcon(icon);
      setIconTextGap(0);
      setBorder(null);
      setText(null);
      setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null));
      
   
    }
     private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
           GFreeCard.this.updatefree=true;
           repaint();
       }
   }
     @Override
    public void paintComponent(Graphics g){
       setLocation(this.pozice);
   
        super.paintComponent(g);
        if (this.updatefree=true){
            this.updatefree=false;
            setMyImage();
        }
           
         
    }

    
  
    
}
