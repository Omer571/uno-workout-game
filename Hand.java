/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

/**
 *
 * @author macbookretina2015
 */
public class Hand {
    private Card[] cardsInHand = new Card[7];
    
    public Hand sortHand() {
        Hand sortedHand = new Hand();
        return sortedHand;
    }
    
    public int[] calculateExercises() {
        int[] repsList = new int[4];
        return repsList;
    }
    
    /* puts cards in hand */
    public void drawHand(Pile pile) {
        
    }
    
    public void displaySortedHand() {
        for (Card i: this.cardsInHand) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
