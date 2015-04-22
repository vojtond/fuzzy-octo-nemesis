/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;
import Hl.GUI.Gboard;

import Hl.model.Pokus;
import Hl.model.board.MazeCard;
import Hl.model.board.MazeFigur;

import java.awt.Color;
import javax.swing.BorderFactory;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;
/**
 *
 * @author Pikachu
 */
public  class GPokus extends JLayeredPane {
    
    private Gboard Gdeska;
    private  GFreeCard Gfree;
    private boolean isSetClick; 
    private boolean isFocus;
    private Point Freepoc;
    private final int maxHeight=1500;
    private final int maxWidth=1500;
    private GMazeFigur Gfigur; 
    private Rectangle2D.Double rectout;
    private List<GMazeFigur> Gfigura=new ArrayList<>();
    private Rectangle2D.Double[][] rect2;
    private Dimension dim; 
    private Pokus game; 
    private static GPokus GGPokus;
    public GTreasureCard Gtreasurecard;
    
    public static GPokus newGPokus(Pokus game){
         System.out.print("***"+game.getBoard().get(2, 2).getCard().CardCanGo);
         
        GPokus.GGPokus=new GPokus(game);
       
        return GGPokus;
        
    }
    private GPokus(Pokus game){
        double ratio,rH,rW;
        int gH,gW;
       this.game=game;
        int height=game.getHeight();
        int width=game.getWidth();
        rH=(double)maxHeight/height;
        rW=(double)maxWidth/width;
        ratio=rH>1 ? 1:rH;
        ratio=rW>1 ? ratio : ( rW > rH ? rH : rW);
        gH=(int)(height*ratio);
        gW=(int)(width*ratio);
        dim=new Dimension (gH,gW);
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.setPreferredSize(dim);
        this.setSize(dim);
        this.setBackground(Color.white);
        this.setOpaque(true);
        this.isSetClick=false;  
        this.setLayout(null);
        this.setFocusable(true);
        this.requestFocusInWindow();
        
        this.Gdeska=Gboard.newGboard(game);
        this.Gfree=GFreeCard.newGFreeCard(game);
        this.Gfree.setOpaque(true);
        this.add(Gdeska,1,0);
        this.add(Gfree,2,0);
        this.isFocus=false;
        this.Freepoc=new Point();  
        this.Gdeska.setLocation(this.getHeight()/2-(this.Gdeska.getHeight()/2),this.getWidth()/2-(this.Gdeska.getWidth()/2));
        this.Freepoc.setLocation(Gdeska.getX()-70, Gdeska.getY()-70);
        this.Gfree.pozice=this.Freepoc;
        this.Gtreasurecard=new GTreasureCard(game);
        this.add(Gtreasurecard,1,0);
        height=60;
        width=60;
        rH=(double)60/height;
        rW=(double)60/width;
        ratio=rH>1 ? 1:rH;
        ratio=rW>1 ? ratio : ( rW > rH ? rH : rW);
        gH=(int)(height*ratio);
        gW=(int)(width*ratio);
        dim=new Dimension (gH,gW);
        this.Gtreasurecard.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        this.Gtreasurecard.setPreferredSize(dim);
        this.Gtreasurecard.setSize(dim);
        this.Gtreasurecard.setBackground(Color.BLACK);
        this.Gtreasurecard.setLocation(0,0);
        
        this.rectout=new Rectangle2D.Double();
        rect2=new Rectangle2D.Double[game.getBoard().rozmer][game.getBoard().rozmer];
        for(int i=0;i<game.getBoard().rozmer;i++){
            for(int j=0;j<game.getBoard().rozmer;j++){
               rect2[i][j]=new Rectangle2D.Double();        
            }
        }
  
        this.addKeyListener(new figurKeyEvent());
        MListener ml=new MListener();
        this.addMouseListener(ml);
        this.addMouseMotionListener(ml);

        for (MazeFigur item : game.figura) {     
            Gfigur=new GMazeFigur(game, item);
            this.add(Gfigur,3,0);
            Gfigura.add(Gfigur);
          } 
        repaint();
   }
  
  
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (!isSetClick){
            this.setClick();
            isSetClick=true;
        }
       
