/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Card;
import static java.util.Comparator.comparing;

import java.util.Objects;
import java.util.Random;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author sundeep
 */

 

 public class Hand implements Comparable<Hand>{
    
     private Card[] cardsInHand = new Card[7];
     private String color;
     private String value;
     private Pile pile;
    
    LinkedList<Card> LL = new LinkedList<Card>();
    
     Card getRank;
    
     Card getcolor;
    
     //public final static String [] values = {"1","2","3","4","5","6","7","8","9","10","skip","draw2","reverse"};
       // public final static String [] colors = {"red", "blue", "Green", "Yellow"};
       
   
    public Hand sortHand(String color, String value){
       
        Hand sortedHand = new Hand();
        // Calling a predefined sort method. Works on arrays
        Arrays.sort(cardsInHand);

        System.out.println("Sorted deck:");
        for (Card card: cardsInHand) {
            System.out.println(card);
        }
        return sortedHand;
    }
   
    /**
     *
     * @return
     */
    
    
    public int calculateExercises() {
       
   
        int repsList = 0;
        return repsList;
    }
   
    /* puts cards in hand */
    public void drawHand() {
       
    }
   
    public void displaySortedHand() {
        for (Card i: this.cardsInHand) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }

    
    public int handLength() {
        return this.LL.size();
    }
    
    public int countItemByRank(Card.Ranks rank) {
        int count = 0;
        for (int i = 0; i < this.LL.size(); i++) {
            if (this.LL.get(i).getRank() == rank) {
                count++;
            }
        }
        
        return count;
    }
    

    @Override
    public int compareTo(Hand o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
