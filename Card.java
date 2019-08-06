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
    
    public Card(Card.Colors color, Card.Ranks rank) {
        this.color = color;
        this.rank = rank;
    }
    
    public Card() {
        
    }
    
    public Card.Colors getColor() {
        return this.color;
    }
    
    public Card getCard() {
        Card copy = new Card();
        return copy;
    }
    
    public void setCard(Card card) {
        
        this.setColor(card.getColor());
        this.setRank(card.getRank());
    }
    
    /* checks if break (0 card) and if so print 1 minute break */
    public void displayBreak() {
        
        if (rank == Card.Ranks.ZERO) {
            System.out.println("\nOne Minute Break...\n"); 
        } 
           
    }
    
    public Card.Ranks getRank() {
        return this.rank;
    }
    
    public void setRank(Card.Ranks cardNum) {
        this.rank = cardNum;
    }
    
    public void setColor(Card.Colors color) {
        this.color = color;
    }
}

