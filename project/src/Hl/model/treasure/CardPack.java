/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hl.model.treasure;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author xbastl03
 */

public class CardPack implements Serializable{
    ArrayList<TreasureCard> PackOfCard=new ArrayList<TreasureCard>();
   
    private static int maxSizePack;
    private static int SizePack;
    /**
    * vytvori balice karet o poctu initSize a maximalniho poctu maxSize
    */
    public CardPack(int maxSize,int initSize){
        if (maxSize>=initSize){
            maxSizePack=maxSize;
            SizePack=initSize;             
            for (int i=0;i<initSize;i++){  /*dokud neni initSize karet*/             
               TreasureCard TreasureIn=new TreasureCard(Treasure.getTreasure(i));
               PackOfCard.add(TreasureIn);               
            }
        }
    }
    /**
     * vybere vrchni kartu z balicku
     */
    public TreasureCard popCard(){
        TreasureCard pom;
        pom=null;
        if (SizePack>0){/*pokud jeste existuje karta v balicku*/
            pom=PackOfCard.get(0);    
            PackOfCard.remove(0);
            SizePack--;
        }
        return pom;
    }
    /**
     * vrati pocet karet v balicku
     */
    public int size(){        
        return PackOfCard.size();       
    }
    /**
     * zanicha balicek
     */
    public void shuffle(){
      Collections.shuffle(PackOfCard);
    }
}
