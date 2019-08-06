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
    
    @Override
    public WildCard getCard() {
        WildCard copy = this;
        return copy;
    }
    
    public WildCard(Colors color, Card.Ranks rank) {
        super(color, rank);
    }
    
    public WildCard() {
        super();
    }

    /**
     * The presence of this card will add 4 burpees to the round of exercises 
     * for each wild AND wild4 card
     */
    public int displayWildEffects(Hand hand) {
        
        // NOTE: check and call before displaying reps as well
        
        int numberOfWildCards = hand.countItemByRank(Card.Ranks.WILD);
        numberOfWildCards += hand.countItemByRank(Card.Ranks.WILDFOUR);
        
        return numberOfWildCards * 4;
        
    }
    
    /**
     * multiplies by 4 the total of each color in the hand
     */
    public void Wild4(Hand hand, int[] repsList) {
        
        // NOTE: check and call before displaying reps
        
        // tricky part is multiplying exercises
        // solution: have reps passed, multiply, return new reps as int array

        
        for (int i = 0; i < 4; i++) { 
            repsList[i] *= 4; 
        }
        
    }
    
        /**
     * Displays the effect of the draw two
     */
    public void displayWildFour() {
        System.out.println("Wild4 Card - Multiplies by 4 the total of each color "
                + "and then adds 4 burpees");
    }
    
    /**
     * Displays the effect of the display reverse
     */
    public void displayWild() {
        System.out.println("Wild Card - 4 burpees added");
    }
}
