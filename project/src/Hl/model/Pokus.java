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
import java.util.Random;
/**
 *
 * @author Pikachu
 */
public final class Pokus implements Serializable {
    public int height;
    public int width;
    public MazeBoard maze;
    public int faze;
public CardPack pack;
     public int pocethrac;
     public int HracNaTahu;
      public List<MazeFigur> figura=new ArrayList<>();
      public MazeFigur figur;
      public static Pokus PPokus;
      public static Pokus NewPokus(int pocethrac,int rozmer){
          PPokus=new Pokus(pocethrac,rozmer);
          return PPokus;
      }
    private Pokus(int pocethrac,int rozmer){
         Treasure.createSet();
        maze=MazeBoard.createMazeBoard(rozmer);
        maze.newGame();
        this.HracNaTahu=-1;
        switch (pocethrac){
            case 1: 
                this.pocethrac=1;
                figura.add(new MazeFigur(1,1,maze));
            break;
            case 2:
                this.pocethrac=2;
                figura.add(new MazeFigur(1,1,maze));
                figura.add(new MazeFigur(1,maze.rozmer,maze));
            break;
            case 3:
                this.pocethrac=3;
                figura.add(new MazeFigur(1,1,maze));
                figura.add(new MazeFigur(1,maze.rozmer,maze));
                figura.add(new MazeFigur(maze.rozmer,1,maze));
            break;
            case 4:
                  this.pocethrac=4;
                figura.add(new MazeFigur(1,1,maze));
                figura.add(new MazeFigur(1,maze.rozmer,maze));
                figura.add(new MazeFigur(maze.rozmer,1,maze));
                figura.add(new MazeFigur(maze.rozmer,maze.rozmer,maze));
        pocethrac=4;
        }
        pack=new CardPack(24,24);
        pack.shuffle();
        changePlayer();
        this.figur=figura.get(this.HracNaTahu);
        maze.figura=figura;
       
       // System.out.print("***"+maze.get(2, 2).getCard().CardCanGo);
        height=800;
        width=800;
       
        Random random=new Random();
        int x=0;
        int y=0;
       
        for (int i=0;i<24;i++){
          
            boolean obsazeno=true;
            
           while (obsazeno){
               
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
            System.out.print("hledam"+figur.treasure.code+"\n");
    }
  
        
    
}
