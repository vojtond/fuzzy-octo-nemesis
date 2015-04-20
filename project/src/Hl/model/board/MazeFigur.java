/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model.board;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.Observable;
import javax.swing.JPanel;

/**
 *
 * @author Pikachu
 */
public class MazeFigur  extends Observable implements Serializable{
    public int x;
    public int y;
    private MazeBoard game;
    public MazeFigur(int x,int y,MazeBoard maze){
       this.x=x;
       this.y=y;
       this.game=maze;
       
       
   
    }
  public void changeShift(int x,int y){
      this.x=this.x+x;
      this.y=this.y+y;
      if (this.x<1 || this.x>game.rozmer){
          if (this.x<1){
            this.x=game.rozmer;
          }else this.x=1;
      }
      if (this.y<1 || this.y>game.rozmer){
          if (this.y<1){
            this.y=game.rozmer;
          }else this.y=1;
      }
         setChanged();
       notifyObservers();
      System.out.print("\n**"+this.x+" "+this.y+"**\n");
      
  }
  public void move(MazeCard.CANGO can){
      System.out.print("asdasd\n");
     if (game.get(x, y).getCard().canGo(can)){
          System.out.print("asdasd\n");
         if (can==MazeCard.CANGO.UP){
             
             if ( x-1>0 && game.get(x-1, y).getCard().canGo(MazeCard.CANGO.DOWN)){
                x+=-1;
             }
         }else
         if (can==MazeCard.CANGO.DOWN){
               if ( x+1<=game.rozmer && game.get(x+1, y).getCard().canGo(MazeCard.CANGO.UP)){
             x+=1;
               }
         }else
         if (can==MazeCard.CANGO.LEFT){
               if (y-1>0 && game.get(x, y-1).getCard().canGo(MazeCard.CANGO.RIGHT)){
                y+=-1;
               }
         }else
         if (can==MazeCard.CANGO.RIGHT){
               if (y+1<=game.rozmer &&game.get(x, y+1).getCard().canGo(MazeCard.CANGO.LEFT)){
             
                y+=1;
               }
         }
     }
        setChanged();
       notifyObservers();
     System.out.print("\n**"+x+" "+y+"**\n");
  }
   
}
