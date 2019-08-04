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
    
    /**
     * All the cards of this color that are in the hand are discarded 
     * for this round
     * @param hand The hand object we are working with 
     * @return Hand This returns new hand after skip performed
     */
    public Hand skip(Hand hand) {
        
        return hand;
    }
    
    /**
     * The Total number of the matching color is multiplied by 2
     * @param hand The hand object we are working with 
     * @return Hand
     */
    public Hand drawTwo(Hand hand) {
        return hand;
    }
    
    /**
     * All the matching color cards are a return to the bottom of the draw 
     * pile except “Reverse”card. 
     * @param hand The hand object we are working with 
     * @param pile The pile object we are working with
     * @return Pile This returns the pile, BUT WE NEED TO ALSO EDIT HAND
     */
    public Pile reverse(Hand hand, Pile pile) {
        /* MAKE HAND REVERSE FUNCTION WHICH IS CALLED HERE */
        return pile;
    }
    
    /**
     * Displays the effect of the skip card
     */
    public void displaySkip() {
        System.out.println("Skip Card - All the cards of this skip's color that "
                + "are in the hand are discarded for this round");
    }
    
    /**
     * Displays the effect of the draw two
     */
    public void displayDrawTwo() {
        System.out.println("DrawTwo Card - The Total number of the matching "
                + "color is multiplied by 2");
    }
    
    /**
     * Displays the effect of the display reverse
     */
    public void displayReverse() {
        System.out.println("Reverse Card - All the matching color cards are a " 
                + " return to the bottom of the draw pile except"
                + " “Reverse\" card");
    }
    

}
