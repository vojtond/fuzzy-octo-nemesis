/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model.board;

/**
 *
 * @author Pikachu
 */
import Hl.model.treasure.Treasure;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observable;
public class MazeCard extends Observable implements Serializable {
    public ArrayList<CANGO> CardCanGo=new ArrayList<CANGO>();
     public Treasure poklad;
    public static enum CANGO{
        LEFT,UP,RIGHT,DOWN;
    }
    public static MazeCard create (String type){
        MazeCard nova=new MazeCard(type);
              
        return nova;
        
    }
    private MazeCard(String type){
        this.poklad=null;
       
        switch (type) {
            case "C":
                this.CardCanGo.add(CANGO.LEFT); 
                this.CardCanGo.add(CANGO.UP); 
                
            break;
            case "L":
                this.CardCanGo.add(CANGO.LEFT);  
               this.CardCanGo.add(CANGO.RIGHT);  
               
            break;
            case "F":
                  this.CardCanGo.add(CANGO.LEFT); 
                  this.CardCanGo.add(CANGO.UP); 
                  this.CardCanGo.add(CANGO.RIGHT);
            break;
            default:
                throw new IllegalArgumentException("blop");
        }
    }
    public boolean canGo(MazeCard.CANGO dir){
        return CardCanGo.contains(dir);
    }
    public void turnRight(){
         
      ArrayList<CANGO> PomCardCanGo=new ArrayList<CANGO>();
      if (  CardCanGo.contains(CANGO.UP)){
          CardCanGo.remove(CANGO.UP);
          PomCardCanGo.add(CANGO.RIGHT);
      }
      if (  CardCanGo.contains(CANGO.RIGHT)){
          CardCanGo.remove(CANGO.RIGHT);
          PomCardCanGo.add(CANGO.DOWN);
      }
          if (  CardCanGo.contains(CANGO.DOWN)){
          CardCanGo.remove(CANGO.DOWN);
          PomCardCanGo.add(CANGO.LEFT);
      }
      if (  CardCanGo.contains(CANGO.LEFT)){
          CardCanGo.remove(CANGO.LEFT);
          PomCardCanGo.add(CANGO.UP);
      }
      CardCanGo=PomCardCanGo;
      setChanged();
       notifyObservers(this);
    }
      public void putTreasure(Treasure poklad){
        this.poklad=poklad;
    }
    public Treasure getTreasure(){
        return this.poklad;
    }
   
}
