/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.GUI;

import Hl.model.Pokus;
import Hl.model.board.MazeFigur;
import Hl.model.treasure.Treasure;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author Pikachu
 */

public class GObtainedTreasure extends JPanel{
    public List<JLabel> TreasureLabel=new ArrayList<>();
    public GObtainedTreasure(Pokus game,String name){
          double ratio,rH,rW;
        int gH,gW;
         int height=60;
        int width=600;
        rH=(double)60/60;
        rW=(double)600/600;
        ratio=rH>1 ? 1:rH;
        ratio=rW>1 ? ratio : ( rW > rH ? rH : rW);
        gH=(int)(height*ratio);
        gW=(int)(width*ratio);
        Dimension dim=new Dimension (gH,gW);
        this.setPreferredSize(dim);
        this.setSize(dim);
        this.setOpaque(true);
        this.setLayout(null);
        this.setLayout(new GridLayout(10,1));
        this.setBackground(Color.WHITE);
        JLabel nam=new JLabel(name);
        nam.setHorizontalAlignment(JLabel.CENTER);
        this.add(nam);
       // this.setLocation(0, 60);
    }
    public void addTresure(Treasure treasure){
        ImageIcon icon=new ImageIcon(""+treasure.Gcode+".png");
        JLabel label=new JLabel();
        label.setIcon(icon);
        label.setSize(60, 60);
        this.add(label);
    }
}
