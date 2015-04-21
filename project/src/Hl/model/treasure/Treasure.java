/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model.treasure;

import Hl.model.board.MazeFigur;
import java.io.Serializable;


/**
 *
 * @author xbastl03
 */
public class Treasure implements Serializable{
    final public int code;
    static Treasure[] poklady; 
   
    static int pocet=24;     
    private Treasure(int code){
        this.code=code;   
    }
    /**
     * Vytvori poklady
     */
    public static void createSet(){
               
        poklady=new Treasure[pocet];       
        for (int i=0;i<pocet;i++){   
           poklady[i]=new Treasure(i);  
      
        }
    }
    /**
     * Vratí poklad s codem code
     */
    public static Treasure getTreasure(int code){
        if (code<pocet){
            return poklady[code];
        }else return null;
    }
}
