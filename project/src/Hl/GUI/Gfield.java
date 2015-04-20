/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;
import javax.swing.JLabel;
import java.util.Observer;
import java.util.Observable;
import Hl.model.Pokus;
import Hl.model.board.MazeBoard;
import Hl.model.board.MazeCard;
import javax.swing.ImageIcon;
/**
 *
 * @author Pikachu
 */
public class Gfield extends JLabel {
    private Pokus game;
    private int i;
    private int j;
    public MazeCard card;
   
   public Gfield(Pokus game,int i,int j){
        
        this.game=game;
        this.i=i;
        this.j=j;
        this.setMyImage();
        this.card=game.maze.get(i+1, j+1).getCard();
       
        
    }
   public void setMyImage(){
       ImageIcon icon=new ImageIcon("");
        if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.LEFT)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.RIGHT)){
              icon=new ImageIcon("LR.png");
          }
      }
        if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.UP)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.DOWN)){
              icon=new ImageIcon("LR90.png");
          }
      }  
      if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.LEFT)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.UP)){
              icon=new ImageIcon("LU.png");
          }
      }
      if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.RIGHT)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.UP)){
              icon=new ImageIcon("LU90.png");
          }
      }
      if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.RIGHT)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.DOWN)){
              icon=new ImageIcon("LU180.png");
          }
      }
      if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.LEFT)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.DOWN)){
              icon=new ImageIcon("LU270.png");
          }
      }
      if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.UP)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.RIGHT)){
             if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.LEFT)){
              
                icon=new ImageIcon("LUR.png");
             }
                 
             
          }
      }
       if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.UP)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.RIGHT)){
             if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.DOWN)){
              
                icon=new ImageIcon("LUR90.png");
             }
                 
             
          }
      }
        if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.DOWN)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.RIGHT)){
             if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.LEFT)){
              
                icon=new ImageIcon("LUR180.png");
             }
                 
             
          }
      }
      if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.UP)){
          if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.LEFT)){
             if (game.maze.get(i+1, j+1).getCard().canGo(MazeCard.CANGO.DOWN)){
              
                icon=new ImageIcon("LUR270.png");
             }
                 
             
          }
      }
    
      setIcon(icon);
      setIconTextGap(0);
      setBorder(null);
      setText(null);
      setSize(icon.getImage().getWidth(null),icon.getImage().getHeight(null));
   }
  
   
    
}
