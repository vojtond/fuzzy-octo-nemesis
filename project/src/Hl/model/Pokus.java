/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model;
import Hl.model.board.*;
import Hl.model.treasure.CardPack;
import Hl.model.treasure.Treasure;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Random;
/**
 *
 * @author Pikachu
 */
public final class Pokus extends Observable implements Serializable {
    private int height;
    private int width;
    private MazeBoard maze;
    private int faze;
    public int CardSize;
public void setFaze(int faze){
    this.faze=faze;
}
public int getFaze(){
    return this.faze;
}
public int getHeight(){
    return this.height;
}
public int getWidth(){
    return this.width;
}
public MazeBoard getBoard(){
    return this.maze;
}
public CardPack pack;
      
     public int pocethrac;
     public int HracNaTahu;
      public List<MazeFigur> figura=new ArrayList<>();
      public MazeFigur figur;
      public static Pokus PPokus;
      public static Pokus NewPokus(int pocethrac,int rozmer,List<String> figuraname){
          
          PPokus=new Pokus(pocethrac,rozmer,figuraname);
          return PPokus;
      }
    private Pokus(int pocethrac,int rozmer,List<String> figuraname){
        this.CardSize=60;
         Treasure.createSet();
        maze=MazeBoard.createMazeBoard(rozmer);
        figura.clear();
        maze.newGame();
        this.HracNaTahu=-1;
          
        System.out.print("pred\n");
        switch (pocethrac){
            case 1: 
                this.pocethrac=1;
                figura.add(new MazeFigur(1,1,maze,0,figuraname.get(0)));
            break;
            case 2:
                this.pocethrac=2;
                figura.add(new MazeFigur(1,1,maze,0,figuraname.get(0)));
                System.out.print(""+figuraname.get(0)+"\n");
                figura.add(new MazeFigur(1,maze.rozmer,maze,1,figuraname.get(1)));
                System.out.print(""+figuraname.get(1)+"\n");
            break;
            case 3:
                this.pocethrac=3;
                figura.add(new MazeFigur(1,1,maze,0,figuraname.get(0)));
                figura.add(new MazeFigur(1,maze.rozmer,maze,1,figuraname.get(1)));
                figura.add(new MazeFigur(maze.rozmer,1,maze,2,figuraname.get(2)));
                
            break;
            case 4:
                  this.pocethrac=4;
                figura.add(new MazeFigur(1,1,maze,0,figuraname.get(0)));
                figura.add(new MazeFigur(1,maze.rozmer,maze,1,figuraname.get(1)));
                figura.add(new MazeFigur(maze.rozmer,1,maze,2,figuraname.get(2)));
                figura.add(new MazeFigur(maze.rozmer,maze.rozmer,maze,3,figuraname.get(3)));
           
            break;
     
        }
    
                height=this.CardSize*maze.rozmer*2;
                width=this.CardSize*maze.rozmer*2;
          
        System.out.print("ya\n");
        pack=new CardPack(24,24);
        pack.shuffle();
        changePlayer();
        this.figur=figura.get(this.HracNaTahu);
        maze.figura=figura;
       
       // System.out.print("***"+maze.get(2, 2).getCard().CardCanGo);
       
       
        Random random=new Random();
        int x=0;
        int y=0;
       
        for (int i=0;i<24;i++){
          
            boolean obsazeno=true;
            
           while (obsazeno){
               System.out.print(maze.rozmer+" "+x+y+"**\n");
                x=random.nextInt(maze.rozmer)+1;
                y=random.nextInt(maze.rozmer)+1;
               
                if (maze.get(x, y).getCard().poklad==null){
                    obsazeno=false;
                }
           }
           maze.get(x, y).getCard().poklad=Treasure.getTreasure(i);
           
        }
    }
    public void changePlayer(){
        
        if (HracNaTahu<pocethrac-1){
            HracNaTahu++;
        }else HracNaTahu=0;
        faze=0;
        this.figur=figura.get(this.HracNaTahu);
        
          if (figur.treasure==null){
                        figur.treasure=pack.popCard().TreasureOnCard;
                      
          }
          System.out.print("tah"+HracNaTahu);
            setChanged();
            notifyObservers(this.figur.treasure);
            System.out.print("hledam"+figur.treasure.code+"\n");
            
    }
  
        
    
}
