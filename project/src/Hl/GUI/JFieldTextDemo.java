/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;

import Hl.model.Pokus;
import Hl.model.board.MazeFigur;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class JFieldTextDemo extends JFrame {
        public static int hracuchybi=-1; 
         public static int pocethracu=-1; 
         public List<String> figuraname=new ArrayList<>();
	//Class Declarations
	JTextField jtfText1;
	String disp = "";
	TextHandler handler = null;
        public static int velikost;
	//Constructor
	public JFieldTextDemo(int pocethracu, int velikost) {
		super("player");
                JFieldTextDemo.velikost=velikost;
                hracuchybi=pocethracu;
                    JFieldTextDemo.pocethracu=pocethracu;
		Container container = getContentPane();
		container.setLayout(new FlowLayout());
		jtfText1 = new JTextField(10);
		
		container.add(jtfText1);
		
		handler = new TextHandler();
		jtfText1.addActionListener(handler);
		
		setSize(325, 100);
		setVisible(true);
	}
	//Inner Class TextHandler
	private class TextHandler implements ActionListener {

                @Override
		public void actionPerformed(ActionEvent e) {
			//if (e.getSource() == jtfText1) {
                        System.out.print(JFieldTextDemo.hracuchybi+"***\n");
                                JFieldTextDemo.hracuchybi--;
                                if (JFieldTextDemo.hracuchybi>0){
                                
                                    System.out.print("aaa\n");
                                    JFieldTextDemo.this.figuraname.add(e.getActionCommand());
                                    JFieldTextDemo.this.jtfText1.setText("");
                                    
                                   
                                }else {
                                     JFieldTextDemo.this.figuraname.add(e.getActionCommand());
                                    JFieldTextDemo.this.setVisible(false);
                                    GameAppFrame.Appframe.newAppFrame(Pokus.NewPokus(JFieldTextDemo.pocethracu,JFieldTextDemo.velikost,JFieldTextDemo.this.figuraname));
                                }
			//} 
			
		}
	}
}