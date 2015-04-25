/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;
import javax.swing.JFrame;
import Hl.model.Pokus;
import java.awt.BorderLayout;
import Hl.GUI.GPokus;
import Hl.GameSave;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import Hl.Main;
import Hl.model.board.MazeCard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/**
 *
 * @author Pikachu
 */
public class GameAppFrame {
    private JFrame frame;
    public Pokus game;
    public boolean firstGame;
    private GPokus gp;
    private static GameSave save;
        private final JMenuBar menuBar;
        public static GameAppFrame Appframe ;
    public GameAppFrame.figurKeyEvent f;
        byte[] byteData;
    public static GameAppFrame  newGameAppFrame() throws IOException{
        Appframe=new GameAppFrame();
        return Appframe;
    }    
    public void  newAppFrame(Pokus game){
        this.game=game;
        gp=GPokus.newGPokus(game);
        frame.setContentPane(gp);
          frame.pack();
          frame.setFocusable(true);
          frame.requestFocusInWindow();
        
        
            frame.removeKeyListener(f);
            
          f=new GameAppFrame.figurKeyEvent();
          frame.addKeyListener(f);
    }
    private GameAppFrame() throws IOException{
        
      /*  ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this.game);
        oos.flush();
        oos.close();
        bos.close();
        this.byteData = bos.toByteArray();
       
        GameAppFrame.save=new GameSave();*/
         double ratio,rH,rW;
        int gH,gW;
        firstGame=true;
        f=null;
        
                JMenu menu;
        JMenuItem menuItem;
        frame=new JFrame("vojtíšek + mareček");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        JPanel panel=new JPanel();
       
        rH=(double)1000/1000;
        rW=(double)1000/1000;
        ratio=rH>1 ? 1:rH;
        ratio=rW>1 ? ratio : ( rW > rH ? rH : rW);
        gH=(int)(1000*ratio);
        gW=(int)(1000*ratio);
        Dimension dim=new Dimension (gH,gW);
       
        frame.getContentPane().setPreferredSize(dim);
        frame.getContentPane().setSize(dim);

   
        
        frame.setVisible(true);
        frame.pack();
         menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        JMenu submenu;
        submenu = new JMenu("New Game");
        
        
        ButtonGroup group=new ButtonGroup();
         JRadioButton radiobutton;
        radiobutton=new JRadioButton("velikost 5");
        radiobutton.setActionCommand("5");
        group.add(radiobutton);
        submenu.add(radiobutton);
        radiobutton=new JRadioButton("velikost 7");
        radiobutton.setSelected(true);
 
        radiobutton.setActionCommand("7");
        group.add(radiobutton);
        submenu.add(radiobutton);
        radiobutton=new JRadioButton("velikost 9");
   
        radiobutton.setActionCommand("9");
    
        group.add(radiobutton);
        submenu.add(radiobutton);
         radiobutton=new JRadioButton("velikost 11");
     
         radiobutton.setActionCommand("11");
     
        group.add(radiobutton);
        submenu.add(radiobutton);
       
     
         submenu.addSeparator();
       menuItem = new JMenuItem("2 hraci");
         menuItem.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 GameAppFrame.this.game=null;
                 GameAppFrame.this.gp=null;
                 System.gc();
                 System.out.print("blop\n");
                 
                 
            //     System.gc();
                //char c=.charAt(0);
                //int i=Character.getNumericValue(c);
                int i = Integer.parseInt(group.getSelection().getActionCommand());
              JFieldTextDemo k=new JFieldTextDemo(2,i);
                    //GameAppFrame.this.newAppFrame(Pokus.NewPokus(2,i)) ;
               
    
             
            }
            
        });
         
         submenu.add(menuItem);
         menuItem = new JMenuItem("3 hraci");
         menuItem.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 GameAppFrame.this.game=null;
                 GameAppFrame.this.gp=null;
                 System.gc();
              //   System.gc();
                  int i = Integer.parseInt(group.getSelection().getActionCommand());
              JFieldTextDemo k=new JFieldTextDemo(3,i);
    
             
            }
            
        });
         
         submenu.add(menuItem);
         menuItem = new JMenuItem("4 hraci");
         menuItem.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                 GameAppFrame.this.game=null;
                 GameAppFrame.this.gp=null;
                 System.gc();
                // System.gc();
              int i = Integer.parseInt(group.getSelection().getActionCommand());
              JFieldTextDemo k=new JFieldTextDemo(4,i);
    
             
            }
            
        });
         
         submenu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Exit");
       
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print(e.getID());
                frame.setVisible(false);
                System.exit(0);
            }
            
        });
        menu.add(menuItem);
         menu.add(submenu);
        menu.addSeparator();
      /*  menuItem = new JMenuItem("Save Game");
       
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   ByteArrayInputStream bais = new ByteArrayInputStream(GameAppFrame.this.byteData);
                   Pokus savegame = null;
                   savegame = (Pokus) new ObjectInputStream(bais).readObject();
                   GameAppFrame.save.game=savegame;
                   Main.serializaceDataOut(GameAppFrame.save);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(GameAppFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                 
            }
            
        });
        menu.add(menuItem);
         menu.add(menuItem);
        menu.addSeparator();
        menuItem = new JMenuItem("Load Game");
       
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                   
                    GameSave S=Main.serializeDataIn();
                    GameAppFrame ff=new GameAppFrame(S.game);
                } catch (IOException | ClassNotFoundException ex) {
                    Logger.getLogger(GameAppFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                 
            }
            
        });
        menu.add(menuItem);
        menuBar.add(menu);*/
        frame.setJMenuBar(menuBar);
    }
 
   public class figurKeyEvent extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e){
             
            switch (e.getKeyCode()){
                case 10:                   
                    game.changePlayer();
                    MazeCard carda=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                    if (game.figur.treasure.equals(carda.poklad)){
                           
                            carda.putTreasure(null);
                            game.figur.treasure=null;
                            GameAppFrame.this.gp.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(carda);
                             game.changePlayer();
                             frame.repaint();
                       }
             
                    
                break;
                case 37:
                      System.out.print("\n**\n");
                    if (game.figur.move(MazeCard.CANGO.LEFT)){
                       
                       game.setFaze(2);
                       
                       MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                       if (game.figur.treasure.equals(card.poklad)){
                             game.figur.AddObtainedTreasure(game.figur.treasure);                
                            card.putTreasure(null);
                            game.figur.treasure=null;
                            
                            GameAppFrame.this.gp.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                             game.changePlayer();
                 
                             frame.repaint();
                       }
                    }
                  
                break;
                case 38:
                     
                    if (game.figur.move(MazeCard.CANGO.UP)){
                        game.setFaze(2);
                         MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                        if (game.figur.treasure.equals(card.poklad)){
                             game.figur.AddObtainedTreasure(game.figur.treasure);
                          // gp.gobtainedtreasure[game.HracNaTahu].addTresure(game.figur.treasure);
                            game.getBoard().get(game.figur.x,game.figur.y).getCard().putTreasure(null);
                            game.figur.treasure=null;
                          GameAppFrame.this.gp.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                            game.changePlayer();
                      
                            frame.repaint();
                        }
                        }
                
                break;
                case 39:
                    
                    if (game.figur.move(MazeCard.CANGO.RIGHT)){
                        game.setFaze(2);
                         MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                        if (game.figur.treasure.equals(card.poklad)){
                             game.figur.AddObtainedTreasure(game.figur.treasure);
                             System.out.print(game.figur.obtainedTreasure);
                            //gp.gobtainedtreasure[game.HracNaTahu].addTresure(game.figur.treasure);
                            game.getBoard().get(game.figur.x,game.figur.y).getCard().putTreasure(null);
                            game.figur.treasure=null;
                            GameAppFrame.this.gp.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                             game.changePlayer();
                             
                
                    frame.repaint();
                        }
                    }
                  
                break;
                case 40:
                    
                    if (game.figur.move(MazeCard.CANGO.DOWN)){
                        game.setFaze(2);
                         MazeCard card=game.getBoard().get(game.figur.x,game.figur.y).getCard();
                        if (game.figur.treasure.equals(card.poklad)){
                             game.figur.AddObtainedTreasure(game.figur.treasure);
                         
                            game.getBoard().get(game.figur.x,game.figur.y).getCard().putTreasure(null);  
                            game.figur.treasure=null;
                            GameAppFrame.this.gp.Gdeska.getField(game.figur.x-1,game.figur.y-1).setImage(card);
                             game.changePlayer();
                     //         gp.tah.setText(game.figur.name);
                    //gp.tah.setIcon(gp.Gfigura.get(game.HracNaTahu).getIcon());
                             frame.repaint();
                        }
                    }
               
                break;
            }
        }
    }
   
}
