/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Card;

// some things to think about, do we want burpees displayed together or seperate?
// need to figure out how this will play out in play game

/**
 *
 * @author macbookretina2015
 */
public class WildCard extends Card {
    
    public WildCard(Colors color, Card.Ranks rank) {
        super(color, rank);
    }

    /**
     * The presence of this card will add 4 burpees to the round of exercises
     */
    public void displayWild(Hand hand) {
        
        // NOTE: check and call before displaying reps as well
        
        int numberOfWildCards = hand.countItemByRank(Card.Ranks.WILD);
        System.out.println(numberOfWildCards * 4 + " Burpees");
        
    }
    
    /**
     * Adds 4 the burpees and multiplies by 4 the total of each color in the hand
     */
    public void displayWild4(Hand hand) {
        
        // NOTE: check and call before displaying reps
        
        // tricky part is multiplying exercises
        // solution: have reps passed, multiply, return new reps as int array
        
        int numberOfWild4Cards = hand.countItemByRank(Card.Ranks.WILDFOUR);
        System.out.println(numberOfWild4Cards * 4 + " Burpees");
        
    }
}