        for (GMazeFigur item : Gfigura) {
            item.setLocation(Gdeska.getField(item.figur.x-1, item.figur.y-1).getX()+Gdeska.getX()+10,Gdeska.getField(item.figur.x-1, item.figur.y-1).getY()+Gdeska.getY()+10);
        }
        Graphics2D g2=(Graphics2D) g;
        Color oldC=g2.getColor();
        rectout.setRect(Gdeska.getX()-80, Gdeska.getY()-80,Gdeska.getHeight()+160, Gdeska.getWidth()+160);
        g2.setColor(Color.BLACK);
        g2.draw(rectout);
   
              
         
    }

    
    public void setClick(){
        for(int i=0;i<Gdeska.getBoard().rozmer;i++){
            for(int j=0;j<Gdeska.getBoard().rozmer;j++){
                this.rect2[i][j].setRect(Gdeska.getField(i, j).getX()+Gdeska.getX(),Gdeska.getY()+Gdeska.getField(i, j).getY(),60,60);
            }
        }    
    }
    private class MListener extends MouseAdapter{
        @Override
        public void mousePressed(MouseEvent e){
            
           if (Gfree.contains(e.getX()-Gfree.getX(), e.getY()-Gfree.getY())&& game.getFaze()==0){
               if (e.getButton()==MouseEvent.BUTTON3){
                   Gdeska.getBoard().getFreeCard().turnRight();
                   repaint();
                   isFocus=false;
               }else
              isFocus=true;
           }else isFocus=false;
        }
        @Override
        public void mouseReleased(MouseEvent e){            
            if (isFocus && game.getFaze()==0){
                if (e.getButton()==MouseEvent.BUTTON1){
                    
                    Point p;
                    Gfree.pozice=e.getPoint();
                    Gfree.pozice.setLocation(e.getX()+30, e.getY()+30);
                    p=e.getPoint();
                    if (game.getFaze()==0){
                    for (int i=1;i<=Gdeska.getBoard().rozmer;i=i+Gdeska.getBoard().rozmer-1){
                        for (int j=2;j<Gdeska.getBoard().rozmer;j=j+2){                   
                            if (rect2[i-1][j-1].contains(Gfree.pozice)){
                               
                               game.setFaze(1);
                                Gdeska.getBoard().shift(Gdeska.getBoard().get(i, j));
                                if(i==1){
                                    p.setLocation(rect2[Gdeska.getBoard().rozmer-1][j-1].getX(), rect2[Gdeska.getBoard().rozmer-1][j-1].getY()+60);
                                }else
                                if(i==Gdeska.getBoard().rozmer){
                                    p.setLocation(rect2[0][j-1].getX(), rect2[0][j-1].getY()-60);
                                }
                               
                            }
                            if (rect2[j-1][i-1].contains(Gfree.pozice)){
                                game.setFaze(1);
                                Gdeska.getBoard().shift(Gdeska.getBoard().get(j, i));
                                if(i==1){
                                    p.setLocation(rect2[j-1][Gdeska.getBoard().rozmer-1].getX()+60, rect2[j-1][Gdeska.getBoard().rozmer-1].getY());
                                }else
                                if(i==Gdeska.getBoard().rozmer){
                                        p.setLocation(rect2[j-1][0].getX()-60, rect2[j-1][0].getY());
                                }
                                
                            }
                          
                        }
                    }
                    Gfree.pozice=p;
                    }else {Gfree.pozice=Freepoc;repaint();}
                    
                }
            }
        }
         @Override
        public void mouseDragged(MouseEvent e){
            if(isFocus && game.getFaze()==0){ 
                if (rectout.contains(Gfree.pozice)){
                  Gfree.pozice=e.getPoint();
                  repaint();
                }else{
                    e.consume();
                    isFocus=false;
                    Gfree.pozice=Freepoc;
                    repaint();
                }
            }
          
        }
    
   
    }
     private class figurKeyEvent extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
             
            switch (e.getKeyCode()){
                case 10:                   
                    game.changePlayer();
                    MazeCard carda=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                    if (game.figur.treasure.equals(carda.poklad)){
                            carda.putTreasure(null);
                            game.figur.treasure=null;
                            GPokus.this.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(carda);
                             game.changePlayer();
                       }
                    
                break;
                case 37:
                     
                    if (game.figur.move(MazeCard.CANGO.LEFT)){
                       game.setFaze(2);
                       
                       MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                       if (game.figur.treasure.equals(card.poklad)){
                            card.putTreasure(null);
                            game.figur.treasure=null;
                            GPokus.this.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                             game.changePlayer();
                       }
                    }
                  
                break;
                case 38:
                     
                    if (game.figur.move(MazeCard.CANGO.UP)){
                        game.setFaze(2);
                         MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                        if (game.figur.treasure.equals(card.poklad)){
                            game.getBoard().get(game.figur.x,game.figur.y).getCard().putTreasure(null);
                            game.figur.treasure=null;
                           GPokus.this.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                            game.changePlayer();
                        }
                        }
                
                break;
                case 39:
                    
                    if (game.figur.move(MazeCard.CANGO.RIGHT)){
                        game.setFaze(2);
                         MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                        if (game.figur.treasure.equals(card.poklad)){
                            game.getBoard().get(game.figur.x,game.figur.y).getCard().putTreasure(null);
                            game.figur.treasure=null;
                            GPokus.this.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                             game.changePlayer();
                        }
                    }
                  
                break;
                case 40:
                    
                    if (game.figur.move(MazeCard.CANGO.DOWN)){
                        game.setFaze(2);
                         MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                        if (game.figur.treasure.equals(card.poklad)){
                            game.getBoard().get(game.figur.x,game.figur.y).getCard().putTreasure(null);  
                            game.figur.treasure=null;
                            GPokus.this.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                             game.changePlayer();
                        }
                    }
               
                break;
            }
        }
    }
}
