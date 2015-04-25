/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model.board;

import Hl.model.treasure.Treasure;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
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
    public Treasure treasure;
    public int player;
    public String name;
    public List<Treasure> obtainedTreasure=new ArrayList<>();
    public void AddObtainedTreasure(Treasure treasure){
        obtainedTreasure.add(treasure);
         setChanged();
       notifyObservers(treasure);
    }
    public MazeFigur(int x,int y,MazeBoard maze,int player,String name){
       this.x=x;
       this.y=y;
       this.game=maze;
       this.treasure=null;
       this.player=player;
       this.name=name;
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
       notifyObservers(null);
      System.out.print("\n**"+this.x+" "+this.y+"**\n");
      
  }
  public  boolean move(MazeCard.CANGO can){
     
      boolean move;
      move= false;
      System.out.print("stojem van go"+" "+game.get(x, y).getCard().CardCanGo+"\n");
     if (game.get(x, y).getCard().canGo(can)){
       
         if (can==MazeCard.CANGO.UP){
             System.out.print("jduvan go"+" "+game.get(x-1, y).getCard().CardCanGo+"\n");
             if ( x-1>0 && game.get(x-1, y).getCard().canGo(MazeCard.CANGO.DOWN)){
                x+=-1;
                move= true;
             }
         }else
         if (can==MazeCard.CANGO.DOWN){
               System.out.print("jduvan go"+" "+game.get(x+1, y).getCard().CardCanGo+"\n");
               if ( x+1<=game.rozmer && game.get(x+1, y).getCard().canGo(MazeCard.CANGO.UP)){
             x+=1;
             move= true;
               }
         }else
         if (can==MazeCard.CANGO.LEFT){
               System.out.print("jduvan go"+" "+game.get(x, y-1).getCard().CardCanGo+"\n");
               if (y-1>0 && game.get(x, y-1).getCard().canGo(MazeCard.CANGO.RIGHT)){
                y+=-1;
                move= true;
               }
         }else
         if (can==MazeCard.CANGO.RIGHT){
               System.out.print("jduvan go"+" "+game.get(x, y+1).getCard().CardCanGo+"\n");
               if (y+1<=game.rozmer &&game.get(x, y+1).getCard().canGo(MazeCard.CANGO.LEFT)){
             
                y+=1;
                move= true;
               }
         }
     } 
        setChanged();
        
       notifyObservers(null);
      
     return move;
  }
   
}
