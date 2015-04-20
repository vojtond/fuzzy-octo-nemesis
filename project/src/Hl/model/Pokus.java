/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model;
import Hl.model.board.*;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Pikachu
 */
public final class Pokus implements Serializable {
    public int height;
    public int width;
    public MazeBoard maze;

     public int pocethrac;
     public int HracNaTahu;
      public List<MazeFigur> figura=new ArrayList<>();
      public MazeFigur figur;
      public static Pokus PPokus;
      public static Pokus NewPokus(){
          PPokus=new Pokus();
          return PPokus;
      }
    private Pokus(){
        maze=MazeBoard.createMazeBoard(11);
        maze.newGame();
        this.HracNaTahu=0;
        figura.add(new MazeFigur(1,1,maze));
        figura.add(new MazeFigur(1,maze.rozmer,maze));
        figura.add(new MazeFigur(maze.rozmer,1,maze));
        figura.add(new MazeFigur(maze.rozmer,maze.rozmer,maze));
        pocethrac=4;
        this.figur=figura.get(this.HracNaTahu);
        maze.figura=figura;
       // System.out.print("***"+maze.get(2, 2).getCard().CardCanGo);
        height=800;
        width=800;
    }
    public void changePlayer(){
        if (HracNaTahu<pocethrac-1){
            HracNaTahu++;
        }else HracNaTahu=0;
        this.figur=figura.get(this.HracNaTahu);
        System.out.print(figur.y);
    }
  
        
    
}
