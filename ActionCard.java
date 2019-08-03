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
public class ActionCard extends Card {
    
    protected ActionCard.Ranks rank;

    public ActionCard(Colors color, Card.Ranks rank) {
        super(color, rank);
    }
    
    protected enum Ranks 
    { 
        DRAWTWO, SKIP, REVERSE; 
    } 
    
    
    public Hand skip(Hand hand) {
        return hand;
    }
    
    public Hand drawTwo(Hand hand) {
        return hand;
    }
    
    public Pile reverse(Hand hand, Pile pile) {
        return pile;
    }
    
    public void displaySkip() {
        
    }
    
    public void displayDrawTwo() {
        
    }
    
    public void displayReverse() {
        
    }
    
    /* 
    gives arrow, need to use generics or make both types string
    
    @Override
    public String getRank() {
        return this.rank;
    }
    
    */ 
    
    /* inherits getColor */
    

}
