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
import Hl.GUI.Gfield;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Pikachu
 */
public  final class Gboard extends JPanel{
    public Gfield[][] label;
    private Dimension dimB; 
    private Pokus game;
    private JLabel figur;
    private  boolean updateimage;
    public static Gboard GGboard;
    public static Gboard newGboard(Pokus game){
        
        GGboard=new Gboard(game);
      
        return GGboard;
    }
   private Gboard(Pokus game){
       
        this.game=game;
        this.updateimage=true; 
         
        label=new Gfield[game.maze.rozmer][game.maze.rozmer];
        GridLayout lay =new GridLayout(game.maze.rozmer,game.maze.rozmer);
        this.setLayout(lay);
        dimB=new Dimension (game.maze.rozmer*40,40*game.maze.rozmer);
        this.setPreferredSize(dimB);
        this.setSize(dimB);
        this.setBackground(Color.LIGHT_GRAY);
        //System.out.print("\n---"+this.game.maze.get(2, 2).getCard().CardCanGo+"\n");
        for(int i=0;i<game.maze.rozmer;i++){
            for(int j=0;j<game.maze.rozmer;j++){   
                label[i][j]=new Gfield(game, i, j);  
                this.add(label[i][j]);
                 
            }
        }
      
               
        this.setOpaque(true);
        this.game.maze.addObserver(new GSObserver());
       repaint();
    }
    @Override
    public void paintComponent(Graphics g){

         //  System.out.print("*na carte**"+GameAppFrame.game.maze.get(2, 2).getCard().CardCanGo+"\n");      
        super.paintComponent(g);
        if (updateimage){
             
            this.updateimage=false;
         
         for(int i=0;i<game.maze.rozmer;i++){
            for(int j=0;j<game.maze.rozmer;j++){
             
               label[i][j].setMyImage(this.game.maze.get(i+1, j+1).getCard());
            }
         }
        }

    }
     private class GSObserver implements Observer{
       
       @Override 
       public void update(Observable o,Object arg){
           System.out.print("\n*updategg*\n");
           Gboard.this.updateimage=true;

           //repaint();
       }
   }
     
  
    
}
