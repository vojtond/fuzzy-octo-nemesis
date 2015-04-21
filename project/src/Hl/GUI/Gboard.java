/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;
import Hl.model.Pokus;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import Hl.GUI.GCard;
import Hl.model.board.MazeBoard;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Pikachu
 */
public  final class Gboard extends JPanel{
    private GCard[][] label;
    private Dimension dimB; 
  
    public MazeBoard maze;
    private JLabel figur;
    public  boolean updateimage;
    private static Gboard GGboard;
    public static Gboard newGboard(Pokus game){
        
        GGboard=new Gboard(game);
      
        return GGboard;
    }
   private Gboard(Pokus game){
       
    
        this.maze=game.maze;
        this.updateimage=true;     
        label=new GCard[game.maze.rozmer][game.maze.rozmer];
        GridLayout lay =new GridLayout(game.maze.rozmer,game.maze.rozmer);
        this.setLayout(lay);
        dimB=new Dimension (game.maze.rozmer*40,40*game.maze.rozmer);
        this.setPreferredSize(dimB);
        this.setSize(dimB);
        this.setBackground(Color.LIGHT_GRAY);
        for(int i=0;i<game.maze.rozmer;i++){
            for(int j=0;j<game.maze.rozmer;j++){   
                label[i][j]=new GCard(game.maze.get(i+1, j+1).getCard());  
                this.add(label[i][j]);
                 
            }
        }
      
               
        this.setOpaque(true);
        game.maze.addObserver(new GSObserver());
       repaint();
    }
    @Override
    public void paintComponent(Graphics g){

         //  System.out.print("*na carte**"+GameAppFrame.game.maze.get(2, 2).getCard().CardCanGo+"\n");      
        super.paintComponent(g);
        if (updateimage){
             
            this.updateimage=false;
         
        for(int i=0;i<maze.rozmer;i++){
            for(int j=0;j<maze.rozmer;j++){
                
                label[i][j].setImage(maze.get(i+1, j+1).getCard());
             
            }
         }
        }

    }
    public MazeBoard getBoard(){
        return this.maze;
    }
    public  GCard getField(int i,int j){
        return label[i][j];
    }
     private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
         
           Gboard.this.updateimage=true;

           //repaint();
       }
   }
     
  
    
}
