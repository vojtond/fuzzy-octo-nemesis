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
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author Pikachu
 */
public class GameAppFrame {
    private JFrame frame;
    public Pokus game;
    private GPokus gp;
        private final JMenuBar menuBar;
    public GameAppFrame(Pokus game){
        this.game=game;
                JMenu menu;
        JMenuItem menuItem;
        frame=new JFrame("vojtíšek + mareček");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(0,0);
        gp=new GPokus(game);
    
        frame.getContentPane().add(gp,BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
        
         menuBar = new JMenuBar();
        menu = new JMenu("File");
        menuBar.add(menu);
      
        menuItem = new JMenuItem("New Game");
      
        menuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              System.out.print("asd");
              frame.removeAll();
               frame.setVisible(false);
             GameAppFrame g= new GameAppFrame(new Pokus());
            }
            
        });
        menu.add(menuItem);
        
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
        
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);
    }
}
