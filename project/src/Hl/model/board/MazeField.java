/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model.board;

import Hl.model.treasure.Treasure;
import java.io.Serializable;

/**
 *
 * @author Pikachu
 */

public class MazeField implements Serializable{
    private int row;
    private int col;
    private MazeCard Rock;
   
    public int row(){
        return row;
    } 
    public int col(){
        return col;
    }
    public MazeField(int row, int col){
        this.row=row;
        this.col=col;
        
    }
    public void putCard(MazeCard c){
        Rock=c;
    }
    public MazeCard getCard(){
        return Rock;
    }
  
}
