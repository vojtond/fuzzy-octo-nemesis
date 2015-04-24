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
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

/**
 *
 * @author Pikachu
 */
public class GameAppFrame {
    private JFrame frame;
    public Pokus game;
    private GPokus gp;
    private static GameSave save;
        private final JMenuBar menuBar;
        byte[] byteData;
    public GameAppFrame(Pokus game) throws IOException{
        this.game=game;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this.game);
        oos.flush();
        oos.close();
        bos.close();
        this.byteData = bos.toByteArray();
       
        GameAppFrame.save=new GameSave();
        
                JMenu menu;
        JMenuItem menuItem;
        frame=new JFrame("vojtíšek + mareček");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        gp=GPokus.newGPokus(game);
    
        frame.getContentPane().add(gp,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        
         menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
        JMenu submenu;
        submenu = new JMenu("New Game");
        submenu.setMnemonic(KeyEvent.VK_S);
        
        ButtonGroup group=new ButtonGroup();
        menuItem=new Gradiomenu("velikost 5");
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        //menuItem.setMnemonic(KeyEvent.VK_R);
        group.add(menuItem);
        submenu.add(menuItem);
        JRadioButton radiobutton=new JRadioButton("velikost 7");
        radiobutton.setSelected(true);
        
        //menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        group.add(radiobutton);
        submenu.add(radiobutton);
        menuItem=new Gradiomenu("velikost 9");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        group.add(menuItem);
        submenu.add(menuItem);
        menuItem=new Gradiomenu("velikost 11");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
        group.add(menuItem);
        submenu.add(menuItem);
       
        /*submenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            GameAppFrame.this.frame.setVisible(false);
                try {
                    GameAppFrame ff=new GameAppFrame(Pokus.NewPokus(4,7));
                } catch (IOException ex) {
                    Logger.getLogger(GameAppFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
    
           
                 
            
            }
            
        });*/
         submenu.addSeparator();
       menuItem = new JMenuItem("2 hraci");
         menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("2hraci");
                
             
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
        menuItem = new JMenuItem("Save Game");
       
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
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }
 
   
   
}
