/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model.board;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Observable;


/**
 *
 * @author Pikachu
 */
public class MazeBoard extends Observable implements Serializable{
  private MazeField[][] Maze; 
  public int rozmer;
  private  MazeCard volna;
  static MazeBoard maze;
 public List<MazeFigur> figura=new ArrayList<>();
  public static MazeBoard createMazeBoard(int n){
      MazeBoard Maze=new MazeBoard(n);
      maze=Maze;
      return Maze;
  }
  private MazeBoard(int n){
      Maze=new MazeField[n+1][n+1];
      rozmer=n;
      
      for (int i=1;i<=n;i++){
          for (int j=1;j<=n;j++){
              Maze[i][j]=new MazeField(i,j);
          }
      
      }
  }
  public void newGame(){
      Random random=new Random();
      Random rrotate=new Random();
       switch (random.nextInt(3)){
                  case 0:
                      volna=MazeCard.create("C");
                  break;
                  case 1:
                      volna=MazeCard.create("L");
                  break;
                  case 2:
                      volna=MazeCard.create("F");
                  break;
              }
       rotate(volna,rrotate.nextInt(3));
      for (int i=1;i<=rozmer;i++){
          for (int j=1;j<=rozmer;j++){
            if ((i==1 && j==1) || (i==1 && j==rozmer) || (i==rozmer && j==1) || (i==rozmer && j==rozmer)){
                  Maze[i][j].putCard(MazeCard.create("C"));
                  if(i==1 && j==1){
                      rotate(Maze[i][j].getCard(),2);
         
                  }else
                  if(i==1 && j==rozmer){
                      rotate(Maze[i][j].getCard(),3);
                     
                  }else
                  if(i==rozmer && j==1){
                      rotate(Maze[i][j].getCard(),1);
                        
                  }
              }else
              if(i %2==1 && j%2==1){
                Maze[i][j].putCard(MazeCard.create("F"));
                if(i==1){
                    rotate(Maze[i][j].getCard(),2);
                }else
                if(j==1){
                    rotate(Maze[i][j].getCard(),1);
                }else
                if(j==rozmer){
                    rotate(Maze[i][j].getCard(),3); 
                }
              }else{
              switch (random.nextInt(3)){
                  case 0:
                      Maze[i][j].putCard(MazeCard.create("C"));
                  break;
                  case 1:
                      Maze[i][j].putCard(MazeCard.create("L"));
                  break;
                  case 2:
                      Maze[i][j].putCard(MazeCard.create("F"));
                  break;
              }
               rotate(Maze[i][j].getCard(),rrotate.nextInt(3)); 
               
              }
          }
      
      }
     
  }
  public MazeField get(int r,int c){
      if (r<=rozmer && c<=rozmer){
          return Maze[r][c];
      }else return null;
      
  }
  private static  void rotate(MazeCard m,int i){
      for (int j=0;j<i;j++){
          m.turnRight();
      }
  }
  public MazeCard getFreeCard(){
          return volna;    
  }
  public void shift (MazeField mf){
    

     
      MazeCard pom=volna;
      if (mf.row()==1 &&( mf.col()%2==0)){
          pom=Maze[rozmer][mf.col()].getCard();
          for (MazeFigur item : figura) {
            if (item.y==mf.col()){
                item.changeShift(1, 0);
            }
          }
          for (int i=rozmer-1;i>0;i--){
              Maze[i+1][mf.col()].putCard(Maze[i][mf.col()].getCard());
          }
          Maze[1][mf.col()].putCard(volna);
          volna=pom;
      }else 
      if (mf.row()==rozmer &&( mf.col()%2==0)){ 
         
           for (MazeFigur item : figura) {
            if (item.y==mf.col()){
                item.changeShift(-1, 0);
            }
          }
          pom=Maze[1][mf.col()].getCard();         
          for (int i=1;i<rozmer;i++){
              Maze[i][mf.col()].putCard(Maze[i+1][mf.col()].getCard());
          }
          Maze[rozmer][mf.col()].putCard(volna);
          volna=pom;
      }else
      if (mf.col()==1 &&( mf.row()%2==0)){
          pom=Maze[mf.row()][rozmer].getCard();  
       
           for (MazeFigur item : figura) {
            if (item.x==mf.row()){
                item.changeShift(0, 1);
            }
          }
          for (int i=rozmer-1;i>0;i--){
              Maze[mf.row()][i+1].putCard(Maze[mf.row()][i].getCard());
          }
          Maze[mf.row()][1].putCard(volna);
          volna=pom;
      }else
       if (mf.col()==rozmer &&( mf.row()%2==0)){
     
          for (MazeFigur item : figura) {
            if (item.x==mf.row()){
                item.changeShift(0, -1);
            }
          }
          pom=Maze[mf.row()][1].getCard();         
          for (int i=1;i<rozmer;i++){
              Maze[mf.row()][i].putCard(Maze[mf.row()][i+1].getCard());
          }
          Maze[mf.row()][rozmer].putCard(volna);
          volna=pom;
        
       }
      
           setChanged();
       notifyObservers(this.volna);
  }
}