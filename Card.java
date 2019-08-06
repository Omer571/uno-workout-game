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
public class Card {

    // enumerated colors
    protected enum Colors 
    { 
        RED, GREEN, YELLOW, BLUE ,NONE; 
    } 
    // enumerated ranks
    protected enum Ranks 
    {
        ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,NINE, DRAWTWO, SKIP, REVERSE, WILD, WILDFOUR;

    }
    
    protected Card.Colors color;
    protected Card.Ranks rank;
    /**
     * initializing color and rank
     * @param color
     * @param rank 
     */
    public Card(Card.Colors color, Card.Ranks rank) {
        this.color = color;
        this.rank = rank;
    }
    
    public Card() {
        
    }
   /**
    * gets color of the card
    * @return the color of the card
    */ 
    public Card.Colors getColor() {
        return this.color;
    }
   
    /**
     * 
     * @param card 
     */
    public void setCard(Card card) {
        
        this.setColor(card.getColor());
        this.setRank(card.getRank());
    }
    /**
     * 
     * @return a copy of the card
     */
    public Card getCard() {
        Card copy = new Card();
        return copy;
    }
    
    /**
     * checks if break (0 card) and if so print 1 minute break 
     */
    public void displayBreak() {
        
        if (rank == Card.Ranks.ZERO) {
            System.out.println("\nOne Minute Break...\n"); 
        } 
           
    }
    /**
     * gets the rank of the card
     * @return rank
     */
    public Card.Ranks getRank() {
        return this.rank;
    }
    
    public void setRank(Card.Ranks cardNum) {
        this.rank = cardNum;
    }
    /**
     * 
     * @param color 
     */
    public void setColor(Card.Colors color) {
        this.color = color;
    }
}

